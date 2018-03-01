package com.lambazon.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.lambazon.domain.Product;


/**
 * 
 * @author stanlick
 *
 *   This class will demonstrate Integration Testing once learner has advanced to the TDD phase of the Java EE learning path
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTests {
	
	@Inject
	private TestRestTemplate restTemplate;

	@Test
	public void request_home() {
		String body = restTemplate.getForObject("/", String.class);
		assertThat(body).contains("Products");
	}

	@Test
	public void request_detail() {
		String body = restTemplate.getForObject("/products/1/details", String.class);
		assertThat(body).contains("2nd Generation");
	}
	
	@Test
	public void request_list_as_json_and_convert_to_list() {
		String body = restTemplate.getForObject("/api/products", String.class);
		GsonJsonParser parser = new GsonJsonParser();
		List<Object> products = parser.parseList(body);
		
		// project-0 modification will break this assertion!
		assertThat(products.size()).isEqualTo(5);
	}
	
	@Test
	public void request_product_as_json_and_convert_to_list() {
		String body = restTemplate.getForObject("/api/products/{id}/details", String.class, 1);
		GsonJsonParser parser = new GsonJsonParser();
		List<Object> products = parser.parseList("[" + body + "]");
		assertThat(products.size()).isEqualTo(1);
	}
	
	@Test
	public void test_minimum_quantity_validation_for_product() {
		Product p = new Product(0, 0, 0, null, null);
		assertThat(p.getQuantity()).isEqualTo(0);
	}
}
