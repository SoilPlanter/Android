package soil.planter.android.frontend

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plcoding.searchfieldcompose.ShopPresenter
import soil.planter.android.LocalPresenter
import soil.planter.android.frontend.Composables.PageManager
import soil.planter.android.frontend.Pages.Encyclopedia.EncyclopediaPage
import soil.planter.android.frontend.Pages.Encyclopedia.EncyclopediaPresenter
import soil.planter.android.frontend.Pages.Home.HomePresenter
import soil.planter.android.frontend.Pages.Home.HomeScreen
import soil.planter.android.frontend.Pages.Shop.ShopPage
import soil.planter.android.presenter

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController=navController, startDestination= ScreenClass.HomePage.route) {
        // list of all Screens the controller can navigate to
        composable(route = ScreenClass.HomePage.route) {
            presenter.pageDataLive.postValue(PageManager.createPageData(PageManager.HOME_PAGE))
            CompositionLocalProvider(LocalPresenter provides HomePresenter()) {

                HomeScreen()
            }
        }
        composable(route = ScreenClass.EncyclopediaPage.route) {
            presenter.pageDataLive.postValue(PageManager.createPageData(PageManager.ENCYCLOPEDIA_PAGE))


            CompositionLocalProvider(LocalPresenter provides EncyclopediaPresenter()) {
                EncyclopediaPage()
            }
        }
        composable(route= ScreenClass.ShopPage.route) {
            presenter.pageDataLive.postValue(PageManager.createPageData(PageManager.SHOP_PAGE))


            CompositionLocalProvider(LocalPresenter provides ShopPresenter()) {

                ShopPage()
            }
        }

    }
}

