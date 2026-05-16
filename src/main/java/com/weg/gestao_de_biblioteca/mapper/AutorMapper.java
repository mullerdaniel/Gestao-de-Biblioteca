package com.weg.gestao_de_biblioteca.mapper;

import com.weg.gestao_de_biblioteca.dto.requisicao.AutorRequisicao;
import com.weg.gestao_de_biblioteca.dto.resposta.AutorResposta;
import com.weg.gestao_de_biblioteca.model.Autor;

public class AutorMapper {

    public static Autor toEntity(AutorRequisicao dto) {
        Autor autor = new Autor();

        autor.setNome(dto.nome());
        autor.setNacionalidade(dto.nacionalidade());

        return autor;
    }

    public static AutorResposta toResposta(Autor autor) {
        return new AutorResposta(
                autor.getId(),
                autor.getNome(),
                autor.getNacionalidade()
        );
    }
}
