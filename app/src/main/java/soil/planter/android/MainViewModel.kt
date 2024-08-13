package soil.planter.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import soil.planter.android.frontend.Composables.Bar.PageData
import soil.planter.android.frontend.Composables.PageManager
import soil.planter.android.frontend.Composables.PageManager.Companion.HOME_PAGE

class MainViewModel : ViewModel() {

    private val _pageDataLive = MutableLiveData(PageManager.createPageData(HOME_PAGE))
    val pageDataLive: LiveData<PageData> get() = _pageDataLive

    fun set(pageData: PageData) {
        _pageDataLive.value = pageData
    }
}



//TODO ROOM DB (bigger data) , DATASTORE (single data, simple)
//TODO API über RETROFIT (better architecture for many different calls), (VOLLEY)