package br.com.alura.service;

import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import br.com.alura.model.Filme;
import br.com.alura.model.HTMLGenerator;

public class getJsonFromIMDB_GSON {
	
	public static void main(String[] args) throws Exception {
		
		String apiKey = "k_9synf3in";
		int rank = 0;
		
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		//Salvando o Json em um atributo local
		String fileJson = response.body();
		String fileJsonFormated = fileJson.replace(",\"errorMessage\":\"\"}", "")
				.replace("{\"items\":", "");
		
		Gson gson = new Gson();
		Filme[] filme = gson.fromJson(fileJsonFormated, Filme[].class);
		
		//Armazenando os atributos em uma lista
		List<String> tituloDoFilme = Arrays.stream(filme)
				.map(Filme::getTitle)
				.toList();
		List<String> urlDaImagemDoFilme = Arrays.stream(filme)
				.map(Filme::getUrlImage)
				.toList();
		List<String> notaDoFilme = Arrays.stream(filme)
				.map(Filme::getNota)
				.toList();
		List<String> anoDoFilme = Arrays.stream(filme)
				.map(Filme::getAno)
				.toList();
		
//		System.out.println("RESULTADO DA PESQUISA:");
//		System.out.println(tituloDoFilme.get(rank));
//		System.out.println(urlDaImagemDoFilme.get(rank));
//		System.out.println(notaDoFilme.get(rank));
//		System.out.println(anoDoFilme.get(rank));
		
		
		//Escrevendo o HTML
		PrintWriter writer = new PrintWriter("index.html");
		HTMLGenerator gerar = new HTMLGenerator(writer);
		gerar.generate(tituloDoFilme, urlDaImagemDoFilme, notaDoFilme, anoDoFilme);
	}

}
