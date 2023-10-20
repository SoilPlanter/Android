package soil.planter.android

import android.os.Bundle
import android.text.Layout.Alignment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.platform.ComposeView

import androidx.fragment.app.Fragment

class HomeScreen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {
                Row(verticalAlignment = Alignment.CenterVertically) {


                createTopBar()
            }}
        }
    }
}