package fatura;

import java.time.LocalDate;

public class Lancamento implements Comparable<Lancamento> {

	
		
	private CategoriaEnum categoria;
	private LocalDate data;
	private Double valor;
	
	@Override	
	public int compareTo(Lancamento lancamento) {
		return getData().compareTo(lancamento.getData());
	}
	
	public CategoriaEnum getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaEnum categoria) {
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
	
	public Lancamento(CategoriaEnum categoria, LocalDate data, Double valor) {
		
		this.categoria = categoria;
		this.data = data;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Lancamento [categoria=" + categoria + ", data=" + data + ", valor=" + valor + "]";
	}
	
	
	
}