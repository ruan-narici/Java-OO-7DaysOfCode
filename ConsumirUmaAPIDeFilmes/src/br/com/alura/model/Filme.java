package br.com.alura.model;

import java.util.Comparator;

public class Filme implements Comparator<Filme[]> {
	
	private String title;
	private String image;
	private String imDbRating;
	private String year;
	
	public String getTitle() {
		return title;
	}
	public String getImage() {
		return image;
	}
	public String getImDbRating() {
		return imDbRating;
	}
	public String getYear() {
		return year;
	}
	@Override
	public int compare(Filme[] o1, Filme[] o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
