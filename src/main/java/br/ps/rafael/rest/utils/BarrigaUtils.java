package br.ps.rafael.rest.utils;

import io.restassured.RestAssured;

public class BarrigaUtils {
	public static Integer getContaPeloNome(String nome) {
		return RestAssured.get("/contas?nome"+nome).then().extract().path("id[0]");
	}
	
	public static Integer getIdMovPeloDescricao(String desc) {
		return RestAssured.get("/transacoes?descricao"+desc).then().extract().path("id[0]");
	}
	
}
