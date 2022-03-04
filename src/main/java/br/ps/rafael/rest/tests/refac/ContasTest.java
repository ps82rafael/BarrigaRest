package br.ps.rafael.rest.tests.refac;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import br.ps.rafael.rest.core.BaseTest;
import br.ps.rafael.rest.utils.BarrigaUtils;

public class ContasTest  extends BaseTest{
	 
	
	
	
	@Test
	public void deveIncluirUmaContaComSucesso() {
		given()
		 	.body("{ \"nome\": \"Conta inserida\"} ")
		.when()
			.post("/contas")
		.then()
			.statusCode(201)
		;
		
	}
	
	@Test
	public void deveAlterarContaComSucesso() {
		Integer CONTA_ID = BarrigaUtils.getContaPeloNome("Conta para alterar");
		
		 given()
		 	.body("{ \"nome\": \"Conta Alterada\"} ")
		 	.pathParam("id", CONTA_ID)
		.when()
			.put("/contas/{id}")
		.then()
			.statusCode(200)
			.body("nome", is("Conta Alterada"))
			 
		;
		
	}
	
	@Test
	public void naoDeveInserirContaComMesmoNome() {
		 given()
		 	.body("{ \"nome\": \"Conta mesmo nome\" } ")
		.when()
			.post("/contas")
		.then()
			.statusCode(400)
			.body("error", is("Já existe uma conta com esse nome!"))
			
		;
		
	}
	


}
