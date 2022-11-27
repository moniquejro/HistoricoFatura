package com.projectsuper.faturaproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectsuper.faturaproject.entities.Categoria;
import com.projectsuper.faturaproject.entities.Lancamento;
import com.projectsuper.faturaproject.repositories.CategoryRepository;
import com.projectsuper.faturaproject.repositories.LancamentoRepository;

@SpringBootApplication
public class FaturaprojectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepostitory;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FaturaprojectApplication.class, args);
	}

	@Override
	//nesse RUN o que for implementado, vai ser executado ao rodar a aplicação
	public void run(String... args) throws Exception {		
		Categoria cat1 = new Categoria(1L, "Saúde");
		Categoria cat2 = new Categoria(2L, "Escola");
		Categoria cat3 = new Categoria(3L, "Mercado");
		Categoria cat4 = new Categoria(4L, "Lazer");
		Categoria cat5 = new Categoria(5L, "Saúde, Escola, Mercado, Lazer");
		Categoria cat6 = new Categoria(6L, "Resumo");
		//esses metodos vao ser salvos dentro do save MAP
		
		Lancamento l1 = new Lancamento(1L, cat2, LocalDate.of(2022, 4, 20), 75.50);
		Lancamento l2 = new Lancamento(2L, cat1, LocalDate.of(2022, 2, 1), 150.20);
		Lancamento l3 = new Lancamento(3L, cat4, LocalDate.of(2022, 5, 5), 298.10);
		Lancamento l4 = new Lancamento(4L, cat3, LocalDate.of(2022, 4, 15), 578.60);
		Lancamento l5 = new Lancamento(5L, cat3, LocalDate.of(2022, 9, 6), 42.99);
		Lancamento l6 = new Lancamento(6L, cat3, LocalDate.of(2022, 4, 30) , 10.05);
		
		
		cat1.getLancamentos().addAll(Arrays.asList(l2));
		cat2.getLancamentos().addAll(Arrays.asList(l1));
		cat3.getLancamentos().addAll(Arrays.asList(l4, l5, l6));
		cat4.getLancamentos().addAll(Arrays.asList(l3));
		
		categoryRepostitory.save(cat1);
		categoryRepostitory.save(cat2);
		categoryRepostitory.save(cat3);
		categoryRepostitory.save(cat4);
		categoryRepostitory.save(cat5);
		categoryRepostitory.save(cat6);
		
		lancamentoRepository.save(l1);
		lancamentoRepository.save(l2);
		lancamentoRepository.save(l3);
		lancamentoRepository.save(l4);
		lancamentoRepository.save(l5);
		lancamentoRepository.save(l6);
		
	}

}
