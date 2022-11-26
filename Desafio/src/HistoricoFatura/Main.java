package HistoricoFatura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {

		//Neste projeto uma classe que possui uma lista de lançamentos de cartão de crédito de um cliente, de forma desorganizada;
		
		Pessoa pessoa = new Pessoa("Monique", "12345678900", "monique@gmail.com");
		
		
		Conta conta = new Conta(1, pessoa);
		
		Extrato extrato = new Extrato();
		extrato.setConta(conta);
		
		List<Lancamento> lancamentos = new ArrayList<>();
		
		lancamentos.add(new Lancamento(CategoriaEnum.ESCOLA, LocalDate.of(2022, 4, 20), 75.50));
		lancamentos.add(new Lancamento(CategoriaEnum.SAUDE, LocalDate.of(2022, 2, 1), 150.20));
		lancamentos.add(new Lancamento(CategoriaEnum.LAZER, LocalDate.of(2022, 5, 5), 298.10));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 19), 578.60));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 30), 10.05));

		extrato.setLancamentos(lancamentos);
		
		System.out.println(lancamentos);
		
		//Gastos ordenados por meses;
		
		System.out.println("\n" + "--------------Lançamentos ordenados por data--------------" + "\n");
		
		List<Lancamento> lancamentosOrdenados = extrato.getLancamentos().stream().sorted().collect(Collectors.toList());
		lancamentosOrdenados.forEach(l -> System.out.println(l));
		
		
		
		//Escrever todos os lançamentos de uma mesma categoria de sua escolha;
		
		System.out.println("\n" + "--------------Lançamentos mesma categoria--------------" + "\n");
		
		List<Lancamento> lancamentosCategoria = extrato.getLancamentos().stream().filter(l -> l.getCategoria() == CategoriaEnum.MERCADO).collect(Collectors.toList());  
		lancamentosCategoria.forEach(l -> System.out.println(l));
		
		//Mostrar o total da fatura por mês.
		
		System.out.println("\n" + "--------------Total fatura mês/categoria--------------" + "\n");
		
		//List<Lancamento> totalLancamento = (List<Lancamento>) extrato.getLancamentos().stream().filter(l -> l.getData().getYear() == 2022 && l.getData().getMonthValue() == 4 && l.getCategoria() == CategoriaEnum.MERCADO);
		//totalLancamento.forEach(l -> System.out.println("teste List: "+l));
		
		Double totalFatura = 0.00;
		//Double tF = 0.00;
		
		List<Lancamento> lancamentosTotal = extrato.getLancamentos().stream().filter(l -> l.getCategoria() == CategoriaEnum.MERCADO && l.getData().getYear() == 2022 && l.getData().getMonthValue() == 4).collect(Collectors.toList());  
		lancamentosTotal.forEach(l -> System.out.println("total mesma: "+l.getValor()));
		

		extrato.getLancamentos().stream().forEach(l -> {
			if (l.getData().getYear() == 2022 && l.getData().getMonthValue() == 4
					&& l.getCategoria() == CategoriaEnum.MERCADO) {
				Double tF = totalFatura + l.getValor();
				totalFatura.sum(tF, 0);
				System.out.println("tot: " + totalFatura);
				System.out.println("2: " + tF);
			}
		});
		
		//System.out.println("teste fora: " + tF);

	}

}
