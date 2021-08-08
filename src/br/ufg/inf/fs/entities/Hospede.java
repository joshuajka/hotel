package br.ufg.inf.fs.entities;

import java.util.Date;

public class Hospede {
	
	private Integer idHospede; 
	private String nmHospede; 
	private Date dtNascimento; 
	private Integer cpf;
	
	public Hospede() {
		super();
	}

	public Hospede(Integer idHospede, String nmHospede, Date dtNascimento, Integer cpf) {
		super();
		this.idHospede = idHospede;
		this.nmHospede = nmHospede;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
	}

	public Integer getIdHospede() {
		return idHospede;
	}

	public void setIdHospede(Integer idHospede) {
		this.idHospede = idHospede;
	}

	public String getNmHospede() {
		return nmHospede;
	}

	public void setNmHospede(String nmHospede) {
		this.nmHospede = nmHospede;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Hospede [idHospede=" + idHospede + ", nmHospede=" + nmHospede + ", dtNascimento=" + dtNascimento
				+ ", cpf=" + cpf + "]";
	}
	
	
	

}
