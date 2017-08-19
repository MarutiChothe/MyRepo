package com.hsbc.intg.customer.info.impl;

import com.hsbc.intg.customer.info.beans.CustomerSvcDAOReq;
import com.hsbc.intg.customer.info.beans.CustomerSvcDAOResp;




public interface CustomerSvcDAO {
	public CustomerSvcDAOResp getCustomerDetails(CustomerSvcDAOReq vbreq) throws BusinessException, SystemException;
}
