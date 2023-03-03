package br.com.praticando.conhecimento;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Como eu já havia tentado várias vezes, a minha alternativa foi salvar 
//o arquivo .json no computador e fazer a leitura dele.
//o IMDB só permite 100 requisições por dia, e eu fiz bem mais que isso kkk
//este desafio superou todos os meus conhecimentos. EU GOSTO ASSIM!!! 
//MAIS APRENDIZADO PRA CONTA !! :D
public class getJsonIMDB {
	
	public static void main(String[] args) throws Exception {
		
		//Criei esta variavel para facilitar a navegacao entre os elementos.
		int rank = 3;
		
		FileInputStream fis = new FileInputStream("Top250Movies.json");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String ler = br.readLine();
		String saveJson = ler;
		while(ler != null) {
			ler = br.readLine();
			saveJson += ler;
		}
		br.close();
		
		String[] listaFilmes = saveJson.split("},");
		String[] listaAtributos;
		List<String> listaTitulo = new ArrayList<>();
		List<String> listaImagem = new ArrayList<>();
		System.out.println(listaFilmes[rank]);
		for (int i = 0; i < listaFilmes.length; i++) {
			listaAtributos = listaFilmes[i].split(",");
			listaTitulo.add(listaAtributos[2]);
			listaImagem.add(listaAtributos[5]);
		}
		System.out.println(System.lineSeparator() + "GET attributes from JSON:");
		System.out.println(listaTitulo.get(rank));
		System.out.println(listaImagem.get(rank));
	}

}
