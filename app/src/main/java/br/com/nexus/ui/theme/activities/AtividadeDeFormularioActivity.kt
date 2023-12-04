package br.com.nexus.ui.theme.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nexus.R
import br.com.nexus.dao.ProdutoDao
import br.com.nexus.model.Produto
import br.com.nexus.ui.theme.NexusTheme
import coil.compose.AsyncImage
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.text.DecimalFormat
import kotlin.math.min

class AtividadeDeFormularioActivity : ComponentActivity() {

    private val dao = ProdutoDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexusTheme {
                Surface {
                    ProdutoFormScreen(onSaveClick = { produto ->
                        dao.save(produto)
                        finish()
                    })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdutoFormScreen(
    onSaveClick: (Produto) -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(
            text = "Criando o produto",
            Modifier.fillMaxWidth(),
            fontSize = 28.sp,
        )
        var url by remember {
            mutableStateOf("")
        }
        if (url.isNotBlank()) {
            AsyncImage(
                model = url, contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )

        var price by remember {
            mutableStateOf("")
        }
        val formatter = remember {
            DecimalFormat("#.##")
        }
        TextField(
            value = price,
            onValueChange = {
                try {
                    price = formatter.format(BigDecimal(it))
                } catch (e: IllegalArgumentException){
                    if (it.isBlank()){
                        price = it
                    }
                }
            },
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Preço do Produto")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )

        var description by remember {
            mutableStateOf("")
        }

        TextField(
            value = description,
            onValueChange = {
                description = it
            },
            Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = {
                Text(text = "Descrição do Produto")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        Button(
            onClick = {
                val convercaoPrice = try {
                    BigDecimal(price)
                } catch (e: NumberFormatException) {
                    BigDecimal.ZERO
                }
                val produto = Produto(
                    name = name,
                    image = url,
                    price = convercaoPrice,
                    description = description
                )
                Log.i("ProdutoFormActivity", "ProdutoFormScreen: $produto")
                onSaveClick(produto)
            },
            Modifier.fillMaxWidth()
        ) {
            Text(text = "Salvar")
        }
        Spacer(modifier = Modifier)
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