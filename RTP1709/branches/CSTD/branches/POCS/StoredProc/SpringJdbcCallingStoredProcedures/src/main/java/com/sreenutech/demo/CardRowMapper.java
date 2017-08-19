package com.sreenutech.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * This class is used to convert ResultSet records to Domain Objects The class
 * is invoked for each Row in the ResultSet. It implements the Spring RowMapper
 * interface
 */
@SuppressWarnings("rawtypes")
public class CardRowMapper implements RowMapper {

	/**
	 * Maps the result set rows to a Claim object
	 */
	public Object mapRow(ResultSet rs, int index) throws SQLException {

		Card theCard = new Card();

		

		return theCard;
	}
}