package soil.planter.android.frontend

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import soil.planter.android.frontend.Composables.TopBar
import soil.planter.android.frontend.Pages.Encyclopedia.DictionaryScreen
import soil.planter.android.frontend.Pages.Home.HomeScreen
import soil.planter.android.frontend.Pages.Shop.ShopScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController=navController, startDestination= ScreenClass.HomeScreen.route) {
        // list of all Screens the controller can navigate to
        composable(route = ScreenClass.HomeScreen.route) {
            Column(modifier = Modifier.padding(bottom = 60.dp)) {
                TopBar(type=0)
                HomeScreen()

            }
        }
        composable(route = ScreenClass.DictionaryScreen.route) {

            Column(modifier = Modifier.padding(bottom = 60.dp)) {
                TopBar(type=1)
                DictionaryScreen()

            }        }
        composable(route= ScreenClass.ShopScreen.route) {

            Column(modifier = Modifier.padding(bottom = 60.dp)) {
                TopBar(type=1)
                ShopScreen()

            }
        }

    }
}

