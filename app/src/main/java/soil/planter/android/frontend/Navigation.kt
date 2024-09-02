package soil.planter.android.frontend

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import soil.planter.android.MainViewModel
import soil.planter.android.frontend.composables.PageManager
import soil.planter.android.frontend.pages.encyclopedia.EncyclopediaPage
import soil.planter.android.frontend.pages.home.HomePage
import soil.planter.android.frontend.pages.shop.ShopPage

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Navigation(
    viewModel: MainViewModel,
    navController: NavHostController
) {
    NavHost(navController=navController, startDestination= ScreenClass.HomePage.route) {
        // list of all Screens the controller can navigate to
        composable(route = ScreenClass.HomePage.route) {
            viewModel.set(PageManager.createPageData(PageManager.HOME_PAGE))
            HomePage()
        }
        composable(route = ScreenClass.EncyclopediaPage.route) {
            viewModel.set(PageManager.createPageData(PageManager.ENCYCLOPEDIA_PAGE))
            EncyclopediaPage()
        }
        composable(route= ScreenClass.ShopPage.route) {
            viewModel.set(PageManager.createPageData(PageManager.SHOP_PAGE))

            ShopPage()
        }

    }
}

