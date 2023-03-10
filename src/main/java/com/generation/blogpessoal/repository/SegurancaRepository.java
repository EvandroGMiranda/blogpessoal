package com.generation.blogpessoal.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.UsuarioLoginModel;

@Repository
public interface SegurancaRepository extends JpaRepository<UsuarioLoginModel, Long>{

	public Optional<UsuarioLoginModel> findByUsuario(String usuario); 
	
	
}
