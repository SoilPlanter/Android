package soil.planter.android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import soil.planter.android.frontend.Composables.DisplayPages
import soil.planter.android.frontend.Composables.TopBar

//TODO
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            soil.planter.android.frontend.ui.theme.SoilTheme {

                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize().background(color= Color.White),

                ) {
                    val navController = rememberNavController()
                    TopBar()

                    DisplayPages(
                        navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        }
                    )
                }
            }
        }
    }
}