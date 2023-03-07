package br.com.alura.main;

import java.util.List;

import br.com.alura.model.Filme;
import br.com.alura.service.createHTML;
import br.com.alura.service.getJsonAndRefactor;

public class Executar {
	
	public static void main(String[] args) throws Exception {
		
		String KeyApi = "k_9synf3in";
		
		getJsonAndRefactor JsonWeb = new getJsonAndRefactor();
		
		String jsonString = JsonWeb.jsonToStringJava(KeyApi);
		Filme[] filmes = JsonWeb.StringJsonToAtributtesJava(jsonString);
		List<List> listaDeFilmes = JsonWeb.filmesToList(filmes);
		System.out.println("Titulo: " + listaDeFilmes.get(0).get(0));
		System.out.println("Imagem: " + listaDeFilmes.get(1).get(0));
		System.out.println("Nota: " + listaDeFilmes.get(2).get(0));
		System.out.println("Ano: " + listaDeFilmes.get(3).get(0));
		createHTML gerarHTML = new createHTML();
		gerarHTML.createDocHTML(listaDeFilmes);
		
	}

}
