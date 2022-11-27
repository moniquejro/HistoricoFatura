package com.projectsuper.faturaproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
//@Table(name = "tb_categoria")
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	@JsonIgnore
	//pre-processamento p/ não serializar a lista de lançamentos de uma categoria
	//@OneToMany(mappedBy = "categoria")
	private List<Lancamento> lancamentos = new ArrayList<>();
	
	public Categoria() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Categoria(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

		
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
