/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partida.DAO;

import com.partida.entity.Evento;
import com.partida.entity.Time;
import com.partida.repository.EventoRepository;
import com.partida.repository.TimeRepository;
import com.sun.istack.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author leona
 */
@Service
public class EventoDAO {

    static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private EventoRepository repositoryEvento;
    @Autowired
    private TimeRepository repositoryTime;

    public Evento cadastrar(Evento evento) throws ParseException {

        Date data = sdf1.parse(evento.getDataS());
        evento.setData(data);
        evento = repositoryEvento.saveAndFlush(evento);

        return evento;
    }

    public void cadastrarD(Evento evento) throws ParseException {
        Date data = sdf1.parse(evento.getDataS());
        evento.setData(data);

        if (evento.getLocal() == null || evento.getData() == null) {
            System.out.println("dados nulos em evento");
        } else if (evento.getTime().get(0).getNome() == null || evento.getTime().get(1).getNome() == null || evento.getTime().get(0).getCorCamisa() == null
                || evento.getTime().get(1).getCorCamisa() == null) {
            System.out.println("Nome ou cor da camisa dos times nula");
        } else if (evento.getTime().get(0).getNome().equalsIgnoreCase(evento.getTime().get(1).getNome())) {
            System.out.println("NOMEs iguais");

        } else if (evento.getTime().get(0).getCorCamisa().equalsIgnoreCase(evento.getTime().get(1).getCorCamisa())) {
            System.out.println("Cor da camisa iguais");
        } else {

            evento = repositoryEvento.saveAndFlush(evento);

            for (Time t : evento.getTime()) {
                t.setEvento(evento);
                repositoryTime.saveAndFlush(t);
                System.out.println(t.toString());
            }

        }
    }

    public void buscarID(int id) {

        if (repositoryEvento.findById(id).isPresent()) {
            Evento evento = repositoryEvento.findById(id).get();
            System.out.println(evento.toString());
            for (Time t : evento.getTime()) {
                System.out.println(t.toString());
            }

        } else {
            System.out.println("Não encontrado");

        }

    }

    @NotNull
    public void listar() {

        List<Evento> evento = repositoryEvento.findAll();

        for (Evento c : evento) {
            System.out.println(c.toString());
            for (Time t : c.getTime()) {
                System.out.println(t.toString());

            }
            System.out.println("=============");
        }

    }

    public void attPlacar(int id, int t1, int t2) {

        Evento evento = repositoryEvento.findById(id).get();

        if (t1 < 0 && t2 < 0) {
            System.out.println("Saldo de gol menor que zero");
        } else {

            evento.getTime().get(0).setNumeroGol(t1);
            evento.getTime().get(1).setNumeroGol(t2);
            repositoryTime.saveAll(evento.getTime());

            System.out.println(evento.toString());
            for (Time t : evento.getTime()) {
                System.out.println(t.toString());
            }

        }

    }
    
    public void deletarEvento(int id){
        System.out.println("Deletado evento "+id);
        Evento evento = repositoryEvento.findById(id).get();
        repositoryTime.deleteAllInBatch(evento.getTime());
        
        repositoryEvento.deleteById(id);
        
        
    }

}
