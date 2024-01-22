package com.agenciaviagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenciaviagens.model.Destino;

public class DestinoRepository {

	@Repository
	public interface PedidoRepository extends JpaRepository<Destino, Long>{

	}
}
