package com.xinguoren.coolpen.cloud.web.common;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * 分页插件
 */
@Intercepts(
        {@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PagePlugin implements Interceptor {
    //    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];//当前环境 MappedStatement，BoundSql，及sql取得
        Object parameter = invocation.getArgs()[1];//获取参数
        //判断mapper对应方法参数是否为空
        if (parameter != null) {
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);
            String originalSql = boundSql.getSql().trim();//获取查询语句
            Object parameterObject = boundSql.getParameterObject();
            Page page = getPageParameter(parameterObject);
            if (page != null) {
                String pageSql = buildPageSql(originalSql, page);
                System.out.println("分页语句：" + pageSql);
                //新的MappedStatement
                BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), pageSql, boundSql.getParameterMappings(), parameterObject);
                MappedStatement newMappedStatement = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));


                String countSql = getcountSql(originalSql);
                BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, boundSql.getParameterMappings(), parameterObject);
                MappedStatement countMappedStatement = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(countBoundSql));
                Connection connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
                BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql, boundSql.getParameterMappings(), parameterObject);
                DefaultParameterHandler parameterHandler = new DefaultParameterHandler(countMappedStatement, parameterObject, countBS);
                PreparedStatement countStmt = connection.prepareStatement(countSql);
                parameterHandler.setParameters(countStmt);
                ResultSet rs = countStmt.executeQuery();
                int records = 0;
                if (rs.next()) {
                    records = rs.getInt(1);
                }
                rs.close();
                countStmt.close();
                connection.close();
                page.setRecordTotal(records);//总记录数
                int pageTotal = 0;
                if (records % page.getPageSize() > 0) {
                    pageTotal = records / page.getPageSize() + 1;
                } else {
                    pageTotal = records / page.getPageSize();
                }
                page.setPageTotal(pageTotal);//总页数
                invocation.getArgs()[0] = newMappedStatement;
            }
        }
        return invocation.proceed();
    }

    /**
     * plugin方法是拦截器用于封装目标对象的
     */
//    @Override
    public Object plugin(Object object) {
        return Plugin.wrap(object, this);
    }

    //    @Override
    public void setProperties(Properties properties) {

    }

    private Page getPageParameter(Object parameterMap) {
        Page page = null;
        if (Page.class.isAssignableFrom(parameterMap.getClass())) {//判断Page类是否是参数类型的父类或接口或者相同
            page = (Page) parameterMap;
        }

        if (parameterMap instanceof Map) {
            Iterator iter = ((Map) parameterMap).entrySet().iterator();
            boolean isPageSql = false;
            while (iter.hasNext() && !isPageSql) {
                Entry e = (Entry) iter.next();
                if (Page.class.isAssignableFrom(e.getValue().getClass())) {
                    isPageSql = true;
                    page = (Page) e.getValue();
                }
            }
        }
        return page;
    }

    private String buildPageSql(String sql, Page page) {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append("select * from ");
        strBuf.append("(select rownum r,temp.*  from ");
        strBuf.append("(").append(sql).append(") temp");
        strBuf.append(" where rownum<=").append(page.getPageNo() * page.getPageSize()).append(")");
        strBuf.append(" where r>").append((page.getPageNo() - 1) * page.getPageSize());
        return strBuf.toString();
    }

    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        Builder builder = new Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    public static class BoundSqlSqlSource implements SqlSource {
        private BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        //        @Override
        public BoundSql getBoundSql(Object arg0) {
            return boundSql;
        }
    }

    public String getcountSql(String originalSql) {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append("select count(*) from (");
        strBuf.append(originalSql);
        strBuf.append(")");
        return strBuf.toString();
    }
}
