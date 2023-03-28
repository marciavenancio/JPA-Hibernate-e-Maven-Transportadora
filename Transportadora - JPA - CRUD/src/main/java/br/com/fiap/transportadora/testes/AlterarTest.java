package br.com.fiap.transportadora.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.transportadora.domain.Cliente;
import br.com.fiap.transportadora.domain.Entrega;
import br.com.fiap.transportadora.domain.Status;


public class AlterarTest {

public static void main(String[] args) {
		
		EntityManager em = null;

		try { 
			
			int idProcurado = 1;
			
			em = Persistence.createEntityManagerFactory("transportadora").createEntityManager();
			Cliente cliente = em.find(Cliente.class, idProcurado);
			Entrega entrega = em.find(Entrega.class, idProcurado);
			
			
			em.getTransaction().begin();
			cliente.setNome("Ana Paula Furtado");
			entrega.setStatus(Status.ENTREGUE);
			em.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
