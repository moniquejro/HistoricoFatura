package com.projectsuper.faturaproject.entities;

import java.util.ArrayList;
import java.util.List;

public enum CategoriaEnum {

	SAUDE("Saúde"), 
	ESCOLA("Escola"), 
	MERCADO("Mercado"), 
	LAZER("Lazer");

	public final String name;

	@Override
	public String toString() {
		return name;
	}

	private CategoriaEnum(String name) {
		this.name = name;
	}

	public static List<String> getNames() {
		List<String> list = new ArrayList<String>();
		for (CategoriaEnum tipo : CategoriaEnum.values()) {
			list.add(tipo.toString());
		}
		return list;
	}

	public String getName() {
		return name;
	}
}
