package br.ps.rafael.rest.tests.refac;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import br.ps.rafael.rest.core.BaseTest;
import io.restassured.RestAssured;
import io.restassured.specification.FilterableRequestSpecification;

public class AuthTest  extends BaseTest{
	 
	@Test
	public void naoDeveAcessarAPISemToken() {
		FilterableRequestSpecification req = (FilterableRequestSpecification) RestAssured.requestSpecification;
		req.removeHeader("Authorization");
		
		given()
		.when()
			.get("/contas")
		.then()
			.statusCode(401)
		
		;
	}
	
	


}
