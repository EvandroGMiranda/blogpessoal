package com.example.blogpessoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.blogpessoal.model.PostagemModel;

	@Repository
	public interface PostageRepository extends JpaRepository<PostagemModel, Long> {
		public List<PostagemModel>findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	}
