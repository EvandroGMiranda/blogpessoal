package com.example.blogpessoal.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.blogpessoal.model.UsuarioLoginModel;

@Repository
public interface SegurancaRepository extends JpaRepository<UsuarioLoginModel, Long>{

	public Optional<UsuarioLoginModel> findByUsuario(String usuario); 
	

}
