package com.groupsoft.rest.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class notes {

	public notes() {
		
	}
	
	
	public notes(int _Id,String descripcion, String nota, String autor, String fecha) {
		super();
		this.descripcion = descripcion;
		this.nota = nota;
		this.autor = autor;
		this.fecha = fecha;
		this._Id = _Id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int get_Id() {
		return _Id;
	}
	public void set_Id(int _Id) {
		this._Id = _Id;
	}


	private String descripcion;
	private String nota;
	@Size(min =2, message = "el autor debe tener dos caracteres")
	private String autor;
	private String fecha;
	private int _Id;
	
}
