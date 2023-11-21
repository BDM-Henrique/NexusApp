package br.com.nexus.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.nexus.ui.theme.NexusTheme

@Composable
fun MyFirstComposable(){
    Text(text = "Meu Primeiro texto")
    Text(text = "Meu Segundo Texto")
}

@Preview(showBackground = true)
@Composable
fun CollumnPreview(){
    Column {
        Text(text = "Login: ")
        Text(text = "Senha: ")
    }
}

@Composable
fun MyFirstComposablePreview(){
    NexusTheme {
        Surface {
            MyFirstComposable()
        }
    }

}