package soil.planter.android.frontend.Composables.Bar

data class PageData(val title: String,
    val topBarType: TopBarTypes




) {
    constructor() : this(String(),TopBarTypes.OTHER)
}