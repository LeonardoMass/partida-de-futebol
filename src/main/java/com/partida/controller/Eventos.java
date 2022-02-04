/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partida.controller;



import com.partida.DAO.EventoDAO;
import com.partida.entity.Evento;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author leona
 */
@RestController
@ResponseBody
public class Eventos {

    @Autowired
    EventoDAO EventoDAO;

    
    

    @RequestMapping("/cadastrar/evento")
    public void cadastrarEvento(@RequestBody Evento evento) throws ParseException {
        
        
         EventoDAO.cadastrarD(evento);
    }
    
// listar tudo
    @RequestMapping("/listar/evento")
    public void listarEvento() {
        
       EventoDAO.listar();
        
    }
    @RequestMapping("/listar/evento/{id}")
    public void buscarID(@PathVariable int id) {

        EventoDAO.buscarID(id);
    }
    
        
       @RequestMapping("/placar")
    public void atualizarPlacar(@RequestParam("id") Integer id, @RequestParam("t1") Integer t1, @RequestParam("t2") Integer t2) {
        
       EventoDAO.attPlacar(id, t1,t2);
        
    }
    
     @RequestMapping("/deletar")
    public void atualizarPlacar(@RequestParam("id") int id) {
        
       EventoDAO.deletarEvento(id);
        
    }

}
