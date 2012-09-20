package com.uqbar.edu.progui.examples.jsp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Biblioteca {
	private static final Biblioteca instance = new Biblioteca();
	private Collection<Libro> libros = new ArrayList<Libro>();

	public Biblioteca() {
		this.addLibro("Las venas abiertas de América Latina", "Eduardo Galeano");
		this.addLibro("Guerra y Paz", "León Tolstoy");
		this.addLibro("Patas Arriba", "Eduardo Galeano");
		this.addLibro("Historia del siglo XX", "Eric Hobsbawm");
		this.addLibro("Ficciones", "Jorge Luis Borges");
		this.addLibro("100 años de soledad", "Gabriel García Márquez");
		this.addLibro("Sobre héroes y tumbas", "Ernesto Sábato");
	}

	public static Biblioteca getInstance() {
		return instance;
	}

	private void addLibro(String titulo, String autor) {
		this.libros.add(new Libro(titulo, autor));
	}

	public List<Libro> buscar(String titulo) {
		List<Libro> seleccionDeLibros = new ArrayList<Libro>();
		for (Libro libro : this.libros) {
			if (libro.getTitulo().contains(titulo)) {
				seleccionDeLibros.add(libro);
			}
		}
		return seleccionDeLibros;
	}
}
