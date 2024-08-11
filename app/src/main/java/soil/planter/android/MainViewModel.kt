package soil.planter.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import soil.planter.android.frontend.Composables.Bar.PageData
import soil.planter.android.frontend.Composables.PageManager
import soil.planter.android.frontend.Composables.PageManager.Companion.HOME_PAGE

class MainViewModel : ViewModel() {
    // todo make private mutable and public getter
    val pageDataLive : MutableLiveData<PageData> = MutableLiveData<PageData>()
}


//TODO ROOM DB (bigger data) , DATASTORE (single data, simple)
//TODO API über RETROFIT (better architecture for many different calls), (VOLLEY)