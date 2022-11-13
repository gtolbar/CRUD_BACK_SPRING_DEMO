package com.crud_example.exception;

public class ModeloNotFoundException extends RuntimeException {
	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
