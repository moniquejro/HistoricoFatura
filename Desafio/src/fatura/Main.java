package fatura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	static Scanner input = new Scanner(System.in);
	static ArrayList<CategoriaEnum> opcoesBancarias;

	public static void main(String[] args) {

		// Neste projeto uma classe que possui uma lista de lançamentos de cartão de
		// crédito de um cliente, de forma desorganizada;

		Pessoa pessoa = new Pessoa("Monique", "12345678900", "monique@gmail.com");

		Conta conta = new Conta(1, pessoa);

		Extrato extrato = new Extrato();
		extrato.setConta(conta);

		opcoesBancarias = new ArrayList<CategoriaEnum>();
		operacoes();

		// CategoriaEnum categoria = new Categorias();

		List<Lancamento> lancamentos = new ArrayList<>();

		lancamentos.add(new Lancamento(CategoriaEnum.ESCOLA, LocalDate.of(2022, 4, 20), 75.50));
		lancamentos.add(new Lancamento(CategoriaEnum.SAUDE, LocalDate.of(2022, 2, 1), 150.20));
		lancamentos.add(new Lancamento(CategoriaEnum.LAZER, LocalDate.of(2022, 5, 5), 298.10));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 15), 578.60));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 9, 6), 42.99));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 30), 10.05));

		extrato.setLancamentos(lancamentos);

		// Gastos ordenados por meses;

		System.out.println("\n" + "=============== Lançamentos ordenados por data ===============");

		List<Lancamento> lancamentosOrdenados = extrato.getLancamentos().stream().sorted().collect(Collectors.toList());
		lancamentosOrdenados.forEach(l -> System.out.println(l));

		// Escrever todos os lançamentos de uma mesma categoria de sua escolha;
		// Obter lançamento por categoria (PARTE 2)

		System.out.println("\n" + "=============== Lançamentos POR categoria ===============");
		System.out.println("\n" + "SAÚDE: " + "\n");

		List<Lancamento> lancamentosCategoria1 = extrato.getLancamentos().stream()
				.filter(l -> l.getCategoria() == CategoriaEnum.SAUDE).collect(Collectors.toList());
		lancamentosCategoria1.forEach(l -> System.out.println(l));

		System.out.println("\n" + "ESCOLA: " + "\n");

		List<Lancamento> lancamentosCategoria2 = extrato.getLancamentos().stream()
				.filter(l -> l.getCategoria() == CategoriaEnum.ESCOLA).collect(Collectors.toList());
		lancamentosCategoria2.forEach(l -> System.out.println(l));

		System.out.println("\n" + "MERCADO: " + "\n");

		List<Lancamento> lancamentosCategoria3 = extrato.getLancamentos().stream()
				.filter(l -> l.getCategoria() == CategoriaEnum.MERCADO).collect(Collectors.toList());
		lancamentosCategoria3.forEach(l -> System.out.println(l));

		System.out.println("\n" + "LAZER: " + "\n");

		List<Lancamento> lancamentosCategoria4 = extrato.getLancamentos().stream()
				.filter(l -> l.getCategoria() == CategoriaEnum.LAZER).collect(Collectors.toList());
		lancamentosCategoria4.forEach(l -> System.out.println(l));

		// Mostrar o total de um mês específico de sua escolha

		
		System.out.println("\n" + "=============== Total fatura MÊS ABRIL/22 ===============" + "\n");

		/**
		 * List<Lancamento> lancamentosTotal = extrato
		 * .getLancamentos().stream().filter(l -> l.getCategoria() ==
		 * CategoriaEnum.MERCADO && l.getData().getYear() == 2022 &&
		 * l.getData().getMonthValue() == 4) .collect(Collectors.toList());
		 * 
		 * lancamentosTotal.forEach(l -> System.out.println("total IN: " +
		 * l.getValor()));
		 **/

		Double totalFatura = 0.00;

		List<Lancamento> lancamentosMes = extrato.getLancamentos().stream()
				.filter(l -> (l.getData().getYear() == 2022 && l.getData().getMonthValue() == 4))
				.collect(Collectors.toList());

		Double totalMes = 0.00;

		for (Lancamento lancamento : lancamentosMes) {

			totalMes = totalMes + lancamento.getValor();
		}
		System.out.println("totMesNew: " + totalMes);

		/**
		 * extrato.getLancamentos().stream().forEach(l -> { if (l.getData().getYear() ==
		 * 2022 && l.getData().getMonthValue() == 4 && l.getCategoria() ==
		 * CategoriaEnum.MERCADO) { extrato.getConta();
		 * 
		 * totalFatura = totalFatura + l.getValor(); //Double.sum(tF, l.getValor()); //
		 * Double valorLendo = l; // extrato.add(valorLendo); // totalFatura +=
		 * Double.parseDouble(valorLendo);
		 * 
		 * System.out.println("tF fora: " + totalFatura);
		 * 
		 * // System.out.println("ValorLendo fora: " + valorLendo);
		 **/
		// }
		// });

		// PARTE 2
		// Listar categorias

		System.out.println("\n" + "=============== Lista de categorias ===============" + "\n");

		System.out.println(CategoriaEnum.getNames());
		
		System.out.println("\n" + "=============== Lista GERAL de lançamentos ===============" + "\n");
		List<Lancamento> lancamentosTotal2 = extrato.getLancamentos().stream()
				.filter(l -> l.getData().getYear() == 2022).collect(Collectors.toList());

		lancamentosTotal2.forEach(l -> System.out.println(l.getValor()));

		// Obter categoria por ID

	}

	public static void operacoes() {

		/**
		 * int contador = 1;
		 * 
		 * for (int n = 1; CategoriaEnum.getNames().size() >= n; n++) {
		 * System.out.println(" ["+n+"] - " + CategoriaEnum.getNames().get(n-1));
		 * contador += 1; };
		 * 
		 * System.out.println(" ["+contador+"] - SAIR ");
		 **/

		System.out.println("\n-------------------------");
		System.out.println("----Bem vindo ao Itau----");
		System.out.println("-------------------------");
		System.out.println("Selecione uma categoria:\n ");
		System.out.println("|  [1] - SAÚDE          |");
		System.out.println("|  [2] - ESCOLA		|");
		System.out.println("|  [3] - MERCADO        |");
		System.out.println("|  [4] - LAZER		|");
		System.out.println("|  [5] - TODOS		|");
		System.out.println("|  [6] - RESUMO		|");
		System.out.println("|  [7] - FATURA/ABRIL		|");
		System.out.println("|  [8] - SAIR           |");

		int operacao = input.nextInt();

		switch (operacao) {
		case 1:
			opcaoSaude();
			break;
		case 2:
			opcaoEscola();
			break;
		case 3:
			opcaoMercado();
			break;
		case 4:
			opcaoLazer();
			break;
		case 5:
			opcaoTodos();
			break;
		case 6:
			opcaoResumo();
			break;
		case 7:
			opcaoMes();
			break;
		case 8:
			System.out.println("Obrigado por usar nossos serviços!");
			System.exit(0);
		default:
			System.out.println("Opção inválida!");
			operacoes();
			break;
		}
	}

	public static void opcaoSaude() {

		System.out.println("\n" + "=============== Lançamentos SAÚDE ===============" + "\n");

		Pessoa pessoa = new Pessoa("Monique", "12345678900", "monique@gmail.com");

		Conta conta = new Conta(1, pessoa);

		Extrato extrato = new Extrato();
		extrato.setConta(conta);

		List<Lancamento> lancamentos = new ArrayList<>();

		lancamentos.add(new Lancamento(CategoriaEnum.ESCOLA, LocalDate.of(2022, 4, 20), 75.50));
		lancamentos.add(new Lancamento(CategoriaEnum.SAUDE, LocalDate.of(2022, 2, 1), 150.20));
		lancamentos.add(new Lancamento(CategoriaEnum.LAZER, LocalDate.of(2022, 5, 5), 298.10));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 15), 578.60));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 9, 6), 42.99));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 30), 10.05));

		extrato.setLancamentos(lancamentos);
		List<Lancamento> lancamentosCategoria = extrato.getLancamentos().stream()
				.filter(l -> l.getCategoria() == CategoriaEnum.SAUDE).collect(Collectors.toList());
		lancamentosCategoria.forEach(l -> System.out.println("OPÇÃO [1]: " + l));

		operacoes();
		// lembrar de colocar sysout perguntando p/ fazer nova escolha
	}

	public static void opcaoEscola() {

		System.out.println("\n" + "=============== Lançamentos ESCOLA ===============" + "\n");
		Pessoa pessoa = new Pessoa("Monique", "12345678900", "monique@gmail.com");

		Conta conta = new Conta(1, pessoa);

		Extrato extrato = new Extrato();
		extrato.setConta(conta);

		List<Lancamento> lancamentos = new ArrayList<>();

		lancamentos.add(new Lancamento(CategoriaEnum.ESCOLA, LocalDate.of(2022, 4, 20), 75.50));
		lancamentos.add(new Lancamento(CategoriaEnum.SAUDE, LocalDate.of(2022, 2, 1), 150.20));
		lancamentos.add(new Lancamento(CategoriaEnum.LAZER, LocalDate.of(2022, 5, 5), 298.10));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 15), 578.60));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 9, 6), 42.99));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 30), 10.05));

		extrato.setLancamentos(lancamentos);
		List<Lancamento> lancamentosCategoria = extrato.getLancamentos().stream()
				.filter(l -> l.getCategoria() == CategoriaEnum.ESCOLA).collect(Collectors.toList());
		lancamentosCategoria.forEach(l -> System.out.println("OPÇÃO [2]: " + l));

		operacoes();
		// lembrar de colocar sysout perguntando p/ fazer nova escolha
	}

	public static void opcaoMercado() {

		System.out.println("\n" + "=============== Lançamentos MERCADO ===============" + "\n");

		Pessoa pessoa = new Pessoa("Monique", "12345678900", "monique@gmail.com");

		Conta conta = new Conta(1, pessoa);

		Extrato extrato = new Extrato();
		extrato.setConta(conta);

		List<Lancamento> lancamentos = new ArrayList<>();

		lancamentos.add(new Lancamento(CategoriaEnum.ESCOLA, LocalDate.of(2022, 4, 20), 75.50));
		lancamentos.add(new Lancamento(CategoriaEnum.SAUDE, LocalDate.of(2022, 2, 1), 150.20));
		lancamentos.add(new Lancamento(CategoriaEnum.LAZER, LocalDate.of(2022, 5, 5), 298.10));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 15), 578.60));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 9, 6), 42.99));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 30), 10.05));

		extrato.setLancamentos(lancamentos);
		List<Lancamento> lancamentosCategoria = extrato.getLancamentos().stream()
				.filter(l -> l.getCategoria() == CategoriaEnum.MERCADO).collect(Collectors.toList());
		lancamentosCategoria.forEach(l -> System.out.println("OPÇÃO [3]: " + l));

		operacoes();
		// lembrar de colocar sysout perguntando p/ fazer nova escolha
	}

	public static void opcaoLazer() {

		System.out.println("\n" + "=============== Lançamentos LAZER ===============-" + "\n");

		Pessoa pessoa = new Pessoa("Monique", "12345678900", "monique@gmail.com");

		Conta conta = new Conta(1, pessoa);

		Extrato extrato = new Extrato();
		extrato.setConta(conta);

		List<Lancamento> lancamentos = new ArrayList<>();

		lancamentos.add(new Lancamento(CategoriaEnum.ESCOLA, LocalDate.of(2022, 4, 20), 75.50));
		lancamentos.add(new Lancamento(CategoriaEnum.SAUDE, LocalDate.of(2022, 2, 1), 150.20));
		lancamentos.add(new Lancamento(CategoriaEnum.LAZER, LocalDate.of(2022, 5, 5), 298.10));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 15), 578.60));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 9, 6), 42.99));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 30), 10.05));

		extrato.setLancamentos(lancamentos);
		List<Lancamento> lancamentosCategoria = extrato.getLancamentos().stream()
				.filter(l -> l.getCategoria() == CategoriaEnum.LAZER).collect(Collectors.toList());
		lancamentosCategoria.forEach(l -> System.out.println("OPÇÃO [4]: " + l));

		operacoes();
		// lembrar de colocar sysout perguntando p/ fazer nova escolha
	}

	public static void opcaoTodos() {

		System.out.println("\n" + "=============== RESUMO LANÇAMENTOS ===============" + "\n");

		Pessoa pessoa = new Pessoa("Monique", "12345678900", "monique@gmail.com");

		Conta conta = new Conta(1, pessoa);

		Extrato extrato = new Extrato();
		extrato.setConta(conta);

		List<Lancamento> lancamentos = new ArrayList<>();

		lancamentos.add(new Lancamento(CategoriaEnum.ESCOLA, LocalDate.of(2022, 4, 20), 75.50));
		lancamentos.add(new Lancamento(CategoriaEnum.SAUDE, LocalDate.of(2022, 2, 1), 150.20));
		lancamentos.add(new Lancamento(CategoriaEnum.LAZER, LocalDate.of(2022, 5, 5), 298.10));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 15), 578.60));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 9, 6), 42.99));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 30), 10.05));

		extrato.setLancamentos(lancamentos);
		List<Lancamento> lancamentosCategoria = extrato.getLancamentos();
		lancamentosCategoria.forEach(l -> System.out.println("OPÇÃO [5]: " + l));

		operacoes();
		// lembrar de colocar sysout perguntando p/ fazer nova escolha
	}

	public static void opcaoResumo() {

		System.out.println("\n" + "========================= RESUMO GERAL =======================" + "\n");

		Pessoa pessoa = new Pessoa("Monique", "12345678900", "monique@gmail.com");

		Conta conta = new Conta(1, pessoa);

		Extrato extrato = new Extrato();
		extrato.setConta(conta);

		List<Lancamento> lancamentos = new ArrayList<>();

		lancamentos.add(new Lancamento(CategoriaEnum.ESCOLA, LocalDate.of(2022, 4, 20), 75.50));
		lancamentos.add(new Lancamento(CategoriaEnum.SAUDE, LocalDate.of(2022, 2, 1), 150.20));

		extrato.setLancamentos(lancamentos);
		List<Lancamento> lancamentosCategoria = extrato.getLancamentos().stream()
				.filter(l -> l.getCategoria() == CategoriaEnum.LAZER).collect(Collectors.toList());
		lancamentosCategoria.forEach(l -> System.out.println("OPÇÃO [6]: " + l));

		// lembrar de colocar sysout perguntando p/ fazer nova escolha
	}
	
	public static void opcaoMes() {
		
		Pessoa pessoa = new Pessoa("Monique", "12345678900", "monique@gmail.com");

		Conta conta = new Conta(1, pessoa);
		Extrato extrato = new Extrato();
		extrato.setConta(conta);
		//Double totalFatura = 0.00;
		
		List<Lancamento> lancamentos = new ArrayList<>();

		lancamentos.add(new Lancamento(CategoriaEnum.ESCOLA, LocalDate.of(2022, 4, 20), 75.50));
		lancamentos.add(new Lancamento(CategoriaEnum.SAUDE, LocalDate.of(2022, 2, 1), 150.20));
		lancamentos.add(new Lancamento(CategoriaEnum.LAZER, LocalDate.of(2022, 5, 5), 298.10));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 15), 578.60));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 9, 6), 42.99));
		lancamentos.add(new Lancamento(CategoriaEnum.MERCADO, LocalDate.of(2022, 4, 30), 10.05));
	

		List<Lancamento> lancamentosMes = extrato.getLancamentos().stream()
				.filter(l -> (l.getData().getYear() == 2022 && l.getData().getMonthValue() == 4))
				.collect(Collectors.toList());

		Double totalMes = 0.00;

		for (Lancamento lancamento : lancamentosMes) {

			totalMes = totalMes + lancamento.getValor();
		}
		System.out.println("totMesMenu: " + totalMes);
	}

	// Obter lançamento por ID

}
