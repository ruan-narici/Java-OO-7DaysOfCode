package br.com.praticando.conhecimento;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class getJsonCepGSON {
	
	public static void main(String[] args) throws Exception {
		
		
		
		int pesquisa = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o numero da sua pesquisa de 1 a 10.");
		pesquisa = scan.nextInt();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://viacep.com.br/ws/RS/Porto%20Alegre/Domingos/json/"))
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	
		String saveJson = response.body();
		
//		System.out.println(saveJson);
		
		String[] listaPesquisa = saveJson.split("},");
		
		Gson gson = new Gson();
		
		FileJsonAttributes[] lista = gson.fromJson(saveJson, FileJsonAttributes[].class);
		
		List<String> listaLogradouro = Arrays.stream(lista)
				.map(FileJsonAttributes::getLogradouro)
				.toList();
		List<String> listaBairro = Arrays.stream(lista)
				.map(FileJsonAttributes::getBairro)
				.toList();
		
		System.out.println("PESQUISA " + pesquisa + System.lineSeparator() + listaPesquisa[pesquisa]);
		System.out.println(listaLogradouro.get(pesquisa));
	
	}
	
	public class FileJsonAttributes {
		
		String cep;
		String logradouro;
		String bairro;
		String localidade;
		String uf;
		
		public String getCep() {
			return cep;
		}
		public String getLogradouro() {
			return logradouro;
		}
		public String getBairro() {
			return bairro;
		}
		public String getLocalidade() {
			return localidade;
		}
		public String getUf() {
			return uf;
		}
		
	}

}


