package br.com.fiap.transportadora.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.transportadora.domain.Cliente;
import br.com.fiap.transportadora.domain.Entrega;


public class ConsultarIdTest {

	public static void main(String[] args) {

		
		EntityManager em = null;

		try { 
			
			int idProcurado = 1;
			
			em = Persistence.createEntityManagerFactory("transportadora").createEntityManager();
			Entrega entrega = em.find(Entrega.class, idProcurado);
			Cliente cliente = em.find(Cliente.class, idProcurado);

			System.out.println("Entrega do cliente: "+ cliente.getNome()+ " com status " + entrega.getStatus());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
