package com.csi.jpa;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {

	private static SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		Session session = factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		Address a1=new Address();
		a1.setAddressState("MH");
		a1.setAddressCountry("IND");
		
		session.save(a1);
		
		Address a2=new Address();
		a2.setAddressState("HP");
		a2.setAddressCountry("IND");
		
		session.save(a2);
		
		List<Address> addressList=new LinkedList<Address>();
		addressList.add(a1);
		addressList.add(a2);
		
		Customer c1=new Customer();
		c1.setCustName("SWATI");
		c1.setAddresses(addressList);
		
		
		
		Customer c2=new Customer();
		c2.setCustName("SIMA");
		c2.setAddresses(addressList);
		
		session.save(c1);
		session.save(c2);
		transaction.commit();
		
				
	}
}
