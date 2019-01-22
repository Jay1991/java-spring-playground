package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		
		try {
			boolean tripWire = false; 
			System.out.println(accountDao.findAccounts(tripWire));			
		} catch (Exception e) {
			System.out.println("caught exception: " + e);
		}
		
		context.close();
	}

}
