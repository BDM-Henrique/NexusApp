package br.com.nexus.ui.theme.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nexus.R
import br.com.nexus.model.Produto
import br.com.nexus.sampledata.sampleProduto
import br.com.nexus.ui.theme.NexusTheme
import java.math.BigDecimal

@Composable
fun SelecaoProduto(
    title: String,
    produtos: List<Produto>,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            text = title,
            Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        LazyRow(
            Modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(produtos){ p ->
                ProdutoItens(produto = p )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelecaoProdutoPreview() {
    NexusTheme {
        Surface {
            SelecaoProduto("Ofertas", produtos = sampleProduto)
        }
    }
}

