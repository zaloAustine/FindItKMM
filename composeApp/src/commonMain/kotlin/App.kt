import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import authentication.LoginScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition

private val primaryColor = Color(0xFF0BC3CF)
private val Amber = Color(0xFFFFC107)
private val LightGray = Color(0xFFECEFF1)
private val DarkGray = Color(0xFF212121)

@Composable
fun FindItTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(
            primary = primaryColor,
            secondary = Amber,
            background = LightGray,
            onBackground = DarkGray
        ),
        shapes = Shapes(),
        content = content
    )
}

@Composable
fun App() {
    FindItTheme {
        Navigator(LoginScreen()) { navigator ->
            Scaffold { inner ->
                SlideTransition(navigator = navigator, Modifier.padding(inner))
            }
        }
    }
}