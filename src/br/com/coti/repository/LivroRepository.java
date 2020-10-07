package br.com.coti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coti.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {
	
}
