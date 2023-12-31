package br.com.nexus.ui.theme.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.nexus.dao.ProdutoDao
import br.com.nexus.sampledata.sampleCandies
import br.com.nexus.sampledata.sampleDrinks
import br.com.nexus.sampledata.sampleProduto
import br.com.nexus.sampledata.sampleSections
import br.com.nexus.ui.theme.NexusTheme
import br.com.nexus.ui.theme.components.ProdutoItens
import br.com.nexus.ui.theme.screens.InicialScreen
import br.com.nexus.ui.theme.screens.InicialScreenUiState


class MainActivity : ComponentActivity() {

    private val dao = ProdutoDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this,
                    AtividadeDeFormularioActivity::class.java
                ))
            }){
                val produtos = dao.produtos()
                val sections = mapOf(
                    "Todos produtos" to sampleProduto,
                    "Ofertas" to sampleDrinks + sampleCandies,
                    "Doces" to sampleCandies,
                    "Bebidas" to sampleDrinks
                )
                val state = remember(produtos) {
                    InicialScreenUiState(sections = sections, produtos = produtos)
                }
                InicialScreen(state = state)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(onFabClick: () -> Unit = {}, content: @Composable () -> Unit = {}) {
    NexusTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)){
                    content()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview(){
    App{
        InicialScreen(InicialScreenUiState(sections = sampleSections))
    }
}