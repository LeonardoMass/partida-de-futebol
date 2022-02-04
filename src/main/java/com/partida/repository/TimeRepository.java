/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partida.repository;


import com.partida.entity.Evento;
import com.partida.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author leona
 */
public interface TimeRepository extends JpaRepository<Time, Integer>  {
    
    Time findByNome(String nome);
    Time findByEvento(Evento evento);
}
    

