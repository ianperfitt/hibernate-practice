package com.example.demo;

import java.time.LocalDateTime;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	static private Event e;

	private static SessionFactory sessionFactory;

	private static HibernateConfig hibernateConfig;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		hibernateConfig = new HibernateConfig();
		sessionFactory = hibernateConfig.setUp();
		persistEntity();
		obtainAndPrintAllEntities();
	}

	private static void persistEntity() {
		e = new Event("Entity # 1", LocalDateTime.now());
		// The inTransaction() method creates a session
		// and starts a new transaction.
		try {
			sessionFactory.inTransaction(session -> {
				session.persist(e);
			});
			e = new Event("Entity # 2", LocalDateTime.now());
			sessionFactory.inTransaction(session -> {
				session.persist(e);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void obtainAndPrintAllEntities() {
		sessionFactory.inTransaction(session -> {
			session.createSelectionQuery("from Event", Event.class).getResultList()
					.forEach(event -> System.out.println("Event (" + event.getDate() + ") : " + event.getTitle()));
		});

	}
}