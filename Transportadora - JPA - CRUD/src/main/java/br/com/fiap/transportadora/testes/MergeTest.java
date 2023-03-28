package br.com.fiap.transportadora.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.transportadora.domain.Transportadora;

public class MergeTest {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
			em = Persistence.createEntityManagerFactory("transportadora").createEntityManager();
			Transportadora transp = new Transportadora();
			transp.setId(2);
			transp.setNome("Zapt Transportes");
			em.merge(transp);
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (em != null) {
			em.close();
		}
		System.exit(0);
	}

}


