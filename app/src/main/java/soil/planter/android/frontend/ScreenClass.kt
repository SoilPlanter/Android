package soil.planter.android.frontend

import soil.planter.android.frontend.Composables.PageManager

sealed class ScreenClass(val route: String) { // only classes inside this class can inherit
    object HomePage : ScreenClass(PageManager.HOME_PAGE)
    object EncyclopediaPage : ScreenClass(PageManager.ENCYCLOPEDIA_PAGE)
    object ShopPage : ScreenClass(PageManager.SHOP_PAGE)
}
