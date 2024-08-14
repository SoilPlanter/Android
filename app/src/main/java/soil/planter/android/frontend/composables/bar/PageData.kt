package soil.planter.android.frontend.composables.bar

data class PageData(var title: String,
                    var topBarType: TopBarTypes,
                    var showBottomBar: Boolean




) {
    constructor() : this("Default",TopBarTypes.COLLAPSED,true)
}