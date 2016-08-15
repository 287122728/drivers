package com.drivers.jdbc;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Tietang Wang
 *         Created by MacBook Pro on 2014/12/26.
 */
public class JdbcTemplateExt extends JdbcTemplate implements NamedParameterJdbcOperations {

    /**
     * The NamedParameterJdbcTemplate that we are wrapping
     */
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;


    /**
     * Create a new MyJdbcTemplate for the given DataSource.
     * <p>Creates a classic Spring JdbcTemplate and wraps it.
     *
     * @param dataSource the JDBC DataSource to access
     */
    public JdbcTemplateExt(DataSource dataSource) {
        super(dataSource);
        this.namedParameterJdbcOperations = new NamedParameterJdbcTemplate(this);
    }

    /**
     * Construct a new JdbcTemplate, given a DataSource to obtain connections from.
     * <p>Note: Depending on the "lazyInit" flag, initialization of the exception translator
     * will be triggered.
     *
     * @param dataSource the JDBC DataSource to obtain connections from
     * @param lazyInit   whether to lazily initialize the SQLExceptionTranslator
     */
    //    public JdbcTemplateExt(DataSource dataSource, boolean lazyInit) {
    //        setDataSource(dataSource);
    //        setLazyInit(lazyInit);
    //        afterPropertiesSet();
    //        this.namedParameterJdbcOperations = new NamedParameterJdbcTemplate(this);
    //
    //    }


    /**
     * Expose the classic Spring JdbcTemplate to allow invocation of
     * less commonly used methods.
     */
    public JdbcOperations getJdbcOperations() {
        return this.getNamedParameterJdbcOperations().getJdbcOperations();
    }

    /**
     * Expose the Spring NamedParameterJdbcTemplate to allow invocation of
     * less commonly used methods.
     */
    public NamedParameterJdbcOperations getNamedParameterJdbcOperations() {
        return this.namedParameterJdbcOperations;
    }

    public <T> T queryForObject(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        List<T> results = this.query(sql, (RowMapper) rowMapper);
        return singleValue(results);
    }

    public <T> T queryForObject(
            String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper) throws DataAccessException {

        List<T> results = query(sql, args, argTypes, new RowMapperResultSetExtractor<T>(rowMapper, 1));
        return singleValue(results);
    }

