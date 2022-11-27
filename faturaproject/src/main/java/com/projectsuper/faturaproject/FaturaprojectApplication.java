package com.projectsuper.faturaproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectsuper.faturaproject.entities.Categoria;
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
		
		//esses metodos vao ser salvos dentro do save MAP
		
		categoryRepostitory.save(cat1);
		categoryRepostitory.save(cat2);
	}

}
