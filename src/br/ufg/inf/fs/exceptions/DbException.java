package br.ufg.inf.fs.exceptions;

public class DbException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	public DbException(String msg) {
		super(msg);
	}
}
