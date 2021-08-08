package br.ufg.inf.fs.entities;

public class Hotel {

	private Integer idHotel;
	private String nmHotel;
	private String endereco;
	private Integer qtdEstrelas;
	
	public Hotel() {
		super();
	}

	public Hotel(Integer idHotel, String nmHotel, String endereco, Integer qtdEstrelas) {
		super();
		this.idHotel = idHotel;
		this.nmHotel = nmHotel;
		this.endereco = endereco;
		this.qtdEstrelas = qtdEstrelas;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public String getNmHotel() {
		return nmHotel;
	}

	public void setNmHotel(String nmHotel) {
		this.nmHotel = nmHotel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getQtdEstrelas() {
		return qtdEstrelas;
	}

	public void setQtdEstrelas(Integer qtdEstrelas) {
		this.qtdEstrelas = qtdEstrelas;
	}

	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nmHotel=" + nmHotel + ", endereco=" + endereco + ", qtdEstrelas="
				+ qtdEstrelas + "]";
	}
	
}
