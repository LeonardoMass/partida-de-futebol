/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partida.repository;



import com.partida.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author leona
 */

public interface EventoRepository extends JpaRepository<Evento, Integer>  {
    Evento findById(Long id);
}
