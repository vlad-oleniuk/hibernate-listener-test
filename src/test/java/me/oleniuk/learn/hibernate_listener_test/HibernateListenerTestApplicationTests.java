package me.oleniuk.learn.hibernate_listener_test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateListenerTestApplicationTests {

	@Autowired
	private PersonController personController;

	@Test
	void contextLoads() {

		Assertions.assertThat(personController).isNotNull();

	}

}
