package com.projectsuper.faturaproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectsuper.faturaproject.entities.Lancamento;
import com.projectsuper.faturaproject.repositories.LancamentoRepository;

@RestController
//para o spring reconhecer a classe como um recurso
@RequestMapping(value = "/lancamentos")
//mapeamento de URL
	public class LancamentoResource {

	//private LancamentoRepository categoryRepository = new LancamentoRepository();
	//maneira ruim de compor obj; existe o problema de auto-acoplamento e p/ cada resource que criar seria um inserido pra cada new
	//p melhor é fazer injeçao de dependencia: construtor, metodo set ou framework; referencia: Alura/prof Nelio;
	
	@Autowired
	//faz um pre-processamento e simplifica a dependencia
	private LancamentoRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Lancamento>> findAll(){
		List<Lancamento> list = categoryRepository.findAll();
		//esse findAll vai buscar tds os valores e devolver na lista
		return ResponseEntity.ok().body(list);
		//.ok é um metodo que instancia uma resposta, dizendo que está td certo. 
		//É uma resposta da categoria 200 do protocolo http
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Lancamento> findById(@PathVariable Long id){
		Lancamento cat = categoryRepository.findById(id);
		//aqui ele vai buscar pelo ID da requisição
		return ResponseEntity.ok().body(cat);
	}
	
}
