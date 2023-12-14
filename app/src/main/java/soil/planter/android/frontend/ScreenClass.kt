package soil.planter.android.frontend

sealed class ScreenClass(val route: String) { // only classes inside this class can inherit
    object HomeScreen : ScreenClass("home_screen")
    object DictionaryScreen : ScreenClass("dictionary_screen")
    object ShopScreen : ScreenClass("shop_screen")
}
