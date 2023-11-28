package br.com.nexus.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.nexus.R
import br.com.nexus.model.Produto
import br.com.nexus.sampledata.sampleSections
import br.com.nexus.ui.theme.components.SelecaoProduto
import java.math.BigDecimal

@Composable
fun InicialScreen(
    sections: Map<String, List<Produto>>
) {
    LazyColumn(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item {
            Spacer(Modifier)
        }

        for (section in sections){
            val title = section.key
            val produto = section.value
            item {
                SelecaoProduto(
                    title = title,
                    produtos = produto)
            }
        }
        item {
            Spacer(Modifier)
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun InicialScreenPreview() {
    InicialScreen(sampleSections)
}