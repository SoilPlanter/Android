package soil.planter.android.frontend.Composables

import soil.planter.android.frontend.Composables.Bar.PageData
import soil.planter.android.frontend.Composables.Bar.TopBarTypes

class PageManager {
    companion object {
        const val DEFAULT: String = "default"
        const val HOME_PAGE: String= "home_page"
        const val ENCYCLOPEDIA_PAGE: String= "encyclopedia_page"
        const val SHOP_PAGE: String= "shop_page"


        fun createPageData(s: String): PageData {
            when (s){
                HOME_PAGE->{
                    return PageBuilder()
                        .setTitle("Home")
                        .isTopBarVisible(true)
                        .setTopBarType(TopBarTypes.COLLAPSED)
                        .isBottomBarVisible(true)

                        .build()

                }

                ENCYCLOPEDIA_PAGE ->{
                    return PageBuilder()
                        .setTitle("Encyclopedia")

                        .isTopBarVisible(true)
                        .setTopBarType(TopBarTypes.EXTENDED)
                        .isBottomBarVisible(true)
                        .build()

                }
                SHOP_PAGE -> {
                    return PageBuilder()
                        .setTitle("Shop")

                        .isTopBarVisible(true)
                        .setTopBarType(TopBarTypes.EXTENDED)
                        .isBottomBarVisible(true)
                        .build()

                }
            }
            return PageData()
        }
    }

    class PageBuilder{
        var pageData : PageData = PageData()

        fun build() : PageData {
            return pageData
        }

        fun setTopBarType(type: TopBarTypes): PageBuilder {
            pageData.topBarType = type;
            return this
        }

        fun isBottomBarVisible(b: Boolean): PageBuilder {
            pageData.showBottomBar = b
            return this
        }
        fun isTopBarVisible(b: Boolean): PageBuilder {
            pageData.showBottomBar = b
            return this
        }

        fun setTitle(s: String): PageBuilder {
            pageData.title = s
            return this
        }

    }
}