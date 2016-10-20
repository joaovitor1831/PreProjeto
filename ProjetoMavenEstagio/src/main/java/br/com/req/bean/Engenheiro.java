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
public class Engenheiro {
        private int cod_engenheiro;
	private String nome_engenheiro;
	private String cpf_cnpj_engenheiro;
	private String fone_engenheiro;
	private String sexo_engenheiro;
	private String logradouro_engenheiro;
	private String cidade_engenheiro;
	private String estado_engenheiro;
	private String email_engenheiro;
	private String compl_engenheiro;
	private Calendar dta_cad_engenheiro;
	private String rg_engenheiro;

    public Engenheiro() {

    }



    public int getCod_engenheiro() {
        return cod_engenheiro;
    }

    public void setCod_engenheiro(int cod_engenheiro) {
        this.cod_engenheiro = cod_engenheiro;
    }

    public String getNome_engenheiro() {
        return nome_engenheiro;
    }

    public void setNome_engenheiro(String nome_engenheiro) {
        this.nome_engenheiro = nome_engenheiro;
    }

    public String getCpf_cnpj_engenheiro() {
        return cpf_cnpj_engenheiro;
    }

    public void setCpf_cnpj_engenheiro(String cpf_cnpj_engenheiro) {
        this.cpf_cnpj_engenheiro = cpf_cnpj_engenheiro;
    }

    public String getFone_engenheiro() {
        return fone_engenheiro;
    }

    public void setFone_engenheiro(String fone_engenheiro) {
        this.fone_engenheiro = fone_engenheiro;
    }

    public String getSexo_engenheiro() {
        return sexo_engenheiro;
    }

    public void setSexo_engenheiro(String sexo_engenheiro) {
        this.sexo_engenheiro = sexo_engenheiro;
    }

    public String getLogradouro_engenheiro() {
        return logradouro_engenheiro;
    }

    public void setLogradouro_engenheiro(String logradouro_engenheiro) {
        this.logradouro_engenheiro = logradouro_engenheiro;
    }

    public String getCidade_engenheiro() {
        return cidade_engenheiro;
    }

    public void setCidade_engenheiro(String cidade_engenheiro) {
        this.cidade_engenheiro = cidade_engenheiro;
    }

    public String getEstado_engenheiro() {
        return estado_engenheiro;
    }

    public void setEstado_engenheiro(String estado_engenheiro) {
        this.estado_engenheiro = estado_engenheiro;
    }

    public String getEmail_engenheiro() {
        return email_engenheiro;
    }

    public void setEmail_engenheiro(String email_engenheiro) {
        this.email_engenheiro = email_engenheiro;
    }

    public String getCompl_engenheiro() {
        return compl_engenheiro;
    }

    public void setCompl_engenheiro(String compl_engenheiro) {
        this.compl_engenheiro = compl_engenheiro;
    }

    public Calendar getDta_cad_engenheiro() {
        return dta_cad_engenheiro;
    }

    public void setDta_cad_engenheiro(Calendar dta_cad_engenheiro) {
        this.dta_cad_engenheiro = dta_cad_engenheiro;
    }

    public String getRg_engenheiro() {
        return rg_engenheiro;
    }

    public void setRg_engenheiro(String rg_engenheiro) {
        this.rg_engenheiro = rg_engenheiro;
    }

   
        
        

      public Engenheiro(int cod_engenheiro, String nome_engenheiro,String cpf_cnpj_engenheiro,String fone_engenheiro,String sexo_engenheiro,
			String logradouro_engenheiro,String cidade_engenheiro,String estado_engenheiro,String email_engenheiro,String rg_engenheiro,String compl_engenheiro,
			Calendar dta_cad_engenheiro){
		cod_engenheiro=cod_engenheiro;
		nome_engenheiro=nome_engenheiro;
		cpf_cnpj_engenheiro=cpf_cnpj_engenheiro;
		fone_engenheiro=fone_engenheiro;
		sexo_engenheiro=sexo_engenheiro;
		logradouro_engenheiro=logradouro_engenheiro;
		cidade_engenheiro=cidade_engenheiro;
		estado_engenheiro=estado_engenheiro;
		email_engenheiro=email_engenheiro;
		compl_engenheiro=compl_engenheiro;
		rg_engenheiro=rg_engenheiro;
		
		dta_cad_engenheiro=dta_cad_engenheiro;
	}

        
}
