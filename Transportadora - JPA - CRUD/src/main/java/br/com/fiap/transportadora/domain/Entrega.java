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
import javax.persistence.Enumerated;
import javax.persistence.EnumType;


import org.hibernate.annotations.CreationTimestamp;




@Entity
@Table(name = "tb_entrega")
public class Entrega{
	
	@Id
	@SequenceGenerator(name="entrega",sequenceName="sq_tb_entrega",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="entrega")
	@Column(name = "id_entrega")
	private int id;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_entrega")
	private Calendar dataEntrega;
	
	@Column (name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@JoinColumn(name = "id_transportadora")
	@ManyToOne (cascade=CascadeType.REMOVE)
	private Transportadora transportadora;
	
	@OneToOne (cascade=CascadeType.REMOVE)
	@JoinColumn(name="id_pedido")
	private Pedido pedido;
	
	

	public Entrega() {
		super();
		
	}

	public Entrega(int id, Calendar dataEntrega, Status status, Transportadora transportadora, Pedido pedido) {
		super();
		this.id = id;
		this.dataEntrega = dataEntrega;
		this.status = status;
		this.transportadora = transportadora;
		this.pedido = pedido;
	}

	public Entrega(int id, Calendar dataEntrega, Status status) {
		super();
		this.id = id;
		this.dataEntrega = dataEntrega;
		this.status = status;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public int getId() {
		return id;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public Status getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
