package com.weg.gestao_de_biblioteca.dto.resposta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AutorResposta(
        Long id,
        String nome,
        String nacionalidade
) {
}
