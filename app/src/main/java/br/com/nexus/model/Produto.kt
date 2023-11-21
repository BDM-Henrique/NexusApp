package br.com.nexus.model

import androidx.annotation.DrawableRes
import java.math.BigDecimal

class Produto (
    val name: String,
    val price: BigDecimal,
    @DrawableRes val image: Int
)
