package br.com.nexus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.nexus.R
import br.com.nexus.extensions.toBrazilianCurrency
import br.com.nexus.model.Produto
import br.com.nexus.sampledata.sampleProduto
import coil.compose.AsyncImage
import br.com.nexus.ui.theme.NexusTheme
import br.com.nexus.ui.theme.components.SelecaoProduto

@Composable
fun CartaoProdutoItem(
    produto: Produto,
    elevation: Dp = 4.dp
) {
    Card(
        Modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = elevation
    ) {
        Column {
            AsyncImage(
                model = produto.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp)
            ) {
                Text(
                    text = produto.name
                )
                Text(
                    text = produto.price.toBrazilianCurrency()
                )
            }
            // TODO: adicionar descrição do produto
            // Text(
            //     text = product.description,
            //     Modifier
            //         .padding(16.dp)
            // )
        }
    }
}

@Preview
@Composable
private fun CartaoProdutoItem() {
    NexusTheme {
        Surface {
            CartaoProdutoItem(
                produto = sampleProduto.random()
            )
        }
    }
}