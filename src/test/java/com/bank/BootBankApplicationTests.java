package com.bank;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BootBankApplicationTests {
	
	@Inject
	private TestRestTemplate restTemplate;

	@Test
	public void request_home() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).contains("Banking Products");
	}

	@Test
	public void request_detail() {
		String body = this.restTemplate.getForObject("/products/1/details", String.class);
		assertThat(body).contains("1.05");
	}
	
	
	
}
