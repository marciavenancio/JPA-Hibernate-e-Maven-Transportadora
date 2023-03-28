package br.com.fiap.transportadora.testes;

import javax.persistence.Persistence;

public class ConexaoBancoTest {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("transportadora").createEntityManager();
	}
	
}