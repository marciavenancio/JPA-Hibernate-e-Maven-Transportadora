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
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    @SequenceGenerator(name = "cliente", sequenceName = "sq_cliente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    private int id;
  
    @Column(name = "nome_cliente", nullable = false)
    private String nome;
    
    @Column (name="endereco", nullable = false)
    private String endereco;
    
    @OneToMany(mappedBy = "cliente", cascade=CascadeType.REMOVE)
	private Collection<Pedido> pedidos;

     
    
	public Cliente() {
		super();
	}


	public Cliente(int id, String nome, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
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
	
	


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Collection<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


}
