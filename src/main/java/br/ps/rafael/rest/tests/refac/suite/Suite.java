package br.ps.rafael.rest.tests.refac.suite;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.ps.rafael.rest.core.BaseTest;
import br.ps.rafael.rest.tests.refac.AuthTest;
import br.ps.rafael.rest.tests.refac.ContasTest;
import br.ps.rafael.rest.tests.refac.MovimentacaoTest;
import br.ps.rafael.rest.tests.refac.SaldoTest;
import io.restassured.RestAssured;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	ContasTest.class,
	MovimentacaoTest.class,
	SaldoTest.class,
	AuthTest.class
	
})
public class Suite extends BaseTest{
	
	@BeforeClass
	public static void login() {
		Map<String,String> login = new HashMap<>();
		login.put("email", "ps.rafael@rafael");
		login.put("senha", "12345");
				
		String TOKEN = given()
			.body(login)
		.when()
			.post("/signin")
		.then()
			.statusCode(200)
			.extract().path("token");
		
		RestAssured.requestSpecification.header("Authorization", "JWT " + TOKEN);
		
		RestAssured.get("/reset").then().statusCode(200);
	}

}
