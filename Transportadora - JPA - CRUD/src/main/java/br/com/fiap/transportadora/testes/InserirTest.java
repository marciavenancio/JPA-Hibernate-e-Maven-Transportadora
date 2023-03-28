package br.com.fiap.transportadora.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.transportadora.domain.Cliente;
import br.com.fiap.transportadora.domain.Entrega;
import br.com.fiap.transportadora.domain.Pedido;
import br.com.fiap.transportadora.domain.Status;
import br.com.fiap.transportadora.domain.Transportadora;

public class InserirTest {

	public static void main(String[] args) {
		
		EntityManager em = null;

		try { 
			
			em = Persistence.createEntityManagerFactory("transportadora").createEntityManager();
			em.getTransaction().begin();
			
			Transportadora transportadora = new Transportadora(0, "Entrega Fast");
			em.persist(transportadora);
			
			Entrega entrega = new Entrega (0, new GregorianCalendar(2023, Calendar.MARCH,05), Status.PENDENTE, transportadora, null);
			em.persist(entrega);
			
			Pedido pedido = new Pedido (0,new GregorianCalendar(2023, Calendar.MARCH,01), 200.50, entrega, null);
			em.persist(pedido);
			
			Cliente cliente = new Cliente(0,"Ana furtado", "Rua Amazonas, 123, São Paulo/SP");
			em.persist(cliente);
			
			entrega.setPedido(pedido);
			pedido.setCliente(cliente);
			
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
