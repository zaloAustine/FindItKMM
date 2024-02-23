import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import authentication.LoginScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

private val primaryColor = Color(0xFF0BC3CF)
private val Amber = Color(0xFFFFC107)
private val LightGray = Color(0xFFECEFF1)
private val DarkGray = Color(0xFF212121)
private val white = Color.White

@Composable
fun FindItTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(
            primary = primaryColor,
            secondary = Amber,
            background = white,
            onBackground = DarkGray
        ),
        shapes = Shapes(),
        content = content,
        typography = Typography(defaultFontFamily = FontFamily.SansSerif)
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    FindItTheme {
        Navigator(LoginScreen()) { navigator ->
            Scaffold { inner ->
                TopAppBar(
                    backgroundColor = Color.White,
                    contentColor = DarkGray,
                    elevation = 0.dp,
                    modifier = Modifier.fillMaxWidth().padding(start = 8.dp)
                        .shadow(elevation = 0.dp), // Add padding
                    content = {
                        Column {
                            if (navigator.canPop) {
                                if (getPlatform().name == "Android") {
                                    Icon(
                                        painter = painterResource("arrow-back-android.xml"),
                                        contentDescription = "",
                                        Modifier.align(Alignment.Start)
                                            .clickable { navigator.pop() }
                                    )
                                } else {
                                    Icon(
                                        painter = painterResource("arrow-back-ios.xml"),
                                        contentDescription = "",
                                        Modifier.align(Alignment.Start)
                                            .clickable { navigator.pop() }
                                    )
                                }
                            }
                        }
                    }
                )
                SlideTransition(navigator = navigator, Modifier.padding(inner))
            }
        }
    }
}