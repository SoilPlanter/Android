package soil.planter.android.jetpackCompose.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import soil.planter.android.jetpackCompose.classes.ScreenClass

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController=navController, startDestination=ScreenClass.HomeScreen.route) {
        // list of all Screens the controller can navigate to
        composable(route = ScreenClass.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = ScreenClass.DictionaryScreen.route) {
            DictionaryScreen()
        }
        composable(route=ScreenClass.ShopScreen.route) {
            ShopScreen()
        }

    }
}

