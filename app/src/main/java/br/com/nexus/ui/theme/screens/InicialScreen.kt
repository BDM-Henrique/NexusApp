package br.com.nexus.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.nexus.R
import br.com.nexus.model.Produto
import br.com.nexus.sampledata.sampleProdutos
import br.com.nexus.ui.theme.components.SelecaoProduto
import java.math.BigDecimal

@Composable
fun InicialScreen(){
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier)
        SelecaoProduto("Ofertas", sampleProdutos)
        SelecaoProduto("Doces", listOf(Produto(name = "Chocolate",
            price = BigDecimal("5.99"),
            image = R.drawable.placeholder)))
        SelecaoProduto("Bebidas", sampleProdutos)
        Spacer(Modifier)
    }
}

@Preview(showSystemUi = true)
@Composable
fun InicialScreenPreview(){
    InicialScreen()
}