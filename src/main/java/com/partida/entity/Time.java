/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partida.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;



@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    private String nome;
    private String corCamisa;
    private int numeroGol = 0;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    public Time() {
    }

  

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCorCamisa(String corCamisa) {
        this.corCamisa = corCamisa;
    }

    public void setNumeroGol(int numeroGol) {
        this.numeroGol = numeroGol;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCorCamisa() {
        return corCamisa;
    }

    public int getNumeroGol() {
        return numeroGol;
    }

    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return  nome + "("+corCamisa+"): "+numeroGol;
    }


   
    
    
}
