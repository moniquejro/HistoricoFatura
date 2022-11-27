package com.projectsuper.faturaproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//mapa ou dicionario de chave/valor, busca de uma maneira mais prática

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.projectsuper.faturaproject.entities.Categoria;

@Component
//faz parte do mecanismo Autowired na classe CategoryResource

public class CategoryRepository {

	private Map<Long, Categoria> map = new HashMap<>();
	
	//inserindo em memória, sem utilizar banco
	
	public void save(Categoria obj) {
		map.put(obj.getId(), obj);
	}
	
	
	public Categoria findById(@PathVariable Long id) {
		return map.get(id);	
	}
	
	public List<Categoria> findAll(){
		return new ArrayList<Categoria>(map.values());
		//vai ler tds os valores do map e instanciar em uma lista
		
	}
}
