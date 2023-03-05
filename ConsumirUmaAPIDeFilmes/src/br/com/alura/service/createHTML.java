package br.com.alura.service;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class createHTML {
	
	public void createDocHTML(List<List> listaDeFilmes) throws IOException {
		FileOutputStream fos = new FileOutputStream("index.html");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("""
			<html>
				<head>
					<meta charset=\"utf-8\">
					<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
					<title>TOP 250 Filmes</title>
					<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
						+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
				</head>
				<body>
					<h1 class="d-flex justify-content-center">TOP 250 Filmes</h1>
					<div class="d-flex flex-wrap justify-content-center m-3">
					
			""");
		for (int i = 0; i < listaDeFilmes.get(0).size(); i++) {
		bw.write(String.format(
				"""
					<div class="card  bg-dark p-2 m-3" style="width: 18rem;">
							<h5 class="card-title border-bottom text-white">%s</h5>	
							<img class="card-img-top p-1" src="%s">
							<p class="card-text text-white mt-2">Nota: %s - Ano: %s</p>
					</div>
				"""
				,listaDeFilmes.get(0).get(i), listaDeFilmes.get(1).get(i), listaDeFilmes.get(2).get(i), listaDeFilmes.get(3).get(i)));
		}
		bw.write("""
					</div>
				</body>
			</html>
			""");
		
		bw.close();
		System.out.println("O arquivo HTML foi criado!");
	}

}
