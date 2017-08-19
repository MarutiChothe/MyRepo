package com.sreenutech.demo;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.JdbcTemplate;

public class CardDAOImpl implements CardDAO {

	private CardStoredProcedure cardStoredProcedure;
	private JdbcTemplate jdbcTemplate;

	public CardDAOImpl() {
	}

	@PostConstruct
	public void postConstruct() {
		cardStoredProcedure = new CardStoredProcedure(jdbcTemplate);
	}

	@SuppressWarnings("rawtypes")
	public boolean validateCard(long cardno) {
		List result = null;

		// Call the stored procedure
		Map data = cardStoredProcedure.validateCard(cardno);


		// retrieve the status info
		String code = (String) data.get(DAOConstants.RETURN_CODE);
		String message = (String) data.get(DAOConstants.RETURN_MESSAGE);

		// just print the code and message…should log this
		System.out.println("Status Code=" + code);
		System.out.println("Status Messsage=" + message);

		if(code.equals("0000")){
			return true;
		}
		return false;
	}

	public CardStoredProcedure getCarsStoredProcedure() {
		return cardStoredProcedure;
	}

	public void setCarsStoredProcedure(CardStoredProcedure carsStoredProcedure) {
		this.cardStoredProcedure = carsStoredProcedure;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}