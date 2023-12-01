package br.com.nexus.ui.theme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nexus.ui.theme.NexusTheme
import kotlin.math.min

class AtividadeDeFormularioActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexusTheme {
                Surface {
                    ProdutoFormScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdutoFormScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Criando o produto",
            Modifier.fillMaxWidth(),
            fontSize = 28.sp,
        )
        var url by remember {
            mutableStateOf("")
        }

        TextField(
            value = url,
            onValueChange = {
                url = it
            },
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Link da Imagem")
            },
        )

        var name by remember {
            mutableStateOf("")
        }

        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome do Produto")
            },
        )

        var price by remember {
            mutableStateOf("")
        }

        TextField(
            value = price,
            onValueChange = {
                price = it
            },
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Preço do Produto")
            },
        )

        var description by remember {
            mutableStateOf("")
        }

        TextField(
            value = description,
            onValueChange = {
                description = it
            },
            Modifier.fillMaxWidth()
            .heightIn(min = 100.dp),
            label = {
                Text(text = "Descrição do Produto")
            },
        )
        Button(onClick = { /*TODO*/ }, Modifier.fillMaxWidth()) {
            Text(text = "Salvar")
        }
    }
}

@Preview
@Composable
fun ProdutoFormScreenPreview() {
    NexusTheme {
        Surface {
            ProdutoFormScreen()
        }
    }
}