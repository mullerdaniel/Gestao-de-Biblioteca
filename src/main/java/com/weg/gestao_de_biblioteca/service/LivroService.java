package com.weg.gestao_de_biblioteca.service;

import com.weg.gestao_de_biblioteca.model.Livro;
import com.weg.gestao_de_biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }


    public List<Livro> buscarLivrosPeloTitulo(String titulo) {

        return livroRepository.findByTitulo(titulo);
    }


    public List<Livro> buscarLivrosPorCategoriaMenorPreco(String categoria, BigDecimal preco) {

        return livroRepository.findByCategoriaAndPrecoLessThan(categoria, preco);
    }


    public List<Livro> buscarLivrosPeloMaiorPrecoMenor(BigDecimal max, BigDecimal min) {

        return livroRepository.findByPrecoBetween(max, min);
    }

    public List<Livro> buscarLivrosPorCategoria(List<String> categorias) {

        return livroRepository.findByCategoriaIn(categorias);
    }


    public List<Livro> buscarIsbnNull() {

        return livroRepository.findByIsbnIsNull();
    }


    public Long buscarAutorPorNacionalidade(String nacionalidade) {

        return livroRepository.countByAutoresNacionalidade(nacionalidade);
    }


    public List<Livro> buscarAutorPeloNome(String nome) {

        return livroRepository.findByAutoresNome(nome);
    }

    public List<Livro> buscarTitulosPorCategorias(String categoria) {

        return livroRepository.buscarTitulosPorCategorias(categoria);
    }


    public List<Livro> buscarPorNomeAutor(String nome) {

        return livroRepository.buscarPorNomeAutor(nome);
    }


    public List<Livro> buscarLivroComAutores() {

        return livroRepository.buscarLivrosComAutores();
    }

    public List<Livro> livrosAcimaDaMedia() {

        return livroRepository.livrosAcimaDaMedia();
    }


    public List<Livro> livros2023() {

        return livroRepository.livros2023();
    }


    public List<Livro> livrosAutoresBrasileiros() {

        return livroRepository.livrosAutoresBrasileiros();
    }


    public List<Livro> buscarCategoriaIgonoreCase(String categoria) {

        return livroRepository.buscarCategoriaIgnoreCase(categoria);
    }



}
