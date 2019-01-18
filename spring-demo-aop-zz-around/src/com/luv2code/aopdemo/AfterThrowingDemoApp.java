package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		
		try {
			boolean tripWire = true; 
			System.out.println(accountDao.findAccounts(tripWire));			
		} catch (Exception e) {
			System.out.println("caught exception: " + e);
		}
		
		context.close();
	}

}
