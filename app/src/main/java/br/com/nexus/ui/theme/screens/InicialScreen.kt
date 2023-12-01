package br.com.nexus.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.nexus.model.Produto
import br.com.nexus.sampledata.sampleProduto
import br.com.nexus.sampledata.sampleSections
import br.com.nexus.ui.components.CartaoProdutoItem
import br.com.nexus.ui.theme.NexusTheme
import br.com.nexus.ui.theme.components.CampoDePesquisa
import br.com.nexus.ui.theme.components.SelecaoProduto


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicialScreen(
    sections: Map<String, List<Produto>>,
    searchText: String = ""
) {
    Column {
        var text by remember {
            mutableStateOf(searchText)
        }
        CampoDePesquisa(
            searchText = text,
            onSearchChange = { text = it },
        )
        val searchProduto = remember(text) {
            if (text.isNotBlank()) {
                sampleProduto.filter { produto ->
                    produto.name.contains(
                        text,
                        ignoreCase = true,
                    ) ||
                            produto.description?.contains(
                                text,
                                ignoreCase = true,
                            ) ?: false
                }
            } else emptyList()
        }
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                Spacer(Modifier)
            }
            if (text.isBlank()) {
                for (section in sections) {
                    val title = section.key
                    val produto = section.value
                    item {
                        SelecaoProduto(
                            title = title,
                            produtos = produto
                        )
                    }
                }
            } else {
                items(searchProduto) { p ->
                    CartaoProdutoItem(
                        produto = p,
                        Modifier.padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun InicialScreenPreview() {
    NexusTheme {
        Surface {
            InicialScreen(sampleSections)
        }
    }
}

@Preview
@Composable
fun InicialScreenWithSearchTextPreview() {
    NexusTheme {
        Surface {
            InicialScreen(
                sampleSections,
                searchText = "pizza",
            )
        }
    }
}