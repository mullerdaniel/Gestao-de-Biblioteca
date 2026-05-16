package com.weg.gestao_de_biblioteca.dto.requisicao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LivroRequisicao(
        String titulo,
        String isbn,
        BigDecimal preco,
        LocalDate dataPublicao,
        String categoria
) {
}
