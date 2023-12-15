package soil.planter.android.frontend

sealed class ScreenClass(val route: String) { // only classes inside this class can inherit
    object HomeScreen : ScreenClass("home_page")
    object DictionaryScreen : ScreenClass("encyclopedia_page")
    object ShopScreen : ScreenClass("shop_page")
}
