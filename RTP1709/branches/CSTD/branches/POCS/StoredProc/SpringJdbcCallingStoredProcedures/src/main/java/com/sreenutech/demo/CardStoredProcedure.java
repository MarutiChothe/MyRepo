package com.sreenutech.demo;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

/**
 * An access class for the Card stored procedures. This interface expects the
 * following args for the store procedures
 *
 * <ul>
 * <li>arg1 (in): cardno
 *
 * <li>arg5 (out): return code
 * <li>arg6 (out): return message
 * </ul>
 *
 * </pre>
 *
 */
public class CardStoredProcedure extends StoredProcedure {

	/**
	 * Constructor for this StoredProcedure class.
	 */
	@SuppressWarnings("rawtypes")
	public CardStoredProcedure(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "validateCard");

		// Parameters should be declared in same order here that
		// they are declared in the stored procedure.
		//
		// Note: resultSet must be defined first!
		//
		// define params with syntax: param_name, param_type
		//
		RowMapper rowMapper = new CardRowMapper();
		declareParameter(new SqlParameter(DAOConstants.CARD_NO, Types.BIGINT));
		
		declareParameter(new SqlOutParameter(DAOConstants.RETURN_CODE,
				Types.VARCHAR));
		declareParameter(new SqlOutParameter(DAOConstants.RETURN_MESSAGE,
				Types.VARCHAR));

		// now compile stored proc
		compile();
	}

	/**
	 * Execute stored procedure.
	 *
	 * @return Results of running stored procedure.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map validateCard(long cardno) {
 
        // set the input params
        Map inParameters = new HashMap();
        inParameters.put(DAOConstants.CARD_NO, cardno);
 
        // now execute
		Map out = execute(inParameters); // Call on parent class
 
        return out;
    }
}