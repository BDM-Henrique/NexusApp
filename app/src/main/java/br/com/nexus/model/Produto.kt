package br.com.nexus.model

import androidx.annotation.DrawableRes
import java.math.BigDecimal

data class Produto (
    val name: String,
    val price: BigDecimal,
    val image: String? = null,
    val description: String? = null
)