package com.weg.gestao_de_biblioteca.repository;

import com.weg.gestao_de_biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
