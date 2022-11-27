package com.projectsuper.faturaproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectsuper.faturaproject.entities.Categoria;
import com.projectsuper.faturaproject.entities.Lancamento;
import com.projectsuper.faturaproject.repositories.CategoryRepository;

@SpringBootApplication
public class FaturaprojectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepostitory;
	
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
		Categoria cat5 = new Categoria(5L, "Todos");
		Categoria cat6 = new Categoria(6L, "Resumo");
		//esses metodos vao ser salvos dentro do save MAP
		
		Lancamento l1 = new Lancamento(1L, "Escola", 75.50, cat2);
		Lancamento l2 = new Lancamento(2L, "Saúde", 150.20, cat1);
		Lancamento l3 = new Lancamento(3L, "Lazer", 298.10, cat4);
		Lancamento l4 = new Lancamento(4L, "Mercado", 578.60, cat3);
		Lancamento l5 = new Lancamento(5L, "Mercado", 42.99, cat3);
		Lancamento l6 = new Lancamento(6L, "Mercado", 10.05, cat3);
		
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
	}

}
