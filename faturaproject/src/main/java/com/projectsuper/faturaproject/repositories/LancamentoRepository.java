package com.projectsuper.faturaproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//mapa ou dicionario de chave/valor, busca de uma maneira mais prática

import org.springframework.stereotype.Component;

import com.projectsuper.faturaproject.entities.Lancamento;

@Component
//faz parte do mecanismo Autowired na classe CategoryResource

public class LancamentoRepository {

	private Map<Long, Lancamento> map = new HashMap<>();
	
	//inserindo em memória, sem utilizar banco
	
	public void save(Lancamento obj) {
		map.put(obj.getId(), obj);
	}
	
	public Lancamento findById(Long id) {
		return map.get(id);
	}
	
	public List<Lancamento> findAll(){
		return new ArrayList<Lancamento>(map.values());
		//vai ler tds os valores do map e instanciar em uma lista
		
	}
}
