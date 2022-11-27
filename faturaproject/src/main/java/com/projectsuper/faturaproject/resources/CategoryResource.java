package com.projectsuper.faturaproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectsuper.faturaproject.entities.CategoriaEnum;

@RestController
//para o spring reconhecer a classe como um recurso
@RequestMapping(value = "/categories")
//mapeamento de URL
	public class CategoryResource {

	@GetMapping
	public ResponseEntity<List<CategoriaEnum>> findAll(){
		List<CategoriaEnum> list = new ArrayList<>();
		System.out.println(CategoriaEnum.getNames());
		return ResponseEntity.ok().body(list);
		//.ok é um metodo que instancia uma resposta, dizendo que está td certo. 
		//É uma resposta da categoria 200 do protocolo http
	}
/**
	@GetMapping(value = "/{id}")
	public RespondeEntity<...> findById(@PathVariable Long id){
		...
		return ResponseEntity.ok().body(...);
	}
	**/
}
