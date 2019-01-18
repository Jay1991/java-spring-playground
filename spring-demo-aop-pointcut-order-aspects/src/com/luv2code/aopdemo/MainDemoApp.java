package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		Account account = new Account();
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		accountDao.addAccount(account);
		accountDao.setName("foobar");
		accountDao.setServiceCode("ABC-123");
		
		String name = accountDao.getName();
		String code = accountDao.getServiceCode();
		
		context.close();
	}

}
