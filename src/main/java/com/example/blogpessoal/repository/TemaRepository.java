package com.example.blogpessoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.blogpessoal.model.PostagemTema;

	@Repository
	public interface TemaRepository extends JpaRepository<PostagemTema, Long> {
		public List<PostagemTema> findAllByDescricaoContainingIgnoreCase(@Param("Descricao")String descricao );
	}
