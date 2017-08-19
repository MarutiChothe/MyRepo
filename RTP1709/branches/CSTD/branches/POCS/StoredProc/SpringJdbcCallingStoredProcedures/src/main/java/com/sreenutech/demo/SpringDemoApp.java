package com.sreenutech.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple example to test our Spring demo app
 * 
 * @author www.luv2code.com
 */
public class SpringDemoApp {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		// 1. Get Spring application context
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2. Get the DAO bean
		CardDAO carsDAO = context.getBean("carsDAO", CardDAO.class);

		// 3. Call methods on the bean

		boolean isCardvalid = carsDAO.validateCard(1212);

		if (isCardvalid) {
			System.out.println("Getting All offers");
			// get All offeers
		} else {
			System.out.println("Card is not valid");
		}
		
		// Usecase 2
		
		boolean isCardvalid1 = carsDAO.validateCard(new Long(1274541211212124L));

		if (isCardvalid1) {
			System.out.println("Getting All offers");
			// get All offeers
		} else {
			System.out.println("Card is not valid");
		}
		
	}

}
