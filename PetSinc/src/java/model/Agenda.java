/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ad
 */
public class Agenda {
    
    private Integer id;    
    private String descricao;  
    private String executante;
    private Date dataInicio;
    private Date dataFim;
    private Integer idCliente;          
    private String prioridadeAgenda;
    private boolean diaTodo;

    @Override
    public String toString() {
        return "Agenda{" + "id=" + id + ", descricao=" + descricao + ", executante=" + executante + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", idCliente=" + idCliente + ", prioridadeAgenda=" + prioridadeAgenda + ", diaTodo=" + diaTodo + '}';
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getExecutante() {
        return executante;
    }

    public void setExecutante(String executante) {
        this.executante = executante;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }   

    public String getPrioridadeAgenda() {
        return prioridadeAgenda;
    }

    public void setPrioridadeAgenda(String prioridadeAgenda) {
        this.prioridadeAgenda = prioridadeAgenda;
    }

    public boolean isDiaTodo() {
        return diaTodo;
    }

    public void setDiaTodo(boolean diaTodo) {
        this.diaTodo = diaTodo;
    }

    
}
