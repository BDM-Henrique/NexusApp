package br.com.nexus.sampledata

import br.com.nexus.R
import br.com.nexus.model.Produto
import java.math.BigDecimal

val sampleProdutos = listOf(
    Produto(
        name = "Hamburguer",
        price = BigDecimal("19.99"),
        image = R.drawable.burger
    ),
    Produto(
        name = "Pizza",
        price = BigDecimal("19.99"),
        image = R.drawable.pizza
    ),
    Produto(
        name = "Batata-Frita",
        price = BigDecimal("7.99"),
        image = R.drawable.fritas
    )
)