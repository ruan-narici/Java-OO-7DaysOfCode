import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

//Usei essa classe para poder praticar com outra API.
public class getJsonVIACEP {

	public static void main(String[] args) throws Exception {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://viacep.com.br/ws/RS/Porto%20Alegre/Domingos/json/"))
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String json = response.body();
		String[] jsonFilmes = convertJsoForList(json);
		String[] save;
		List<String> listaCep = new ArrayList<>();
		List<String> listaLogradouro = new ArrayList<>();
		System.out.println(jsonFilmes[0]);
		for (int i = 0; i < jsonFilmes.length; i++) {
			save = jsonFilmes[i].split(",");
			listaCep.add(save[0].replace("cep", "").replace(":", "").replace("\"", "").replace(" ", ""));
			listaLogradouro.add(save[1].replace("logradouro", "").replace(":", "").replace("\"", "").replace(" ", ""));
		}
		System.out.println("CEP: " + listaCep.get(0));
		System.out.println("LOGRADOURO: " + listaLogradouro.get(0));
	}
	
	public static String[] convertJsoForList(String json) {
		return json.replace("[", "")
				.replace("  ", "")
				.replace("\n", "")
				.replace("{", "")
				.split("},");
	}
	
}
