package br.ufg.inf.fs.entities;

import java.util.Date;

public class Hospedagem {
	
	private Integer idHospedagem; 
	private Integer idQuarto; 
	private Integer idHospede; 
	private Date dtCheckin; 
	private Date dtCheckout;
	
	public Hospedagem() {
		super();
	}

	public Hospedagem(Integer idHospedagem, Integer idQuarto, Integer idHospede, Date dtCheckin, Date dtCheckout) {
		super();
		this.idHospedagem = idHospedagem;
		this.idQuarto = idQuarto;
		this.idHospede = idHospede;
		this.dtCheckin = dtCheckin;
		this.dtCheckout = dtCheckout;
	}

	public Integer getIdHospedagem() {
		return idHospedagem;
	}

	public void setIdHospedagem(Integer idHospedagem) {
		this.idHospedagem = idHospedagem;
	}

	public Integer getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(Integer idQuarto) {
		this.idQuarto = idQuarto;
	}

	public Integer getIdHospede() {
		return idHospede;
	}

	public void setIdHospede(Integer idHospede) {
		this.idHospede = idHospede;
	}

	public Date getDtCheckin() {
		return dtCheckin;
	}

	public void setDtCheckin(Date dtCheckin) {
		this.dtCheckin = dtCheckin;
	}

	public Date getDtCheckout() {
		return dtCheckout;
	}

	public void setDtCheckout(Date dtCheckout) {
		this.dtCheckout = dtCheckout;
	}

	@Override
	public String toString() {
		return "Hospedagem [idHospedagem=" + idHospedagem + ", idQuarto=" + idQuarto + ", idHospede=" + idHospede
				+ ", dtCheckin=" + dtCheckin + ", dtCheckout=" + dtCheckout + "]";
	} 
	
	

}
