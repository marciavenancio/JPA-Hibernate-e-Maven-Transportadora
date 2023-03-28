package br.com.fiap.transportadora.domain;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tb_transportadora")
public class Transportadora{

	@Id
	@SequenceGenerator(name="transportadora",sequenceName="sq_tb_transportadora",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="transportadora")
	@Column(name = "id_transportadora")
	private int id;

	@Column(name = "nome_transportadora", length = 50)
	private String nome;
	
	
	@OneToMany(mappedBy = "transportadora", cascade=CascadeType.REMOVE)
	private Collection<Entrega> entregas;

	
	public Transportadora() {
		super();
	}
	
	

	public Transportadora(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}



	public Collection<Entrega> getEntregas() {
		return entregas;
	}



	public void setEntregas(Collection<Entrega> entregas) {
		this.entregas = entregas;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

		
}



