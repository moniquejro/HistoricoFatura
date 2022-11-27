package com.projectsuper.faturaproject.entities;

import java.time.LocalDate;
import java.util.Objects;



public class Lancamento implements Comparable<Lancamento> {

	
	private Long id;
	private Categoria categoria;
	private LocalDate data;
	private Double valor;
	
	@Override	
	public int compareTo(Lancamento lancamento) {
		return getData().compareTo(lancamento.getData());
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(id, other.id);
	}

	public Lancamento(Categoria categoria, LocalDate data, Double valor) {
		
		this.categoria = categoria;
		this.data = data;
		this.valor = valor;
	}
	
	

	@Override
	public String toString() {
		return "Lancamento [categoria=" + categoria + ", data=" + data + ", valor=" + valor + "]";
	}
}
