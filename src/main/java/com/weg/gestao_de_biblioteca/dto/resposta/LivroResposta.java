package com.weg.gestao_de_biblioteca.dto.resposta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LivroResposta(
        Long id,
        String titulo,
        String isbn,
        BigDecimal preco,
        LocalDate dataPublicao,
        String categoria
) {
}
