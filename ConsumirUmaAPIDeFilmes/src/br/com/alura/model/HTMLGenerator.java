package br.com.alura.model;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class HTMLGenerator {
	
	private PrintWriter writer;
	private String head = 
			"""
			<head>
				<meta charset=\"utf-8\">
				<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
				<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
					+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
			</head>\n
			<body>
				<div class="d-flex flex-wrap justify-content-center m-3">
			""";
	private String divTemplate = 
			"""
			<div class="card  bg-dark p-2 m-3" style="width: 18rem;">  
				<div class="card-title border-bottom">
					<h4 class="text-white">%s</h4>
				</div>
				<img class="card-img-top p-1" src="%s">
				<p class="card-text text-white mt-2">Nota: %s - Ano: %s</p>
			</div>
		""";
	private String endbody = 
			"""
				</div>
			</body>		
			""";
			
	
	public HTMLGenerator(PrintWriter writer) {
		this.writer = writer;
	}
	
	public void generate(List<String> listaTitulo, List<String> urlDaImagemDoFilme, List<String> notaDoFilme, List<String> anoDoFilme) {
		this.writer.println(this.head);
		for (int i = 0; i < listaTitulo.size(); i++) {
			writer.println(String.format(this.divTemplate, listaTitulo.get(i), urlDaImagemDoFilme.get(i), notaDoFilme.get(i), anoDoFilme.get(i)));
		}
		this.writer.println(this.endbody);	
		System.out.println("HTML GERADO!");
	}

}
