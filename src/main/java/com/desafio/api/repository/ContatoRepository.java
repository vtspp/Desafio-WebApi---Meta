package com.desafio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.api.model.Contato;
@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{
	
	@Query("from Contato c where c.idContato= :idContato")
		Contato findContatoById(@Param("idContato") Integer idContato);
}

