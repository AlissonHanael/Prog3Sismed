/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.bsi.sismed.bean;

/**
 *
 * @author Alisson
 */
public class Cidade {
    private int idCidade;
    private String nomeCidade;
    //representa a chave estrangeira
    private Estado estadoCidade;

    /**
     * @return the idCidade
     */
    public int getIdCidade() {
        return idCidade;
    }

    /**
     * @param idCidade the idCidade to set
     */
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    /**
     * @return the nomeCidade
     */
    public String getNomeCidade() {
        return nomeCidade;
    }

    /**
     * @param nomeCidade the nomeCidade to set
     */
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    /**
     * @return the estadoCidade
     */
    public Estado getEstadoCidade() {
        return estadoCidade;
    }

    /**
     * @param estadoCidade the estadoCidade to set
     */
    public void setEstadoCidade(Estado estadoCidade) {
        this.estadoCidade = estadoCidade;
    }
}
