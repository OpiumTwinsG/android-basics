package my.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import my.androidbasics.ui.amphibians.AmphibianList
import my.androidbasics.ui.amphibians.AmphibiansViewModel

import androidx.compose.ui.tooling.preview.Preview
import my.androidbasics.ui.theme.AndroidBasicsTheme

class MainActivity : ComponentActivity() {

    private val viewModel: AmphibiansViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding  ->
                    AmphibianList(
                        items  = viewModel.amphibians.value,
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}