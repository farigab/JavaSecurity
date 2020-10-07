package br.com.coti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "livro")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	// spring boot
	@Column(name = "livro_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	@Pattern(regexp = "[a-z A-Z]{2,50}", message = "Regra do Nome")
	private String nome;

	@Column
	@DecimalMin("1.00")
	private Double preco;


	public Livro(Long id, @Pattern(regexp = "[a-z A-Z]{2,50}", message = "Regra do Nome") String nome,
			@DecimalMin("1.00") Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}


	public Livro() {
		super();
	}


	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
