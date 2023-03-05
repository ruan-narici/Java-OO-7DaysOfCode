package br.com.alura.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import br.com.alura.model.Filme;

public class getJsonAndRefactor {
	
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
		List<String> filmeTitulos = Arrays.stream(filmes)
				.map(Filme::getTitle)
				.toList();
		List<String> filmeImagens = Arrays.stream(filmes)
				.map(Filme::getImage)
				.toList();
		List<String> filmeNotas = Arrays.stream(filmes)
				.map(Filme::getImDbRating)
				.toList();
		List<String> filmeAno = Arrays.stream(filmes)
				.map(Filme::getYear)
				.toList();
		List<List> listaCompleta = new ArrayList<List>(); 
		listaCompleta.add(filmeTitulos);
		listaCompleta.add(filmeImagens);
		listaCompleta.add(filmeNotas);
		listaCompleta.add(filmeAno);
		return listaCompleta;
	}
	
}
