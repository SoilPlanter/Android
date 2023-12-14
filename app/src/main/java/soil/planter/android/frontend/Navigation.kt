package soil.planter.android.frontend

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import soil.planter.android.frontend.Pages.Encyclopedia.DictionaryScreen
import soil.planter.android.frontend.Pages.Home.HomeScreen
import soil.planter.android.frontend.Pages.Shop.ShopScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController=navController, startDestination= ScreenClass.HomeScreen.route) {
        // list of all Screens the controller can navigate to
        composable(route = ScreenClass.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = ScreenClass.DictionaryScreen.route) {
            DictionaryScreen()
        }
        composable(route= ScreenClass.ShopScreen.route) {
            ShopScreen()
        }

    }
}

