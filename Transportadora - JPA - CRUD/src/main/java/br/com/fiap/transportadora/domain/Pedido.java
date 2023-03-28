package br.com.fiap.transportadora.domain;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "tb_pedido")
public class Pedido {

		@Id
	    @Column(name = "id_pedido")
	    @SequenceGenerator(name = "pedido", sequenceName = "sq_pedido", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	    private int id;
		
		@CreationTimestamp
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "dh_pedido")
		private Calendar dataPedido;
		
		@Column(name="valor_pedido")
		private double valorTotal;
		
		@OneToOne(mappedBy="pedido",cascade=CascadeType.REMOVE)
		private Entrega entrega;
		
		@JoinColumn(name = "id_cliente")
		@ManyToOne(cascade=CascadeType.REMOVE)
		private Cliente cliente;
		

		public Pedido() {
			super();
			
		}

		public Pedido(int id, Calendar dataPedido, double valorTotal, Entrega entrega, Cliente cliente) {
			super();
			this.id = id;
			this.dataPedido = dataPedido;
			this.valorTotal = valorTotal;
			this.entrega = entrega;
			this.cliente = cliente;
		}

		public Entrega getEntrega() {
			return entrega;
		}

		public void setEntrega(Entrega entrega) {
			this.entrega = entrega;
		}

		public int getId() {
			return id;
		}

		public Calendar getDataPedido() {
			return dataPedido;
		}

		public double getValorTotal() {
			return valorTotal;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setDataPedido(Calendar dataPedido) {
			this.dataPedido = dataPedido;
		}

		public void setValorTotal(double valorTotal) {
			this.valorTotal = valorTotal;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
	  
		
		

}
