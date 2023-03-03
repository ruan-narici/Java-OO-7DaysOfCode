package br.com.praticando.conhecimento;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/RS/Porto%20Alegre/Domingos/json/"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        Address[] addresses = gson.fromJson(json, Address[].class);

        List<String> localidades = Arrays.stream(addresses)
                .map(Address::getLocalidade)
                .toList();

        List<String> logradouros = Arrays.stream(addresses)
                .map(Address::getLogradouro)
                .toList();
        
        System.out.println(logradouros.get(0));
    }
}

class Address {
    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
    String ibge;
    String gia;
    String ddd;
    String siafi;

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
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

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public String getDdd() {
        return ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    @Override
    public String toString() {
        return "Address{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ibge='" + ibge + '\'' +
                ", gia='" + gia + '\'' +
                ", ddd='" + ddd + '\'' +
                ", siafi='" + siafi + '\'' +
                '}';
    }
}