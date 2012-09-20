package com.uqbar.edu.progui.examples.jsp;

import java.io.Serializable;

public class Libro implements Serializable  {
	private final String titulo;
	private final String autor;

	public Libro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getAutor() {
		return this.autor;
	}
}
