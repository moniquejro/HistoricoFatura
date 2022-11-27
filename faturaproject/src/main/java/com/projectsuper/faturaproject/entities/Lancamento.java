package com.projectsuper.faturaproject.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lancamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Categoria categoria;
	private LocalDate data;
	private Double valor;

	private List<Lancamento> lancamentos = new ArrayList<>();
	
	public Lancamento(long id, Categoria categoria, LocalDate data, Double valor) {

		this.id = id;
		this.categoria = categoria;
		this.data = data;
		this.valor = valor;
	}

	/*
	 * public Lancamento(long l, String string, LocalDate data, double d) { }
	 */
/*
	public Lancamento(long l1, Categoria cat2, LocalDate data, double d) {
	}
*/
	
/*
	public Lancamento(long l, String string, double d, Categoria cat1) {
		// TODO Auto-generated constructor stub
	}
	*/
/*
	@Override
	public String toString() {
		return "Lancamento [categoria=" + categoria + ", data=" + data + ", valor=" + valor + "]";
	}
*/
	/*
	 * @Override public int compareTo(Lancamento lancamento) { return
	 * getData().compareTo(lancamento.getData()); }
	 */

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

}