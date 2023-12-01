package br.com.nexus.ui.theme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import br.com.nexus.sampledata.sampleSections
import br.com.nexus.ui.theme.NexusTheme
import br.com.nexus.ui.theme.screens.InicialScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    NexusTheme {
        Surface {
            InicialScreen(
                sampleSections
            )
        }
    }
}