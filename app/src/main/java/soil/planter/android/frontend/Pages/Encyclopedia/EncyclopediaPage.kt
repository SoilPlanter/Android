package soil.planter.android.frontend.Pages.Encyclopedia

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.searchfieldcompose.MainViewModel
import soil.planter.android.R
import soil.planter.android.frontend.Composables.EncyclopediaCardItem
import soil.planter.android.frontend.Composables.ImageCard
import soil.planter.android.frontend.Composables.SearchBar
import soil.planter.android.frontend.Composables.TopBar
import soil.planter.android.frontend.Pages.Home.PlantsRow

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryScreen() {
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val plants by viewModel.plants.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    Column {
        PlantsRow_e(title = "Araceae", painter = painterResource(id = R.drawable.plant_template), name = "Juniperus", description = "Home Plant")
    }
}


@Composable
fun PlantsRow_e(
    title: String,
    painter: Painter,
    name: String,
    description: String
) {
    Text(
        text = title,
        Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        fontSize = 24.sp,
        fontFamily = FontFamily.SansSerif,
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ){
        items (5){
            ImageCard(painter = painter, contentDescription = description, title = "")
            Text(name, style = TextStyle(color = Color.Black, fontSize = 16.sp))
            Text(description, style = TextStyle(color = Color.Black, fontSize = 16.sp))
        }

    }
}