/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.bean;

import java.util.Calendar;

/**
 *
 * @author joao vitor
 */
public class Funcionario {
        private int cod_funcionario;
	private String nome_funcionario;
	private String cpf_cnpj_funcionario;
	private String fone_funcionario;
	private String sexo_funcionario;
	private String logradouro_funcionario;
	private String cidade_funcionario;
	private String estado_funcionario;
	private String email_funcionario;
	private String compl_funcionario;
	private Calendar dta_cad_funcionario;
	private String cargo_funcionario;

   public Funcionario(int cod_funcionario, String nome_funcionario,String cpf_cnpj_funcionario,String fone_funcionario,String sexo_funcionario,
   String logradouro_funcionario,String cidade_funcionario,String estado_funcionario,String email_funcionario,String cargo_funcionario,String compl_funcionario,
			Calendar dta_cad_funcionario,String rg_funcionario){
		cod_funcionario=cod_funcionario;
		nome_funcionario=nome_funcionario;
		cpf_cnpj_funcionario=cpf_cnpj_funcionario;
		fone_funcionario=fone_funcionario;
		sexo_funcionario=sexo_funcionario;
		logradouro_funcionario=logradouro_funcionario;
		cidade_funcionario=cidade_funcionario;
		estado_funcionario=estado_funcionario;
		email_funcionario=email_funcionario;
		compl_funcionario=compl_funcionario;
		cargo_funcionario=cargo_funcionario;
		dta_cad_funcionario=dta_cad_funcionario;
               
	}        
    public Funcionario() {

    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getCpf_cnpj_funcionario() {
        return cpf_cnpj_funcionario;
    }

    public void setCpf_cnpj_funcionario(String cpf_cnpj_funcionario) {
        this.cpf_cnpj_funcionario = cpf_cnpj_funcionario;
    }

    public String getFone_funcionario() {
        return fone_funcionario;
    }

    public void setFone_funcionario(String fone_funcionario) {
        this.fone_funcionario = fone_funcionario;
    }

    public String getSexo_funcionario() {
        return sexo_funcionario;
    }

    public void setSexo_funcionario(String sexo_funcionario) {
        this.sexo_funcionario = sexo_funcionario;
    }

    public String getLogradouro_funcionario() {
        return logradouro_funcionario;
    }

    public void setLogradouro_funcionario(String logradouro_funcionario) {
        this.logradouro_funcionario = logradouro_funcionario;
    }

    public String getCidade_funcionario() {
        return cidade_funcionario;
    }

    public void setCidade_funcionario(String cidade_funcionario) {
        this.cidade_funcionario = cidade_funcionario;
    }

    public String getEstado_funcionario() {
        return estado_funcionario;
    }

    public void setEstado_funcionario(String estado_funcionario) {
        this.estado_funcionario = estado_funcionario;
    }

    public String getEmail_funcionario() {
        return email_funcionario;
    }

    public void setEmail_funcionario(String email_funcionario) {
        this.email_funcionario = email_funcionario;
    }

    public String getCompl_funcionario() {
        return compl_funcionario;
    }

    public void setCompl_funcionario(String compl_funcionario) {
        this.compl_funcionario = compl_funcionario;
    }

    public Calendar getDta_cad_funcionario() {
        return dta_cad_funcionario;
    }

    public void setDta_cad_funcionario(Calendar dta_cad_funcionario) {
        this.dta_cad_funcionario = dta_cad_funcionario;
    }

    public String getCargo_funcionario() {
        return cargo_funcionario;
    }

    public void setCargo_funcionario(String cargo_funcionario) {
        this.cargo_funcionario = cargo_funcionario;
    }        
        
}
