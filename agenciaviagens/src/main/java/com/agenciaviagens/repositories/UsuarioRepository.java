package com.agenciaviagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenciaviagens.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
