package com.example.articulo
import com.example.articulo.ui.theme.ArticuloTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticuloTheme  {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp(){
    GreetingArticle(
        title = stringResource(R.string.jetpack_titulo),
        shortText = stringResource(R.string.short_text),
        longText = stringResource(R.string.long_text),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun GreetingArticle(title: String,
                    shortText: String,
                    longText: String,
                    imagePainter: Painter,
                    modifier: Modifier = Modifier) {
    Column {
        Image(painter = imagePainter, contentDescription = null)
        Text(text = title, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(text = shortText, modifier = Modifier.padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify)
        Text(text = longText, modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPreview() {
    ArticuloTheme {
        ComposeArticleApp()
    }
}
