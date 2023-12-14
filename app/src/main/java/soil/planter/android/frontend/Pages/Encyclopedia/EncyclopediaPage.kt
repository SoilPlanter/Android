package soil.planter.android.frontend.Pages.Encyclopedia

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.searchfieldcompose.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryScreen() {
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val plants by viewModel.plants.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    Column{
        Text(
            text = "Dictionary",
            fontSize = 50.sp,
            fontFamily = FontFamily.SansSerif,
            maxLines = 2,
            modifier = Modifier
                .padding(16.dp),
            overflow = TextOverflow.Visible
        )
    }
    Column{
        TextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 100.dp, horizontal = 20.dp),
            placeholder = { Text(text = "Search...") }
        )

    }
}