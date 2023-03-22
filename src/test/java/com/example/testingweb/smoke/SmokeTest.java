package com.example.testingweb.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testingweb.HomeController;
//on vérifie si spring a reussi a créer des beans sinon on ne va pas plus loin
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
//on verifie si on arrive a créer notre controller
public class SmokeTest {

	@Autowired
	private HomeController controller;

	@Test
	//order: donne les test qui vont etre lancer par ordre
	@Order(1)
	public void contextLoads() throws Exception {
		System.out.println("dans contextLoads");
		//on verifie que le controller n'est pas nul
		assertThat(controller).isNotNull();
	}
	@Test
	@Order(2)
	public void test() throws Exception {
		System.out.println("dans test");
		assertTrue(true);
	}
	//ce sont des annotation de cycle de vie
	//ici c'est avant l'execution d'un test
	@BeforeEach
	public void testBeforeEach() {
		System.out.println("dans testBeforeEach");
	}
	//apres l'execution d'un test
	@AfterEach
	public void testAfterEach() {
		System.out.println("dans testAfterEach");
	}
	//avant l'execution de tous les test
	@BeforeAll
	public static void testBeforeAll() {
		System.out.println("dans testBeforeAll");
	}
	//apres l'execution de tous les test
	@AfterAll
	public static void testAfterAll() {
		System.out.println("dans testAfterAll");
	}
}
