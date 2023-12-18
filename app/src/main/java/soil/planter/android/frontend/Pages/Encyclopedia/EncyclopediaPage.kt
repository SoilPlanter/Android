package soil.planter.android.frontend.Pages.Encyclopedia

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import soil.planter.android.MainViewModel
import soil.planter.android.R
import soil.planter.android.frontend.Composables.EncyclopediaCardItem
import soil.planter.android.frontend.Composables.ImageCard

import soil.planter.android.frontend.Pages.Home.PlantsRow

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun EncyclopediaPage() {

    LazyColumn {
        item {
            PlantsRowInfo(title = "Araceae", painter = painterResource(id = R.drawable.chrysalidocarpus
            ),
                name = "Juniperus", description = "Home Plant")
        }
        item {
            PlantsRowInfo(title = "Cacti", painter = painterResource(id = R.drawable.chrysalidocarpus
            ),
                name = "Juniperus", description = "Home Plant")
        }
        item {
            PlantsRowInfo(title = "Labia", painter = painterResource(id = R.drawable.chrysalidocarpus
            ),
                name = "Juniperus", description = "Home Plant")
        }

    }
}


@Composable
fun PlantsRowInfo(
    title: String,
    painter: Painter,
    name: String,
    description: String
) {
    Text(
        text = title,
        Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.k2d_medium)),
            fontWeight = FontWeight(400),
            color = Color(0xFF000000)
        )
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ){
        items(5) {
            Column{
                ImageCard(painter = painter, contentDescription = description, title = "", modifier = Modifier.size(125.dp))
                Text(name, fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.k2d_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
                //TODO Spacing must be 4.dp vertically between these two texts
                Text(description,
                    style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.k2d_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF858585)
                    )
                )
            }
        }

    }
}