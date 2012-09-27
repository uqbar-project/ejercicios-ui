package uqbar.busquedaLibros.domain;

public class Libro {
	private final String titulo;
	private final String autor;
	private final int id;

	public Libro(int id, String titulo, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public int getId() {
		return this.id;
	}
}