    public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper) throws DataAccessException {
        List<T> results = query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1));
        return singleValue(results);
    }

    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) throws DataAccessException {
        List<T> results = query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1));
        return singleValue(results);
    }

    private <T> T singleValue(Collection<T> results) {
        if (results == null || results.size() == 0) {
            return null;
        } else {
            return results.iterator().next();
        }
    }

    public int queryForInt(String sql, Object... args) throws DataAccessException {
        List<Integer> results = query(sql, args, getSingleColumnRowMapper(Integer.class));
        return singleValue(results);
    }

    public long queryForLong(String sql, Object... args) throws DataAccessException {
        List<Long> results = query(sql, args, getSingleColumnRowMapper(Long.class));
        return singleValue(results);
    }

    @Deprecated
    public int queryForInt(String sql, Map<String, ?> args) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForObject(sql, args, Integer.TYPE);
    }

    @Deprecated
    public int queryForInt(String sql, SqlParameterSource args) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForObject(sql, args, Integer.TYPE);
    }

    @Deprecated
    public long queryForLong(String sql, Map<String, ?> args) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForObject(sql, args, Long.TYPE);
    }

    @Deprecated
    public long queryForLong(String sql, SqlParameterSource args) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForObject(sql, args, Long.TYPE);
    }

    //    @Deprecated
    //    public <T> T queryForObject(String sql, Class<T> requiredType, Map<String, ?> args) throws DataAccessException {
    //        return getNamedParameterJdbcOperations().queryForObject(sql, args, requiredType);
    //    }
    //
    //    @Deprecated
    //    public <T> T queryForObject(String sql, Class<T> requiredType, SqlParameterSource args) throws DataAccessException {
    //        return getNamedParameterJdbcOperations().queryForObject(sql, args, requiredType);
    //    }
    //
    //    @Deprecated
    //    public <T> T queryForObject(String sql, RowMapper<T> rm, Map<String, ?> args) throws DataAccessException {
    //        return getNamedParameterJdbcOperations().queryForObject(sql, args, rm);
    //    }
    //
    //    @Deprecated
    //    public <T> T queryForObject(String sql, RowMapper<T> rm, SqlParameterSource args) throws DataAccessException {
    //        return getNamedParameterJdbcOperations().queryForObject(sql, args, rm);
    //    }
    //
    //    @Deprecated
    //    public <T> List<T> query(String sql, RowMapper<T> rm, Map<String, ?> args) throws DataAccessException {
    //        return getNamedParameterJdbcOperations().query(sql, args, rm);
    //    }
    //
    //    @Deprecated
    //    public <T> List<T> query(String sql, RowMapper<T> rm, SqlParameterSource args) throws DataAccessException {
    //        return getNamedParameterJdbcOperations().query(sql, args, rm);
    //    }
    public Long updateAndGetKey(final String sql, final Object... params) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int updated = update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
                return preparedStatement;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Deprecated
    public Map<String, Object> queryForMap(String sql, Map<String, ?> args) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForMap(sql, args);
    }

    @Deprecated
    public Map<String, Object> queryForMap(String sql, SqlParameterSource args) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForMap(sql, args);
    }

    @Deprecated
    public List<Map<String, Object>> queryForList(String sql, Map<String, ?> args) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForList(sql, args);
    }

    @Deprecated
    public List<Map<String, Object>> queryForList(String sql, SqlParameterSource args) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForList(sql, args);
    }

    @Deprecated
    public int update(String sql, Map<String, ?> args) throws DataAccessException {
        return getNamedParameterJdbcOperations().update(sql, args);
    }

    @Deprecated
    public int update(String sql, SqlParameterSource args) throws DataAccessException {
        return getNamedParameterJdbcOperations().update(sql, args);
    }

    @Deprecated
    public int[] batchUpdate(String sql, Map<String, ?>[] batchValues) {
        return getNamedParameterJdbcOperations().batchUpdate(sql, batchValues);
    }

    @Deprecated
    public int[] batchUpdate(String sql, SqlParameterSource[] batchArgs) {
        return getNamedParameterJdbcOperations().batchUpdate(sql, batchArgs);
    }

    @Deprecated
    @Override
    public <T> T execute(
            String sql,
            SqlParameterSource paramSource,
            PreparedStatementCallback<T> action) throws DataAccessException {
        return getNamedParameterJdbcOperations().execute(sql, paramSource, action);
    }

    @Deprecated
    @Override
    public <T> T execute(
            String sql, Map<String, ?> paramMap, PreparedStatementCallback<T> action) throws DataAccessException {
        return getNamedParameterJdbcOperations().execute(sql, paramMap, action);
    }

    @Deprecated
    @Override
    public <T> T query(
            String sql, SqlParameterSource paramSource, ResultSetExtractor<T> rse) throws DataAccessException {
        return getNamedParameterJdbcOperations().query(sql, paramSource, rse);
    }

    @Deprecated
    @Override
    public <T> T query(
            String sql, Map<String, ?> paramMap, ResultSetExtractor<T> rse) throws DataAccessException {
        return getNamedParameterJdbcOperations().query(sql, paramMap, rse);
    }

    @Deprecated
    @Override
    public void query(
            String sql, SqlParameterSource paramSource, RowCallbackHandler rch) throws DataAccessException {
        getNamedParameterJdbcOperations().query(sql, paramSource, rch);
    }

    @Deprecated
    @Override
    public void query(
            String sql, Map<String, ?> paramMap, RowCallbackHandler rch) throws DataAccessException {
        getNamedParameterJdbcOperations().query(sql, paramMap, rch);
    }

    @Deprecated
    @Override
    public <T> List<T> query(
            String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper) throws DataAccessException {
        return getNamedParameterJdbcOperations().query(sql, paramSource, rowMapper);
    }

    @Deprecated
    @Override
    public <T> List<T> query(
            String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper) throws DataAccessException {
        return getNamedParameterJdbcOperations().query(sql, paramMap, rowMapper);
    }

    @Deprecated
    @Override
    public <T> T queryForObject(
            String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForObject(sql, paramSource, rowMapper);
    }

    @Deprecated
    @Override
    public <T> T queryForObject(
            String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForObject(sql, paramMap, rowMapper);
    }

    @Deprecated
    @Override
    public <T> T queryForObject(
            String sql, SqlParameterSource paramSource, Class<T> requiredType) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForObject(sql, paramSource, requiredType);
    }

    @Deprecated
    @Override
    public <T> T queryForObject(String sql, Map<String, ?> paramMap, Class<T> requiredType) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForObject(sql, paramMap, requiredType);
    }

    @Deprecated
    @Override
    public <T> List<T> queryForList(
            String sql, SqlParameterSource paramSource, Class<T> elementType) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForList(sql, paramSource, elementType);
    }

    @Deprecated
    @Override
    public <T> List<T> queryForList(
            String sql, Map<String, ?> paramMap, Class<T> elementType) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForList(sql, paramMap, elementType);
    }

    @Deprecated
    @Override
    public SqlRowSet queryForRowSet(
            String sql, SqlParameterSource paramSource) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForRowSet(sql, paramSource);
    }

    @Deprecated
    @Override
    public SqlRowSet queryForRowSet(
            String sql, Map<String, ?> paramMap) throws DataAccessException {
        return getNamedParameterJdbcOperations().queryForRowSet(sql, paramMap);
    }

    @Deprecated
    @Override
    public int update(
            String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder) throws DataAccessException {
        return getNamedParameterJdbcOperations().update(sql, paramSource, generatedKeyHolder);
    }

    @Deprecated
    @Override
    public int update(
            String sql,
            SqlParameterSource paramSource,
            KeyHolder generatedKeyHolder,
            String[] keyColumnNames) throws DataAccessException {
        return getNamedParameterJdbcOperations().update(sql, paramSource, generatedKeyHolder, keyColumnNames);
    }

    protected int update(final PreparedStatementCreator psc, final PreparedStatementSetter pss)
            throws DataAccessException {

        logger.debug("Executing prepared SQL update：");
        return execute(psc, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
                try {
                    if (pss != null) {
                        pss.setValues(ps);
                    }
                    int rows = ps.executeUpdate();
                    if (logger.isDebugEnabled()) {
                        logger.debug("SQL update affected " + rows + " rows");
                    }
                    return rows;
                } finally {
                    if (pss instanceof ParameterDisposer) {
                        ((ParameterDisposer) pss).cleanupParameters();
                    }
                }
            }
        });
    }
    /*
         * Considers an Object array passed into a varargs parameter as
         * collection of arguments rather than as single argument.
         */
    //    private Object[] getArguments(Object[] varArgs) {
    //        if (varArgs.length == 1 && varArgs[0] instanceof Object[]) {
    //            return (Object[]) varArgs[0];
    //        } else {
    //            return varArgs;
    //        }
    //    }

}
