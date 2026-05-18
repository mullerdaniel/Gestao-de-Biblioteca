package com.weg.gestao_de_biblioteca.repository;

import com.weg.gestao_de_biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
    List<Livro> findByTitulo(String titulo);

    List<Livro> findByCategoriaAndPrecoLessThan(String categoria, BigDecimal preco);

    List<Livro> findByPrecoBetween(BigDecimal max, BigDecimal min);

    List<Livro> findByCategoriaIn(List<String> categorias);

    List<Livro> findByIsbnIsNull();

    Long countByAutoresNacionalidade(String nacionalidade);

    List<Livro> findByAutoresNome(String nome);


    @Query("""
            SELECT livro.titulo
            FROM Livro livro
            WHERE livro.categoria = :categoria
            """)
    List<Livro> buscarTitulosPorCategorias(String categoria);

    @Query("""
            SELECT livro
            FROM Livro livro
            JOIN livro.autores autor
            WHERE autor.nome = :nome
            """)

    List<Livro> buscarPorNomeAutor(String nome);


    @Query("""
            SELECT livro
            FROM Livro livro
            JOIN FEATCH livro.autores
            """)
    List<Livro> buscarLivrosComAutores();


    @Query("""
            SELECT livro
            FROM Livro livro
            WHERE livro.preco > (SELECT AVG(l.preco) FROM Livro l)
            """)
    List<Livro> livrosAcimaDaMedia();


    @Query(value = """
            SELECT *
            FROM livro
            WHERE YEAR(data_publicacao) = 2023
            """, nativeQuery = true)
    List<Livro> livros2023();


    @Query(value = """
            SELECT livro.*
            FROM livro Livro
            JOIN livro_autores livroAutores
                ON livro.id = livroAutores.livro_id
            JOIN autor autor 
                ON autor.id = livroAutores.autor_id
            WHERE autor.nacionalidade = 'Brasileira'
            """, nativeQuery = true)
    List<Livro> livrosAutoresBrasileiros();


    @Query(value = """
            SELECT *
            FROM livro
            WHERE LOWER(categoria) = LOWER(:categoria)
            """, nativeQuery = true)
    List<Livro> buscarCategoriaIgnoreCase(String categoria);




}
