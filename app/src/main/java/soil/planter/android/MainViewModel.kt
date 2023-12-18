package soil.planter.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import soil.planter.android.frontend.Composables.Bar.PageData
import soil.planter.android.frontend.Composables.PageManager
import soil.planter.android.frontend.Composables.PageManager.Companion.HOME_PAGE

class MainViewModel : ViewModel() {
    val pageDataLive : MutableLiveData<PageData> = MutableLiveData<PageData>()
}