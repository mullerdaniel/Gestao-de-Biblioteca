package com.weg.gestao_de_biblioteca.mapper;

import com.weg.gestao_de_biblioteca.dto.requisicao.LivroRequisicao;
import com.weg.gestao_de_biblioteca.dto.resposta.LivroResposta;
import com.weg.gestao_de_biblioteca.model.Livro;

public class LivroMapper {

    public static Livro toEntity(LivroRequisicao dto) {
        Livro livro = new Livro();
        dto.titulo();
        dto.isbn();
        dto.preco();
        dto.dataPublicao();
        dto.categoria();

        return livro;
    }

    public static LivroResposta toResposta(Livro livro) {
        return new LivroResposta(
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getPreco(),
                livro.getDataPublicacao(),
                livro.getCategoria()
        );
    }
}
