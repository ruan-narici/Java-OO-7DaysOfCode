package br.com.alura.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

import br.com.alura.model.Filme;

public class getJsonAndRefactor implements Comparator{
	
	public String jsonToStringJava(String apiKey) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String saveJson = response.body();
		return saveJson.replace("{\"items\":", "").replace(",\"errorMessage\":\"\"}", ""); 
	}
	
	public Filme[] StringJsonToAtributtesJava(String saveJson) {
		Gson gson = new Gson();
		Filme[] filmes = gson.fromJson(saveJson, Filme[].class);
		return filmes;
	}
	
	public List<List> filmesToList(Filme[] filmes) {
		
		//ORDENANDO O FILME PELO TITULO
		List<Filme> listaFilmes = Arrays.stream(filmes)
				.sorted((Filme o1, Filme o2) ->  o1.getTitle().compareTo(o2.getTitle()))
				.toList();
		
//		List<String> filmeTitulos = Arrays.stream(filmes)
//				.map(Filme::getTitle)
//				.toList();
		
		List<String> filmeTitulos = new ArrayList<String>();
		for (Filme filmeT : listaFilmes) {
			filmeTitulos.add(filmeT.getTitle());
		}
		
//		List<String> filmeImagens = Arrays.stream(filmes)
//				.map(Filme::getImage)
//				.toList();
		
		List<String> filmeImagens = new ArrayList<String>();
		for (Filme filmeI : listaFilmes) {
			filmeImagens.add(filmeI.getImage());
		}
		
//		List<String> filmeNotas = Arrays.stream(filmes)
//				.map(Filme::getImDbRating)
//				.toList();
		
		List<String> filmeNotas = new ArrayList<String>();
		for (Filme filmeN : listaFilmes) {
			filmeNotas.add(filmeN.getImDbRating());
		}
		
//		List<String> filmeAno = Arrays.stream(filmes)
//				.map(Filme::getYear)
//				.toList();
		
		List<String> filmeAno = new ArrayList<String>();
		for (Filme filmeA : listaFilmes) {
			filmeAno.add(filmeA.getYear());
		}
		
		List<List> listaCompleta = new ArrayList<List>(); 
		listaCompleta.add(filmeTitulos);
		listaCompleta.add(filmeImagens);
		listaCompleta.add(filmeNotas);
		listaCompleta.add(filmeAno);
		return listaCompleta;
	}

	@Override
	public int compare(Object o1, Object o2) {
		String a = o1.toString();
		String b = o2.toString();
		return a.compareTo(b);
	}
	
}
