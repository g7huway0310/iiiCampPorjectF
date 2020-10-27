package com.gocamp.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SessionFactoryListerner implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		HibernateUtil.closeSessionFactory();
		System.out.println("SessionFactory Closed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		HibernateUtil.getSessionFactory();
		System.out.println("SessionFactory Created");
	}
	
	

}
