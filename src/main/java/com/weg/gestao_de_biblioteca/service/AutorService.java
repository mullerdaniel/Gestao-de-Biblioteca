package com.weg.gestao_de_biblioteca.service;

import com.weg.gestao_de_biblioteca.dto.requisicao.AutorRequisicao;
import com.weg.gestao_de_biblioteca.dto.resposta.AutorResposta;
import com.weg.gestao_de_biblioteca.mapper.AutorMapper;
import com.weg.gestao_de_biblioteca.model.Autor;
import com.weg.gestao_de_biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    public AutorResposta salvar(AutorRequisicao dto) {
        Autor autor = AutorMapper.toEntity(dto);

        return AutorMapper.toResposta(
                autorRepository.save(autor)
        );

        
    }
}
