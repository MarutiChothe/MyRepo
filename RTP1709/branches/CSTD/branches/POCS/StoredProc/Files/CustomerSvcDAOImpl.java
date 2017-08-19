package com.hsbc.intg.customer.info.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.StoredProcedure;

import com.hsbc.intg.customer.info.beans.AccountDetailsDao;
import com.hsbc.intg.customer.info.beans.CustomerSvcDAOReq;
import com.hsbc.intg.customer.info.beans.CustomerSvcDAOResp;
import com.hsbc.intg.customer.info.beans.StatusBlockDao;




public class CustomerSvcDAOImpl extends StoredProcedure implements CustomerSvcDAO,RowMapper<AccountDetailsDao>{
	public CustomerSvcDAOImpl() {
		super(getTemplate(), "GetAccountDetails");
		System.out.println("dao construtor");
		declareAllParams();	
	}
	
	private static JdbcTemplate getTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/raj");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
	 

	public CustomerSvcDAOResp getCustomerDetails(CustomerSvcDAOReq daoreq) throws BusinessException, SystemException{
		 //Creating the Object
		System.out.println("in intg layer getCDS mthd");
		CustomerSvcDAOResp daoresp= new CustomerSvcDAOResp();
		System.out.println("Got into dao layer, request:"+daoreq.toString());
		
		final Map<String, Object> params = buildInputParams(daoreq);
		final Map<String, Object> returnMap = super.execute(params);
		//If you want generic message then use line no :56
		//final String statusCode = "100178";
		//If you want connect with DB then use line no :58
		final String statusCode = returnMap.get("statusCode").toString();
		System.out.println(" Response code is-------------"+statusCode);
		final String statusMessage = returnMap.get("statusMessage").toString();
		System.out.println("Response Message is-------------------"+statusMessage);
		final StatusBlockDao statusBlockDao = new StatusBlockDao();
		statusBlockDao.setResponseCode(statusCode);
		statusBlockDao.setResponseMessage(statusMessage);
		validate(statusCode, statusMessage);  
				  
		final List<AccountDetailsDao> accountDetailsDAO = (List<AccountDetailsDao>) returnMap.get("GetCardDetailsResultSet");
				
		System.out.println("DAO list size is:"+accountDetailsDAO.size());
		System.out.println("Account Details List is"+accountDetailsDAO);
		daoresp.setStatusBlockDao(statusBlockDao);
		daoresp.setAccountDetailsDao(accountDetailsDAO);
		List l1=new ArrayList();
		l1.add(daoresp);
		System.out.println("DAORESP"+l1.size());
	
		
	System.out.println("Reponse in DAO is " + daoresp);
		return daoresp;
		
}

	private void validate(final String statusCode, final String statusMessage)
			throws BusinessException, SystemException {
		if(!"AD0000".equals(statusCode)){
			if(CustomerDAOEnum.contains(statusCode)&&CustomerDAOEnum.checkType("DATA ERROR")){
				throw new BusinessException(statusCode,statusMessage);
			}
			else if(CustomerDAOEnum.contains(statusCode)&&CustomerDAOEnum.checkType("APPLICATION ERROR")){
				  throw new SystemException(statusCode,statusMessage);
			}
			  else{
				  throw new SystemException("DB9999","GENERIC ERROR");
			  }
		}
	}
	
	private Map<String, Object> buildInputParams(CustomerSvcDAOReq cardDetailsRequest) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientName", cardDetailsRequest.getClientID());
		params.put("channelName", cardDetailsRequest.getChannelID());
		params.put("customerId",cardDetailsRequest.getCustomerID());
		params.put("branchCode", cardDetailsRequest.getBranchCode());
		return params;
	}
	private void declareAllParams() {
		System.out.println("dao declare params");
		declareParameter(new SqlReturnResultSet("GetCardDetailsResultSet", this));
		
		// Input Params
		declareParameter(new SqlParameter("clientName", Types.VARCHAR));
		declareParameter(new SqlParameter("channelName", Types.VARCHAR));
		declareParameter(new SqlParameter("customerId", Types.BIGINT));
		declareParameter(new SqlParameter("branchCode", Types.VARCHAR));
		
		// Output Params
		declareParameter(new SqlOutParameter("statusCode", Types.VARCHAR));
		declareParameter(new SqlOutParameter("statusMessage", Types.VARCHAR));
		
		compile();
	}
	
	AccountDetailsDao accountDetails;
	public AccountDetailsDao mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		System.out.println("entered ito MAP ROW");
		accountDetails = new AccountDetailsDao();
		
		accountDetails.setAvailableBalance(rs.getDouble("available_balance"));
		accountDetails.setAccountHolderName(rs.getString("card_name"));
		accountDetails.setAccountNumber(rs.getLong("card_number"));
		accountDetails.setAccountType(rs.getString("card_type"));
		accountDetails.setIsEligibleForOverDraft(rs.getString("over_draft_eligible"));
		accountDetails.setOverDraftLimit(rs.getDouble("over_draft_limit"));
		accountDetails.setUsedAmount(rs.getDouble("used_amount"));
		accountDetails.setBalance(rs.getDouble("card_limit"));
		
		
		
		System.out.println("AVAILABLE_BAL"+rs.getDouble("available_balance"));
		System.out.println("CARD_NUMBER"+rs.getString("card_name"));
		System.out.println("CARD_NUMBER"+rs.getLong("card_number"));
		System.out.println("CARD_TYPE"+rs.getString("card_type"));
		System.out.println("OVERDRAFT_Elig"+rs.getString("over_draft_eligible"));
		System.out.println("OVERDRAFT_LIMIT"+rs.getDouble("over_draft_limit"));
		System.out.println("USED_AMOUNT"+rs.getDouble("used_amount"));
		System.out.println("BALANCE"+rs.getDouble("card_limit"));
	
		System.out.println("EXIT ito MAP ROW"+accountDetails);
		return accountDetails;
	}
	
	}



		

