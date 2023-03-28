package br.com.fiap.transportadora.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.transportadora.domain.Cliente;
import br.com.fiap.transportadora.domain.Transportadora;


public class RemoveTest {

	public static void main(String[] args) {
		
		EntityManager em = null;

		try { 
			
			int idProcurado = 1;
			
			em = Persistence.createEntityManagerFactory("transportadora").createEntityManager();
			Transportadora transportadora = em.find(Transportadora.class, idProcurado);
			Cliente cliente = em.find(Cliente.class, idProcurado);
			
			
			em.getTransaction().begin();
			
			em.remove(transportadora);
			em.remove(cliente);
							
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
