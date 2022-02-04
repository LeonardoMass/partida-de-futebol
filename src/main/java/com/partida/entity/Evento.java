/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partida.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;



/**
 *
 * @author leona
 */
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    
    
    private String local;
    private String dataS;
    private Date data;

    
    @OneToMany(mappedBy = "evento")
    private List<Time> time = new ArrayList<Time>();
   
    
    public Evento(Integer id, String local, String dataS) {
        this.id = id;
        this.local = local;
        this.data = data;
       
    }

    public List<Time> getTime() {
        return time;
    }

    public void setTime(List<Time> time) {
        this.time = time;
    }


    public Evento() {
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDataS() {
        return dataS;
    }

    public void setDataS(String dataS) {
        this.dataS = dataS;
    }

    
    
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setLocal(String local) {
        this.local = local;
    }


    
    
    
    public Integer getId() {
        return id;
    }

    public String getLocal() {
        return local;
    }


    @Override
    public String toString() {
        return "===========\nEvento{" + "id=" + id + ", local=" + local + ", data="+ data ;
    }

}
