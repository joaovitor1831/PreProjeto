package br.com.req.bean;

import java.util.Calendar;

public class Cliente {
	private int cod_cliente;
	private String nome_cliente;
	private String cpf_cnpj_cliente;
	private String fone_cliente;
	private String sexo_cliente;
	private String logradouro_cliente;
	private String cidade_cliente;
	private String estado_cliente;
	private String email_cliente;
	private String compl_cliente;
	private Calendar dta_cad_cliente;
	private String rg_cliente;
	public String getCompl_cliente() {
		return compl_cliente;
	}
	public void setCompl_cliente(String compl_cliente) {
		this.compl_cliente = compl_cliente;
	}
	public Calendar getDta_cad_cliente() {
		return dta_cad_cliente;
	}
	public void setDta_cad_cliente(Calendar dta_cad_cliente2) {
		this.dta_cad_cliente = dta_cad_cliente2;
	}
	public String getRg_cliente() {
		return rg_cliente;
	}
	public void setRg_cliente(String rg_cliente) {
		this.rg_cliente = rg_cliente;
	}
	public Cliente(int cod_cliente, String nome_cliente,String cpf_cnpj_cliente,String fone_cliente,String sexo_cliente,
			String logradouro_cliente,String cidade_cliente,String estado_cliente,String email_cliente,String rg_cliente,String compl_cliente,
			Calendar dta_cad_cliente){
		cod_cliente=cod_cliente;
		nome_cliente=nome_cliente;
		cpf_cnpj_cliente=cpf_cnpj_cliente;
		fone_cliente=fone_cliente;
		sexo_cliente=sexo_cliente;
		logradouro_cliente=logradouro_cliente;
		cidade_cliente=cidade_cliente;
		estado_cliente=estado_cliente;
		email_cliente=email_cliente;
		compl_cliente=compl_cliente;
		rg_cliente=rg_cliente;
		
		dta_cad_cliente=dta_cad_cliente;
	}
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getCpf_cnpj_cliente() {
		return cpf_cnpj_cliente;
	}
	public void setCpf_cnpj_cliente(String cpf_cnpj_cliente) {
		this.cpf_cnpj_cliente = cpf_cnpj_cliente;
	}
	public String getFone_cliente() {
		return fone_cliente;
	}
	public void setFone_cliente(String fone_cliente) {
		this.fone_cliente = fone_cliente;
	}
	public String getSexo_cliente() {
		return sexo_cliente;
	}
	public void setSexo_cliente(String sexo_cliente) {
		this.sexo_cliente = sexo_cliente;
	}
	public String getLogradouro_cliente() {
		return logradouro_cliente;
	}
	public void setLogradouro_cliente(String logradouro_cliente) {
		this.logradouro_cliente = logradouro_cliente;
	}
	public String getCidade_cliente() {
		return cidade_cliente;
	}
	public void setCidade_cliente(String cidade_cliente) {
		this.cidade_cliente = cidade_cliente;
	}
	public String getEstado_cliente() {
		return estado_cliente;
	}
	public void setEstado_cliente(String estado_cliente) {
		this.estado_cliente = estado_cliente;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	
	

}
