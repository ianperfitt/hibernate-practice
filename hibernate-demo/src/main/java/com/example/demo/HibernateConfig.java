package com.example.demo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfig {

//	The setUp() method first builds a StandardServiceRegistry 
//	instance which incorporates configuration information from 
//	hibernate.properties into a working set of Services for 
//	use by the SessionFactory.
	protected SessionFactory setUp() {
		// Using the StandardServiceRegistry we create
		// the MetadataSources which lets us tell Hibernate about
		// our domain model.
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new MetadataSources(registry)
					// register entity with hibernate
					.addAnnotatedClass(Event.class)
					// an instance of Metadata represents
					// a complete, partially-validated view
					// of the application domain model
					.buildMetadata()
					// build a SessionFactory for the
					// configured services and validated domain model.
					.buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return sessionFactory;
	}

}
