package br.com.nexus.sampledata

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.nexus.model.Produto
import java.math.BigDecimal

val sampleCandies = listOf(
    Produto(
        name = "Chocolate",
        price = BigDecimal("3.99"),
        image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Produto(
        name = "Sorvete",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Produto(
        name = "Bolo",
        price = BigDecimal("11.99"),
        image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
        description = LoremIpsum(20).values.first()
    )
)

val sampleDrinks = listOf(
    Produto(
        name = "Cerveja",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Produto(
        name = "Refrigerante",
        price = BigDecimal("4.99"),
        image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Produto(
        name = "Suco",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Produto(
        name = "Água",
        price = BigDecimal("2.99"),
        image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg",
        description = LoremIpsum(20).values.first()
    )
)

val sampleProduto: List<Produto> = listOf(
    Produto(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Produto(
        name = "Pizza",
        price = BigDecimal("19.99"),
        image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Produto(
        name = "Batata Frita",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        description = LoremIpsum(20).values.first()
    ), *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray()
)

val sampleSections = mapOf(
    "Ofertas" to sampleProduto,
    "Doces" to sampleCandies,
    "Bebidas" to sampleDrinks
)