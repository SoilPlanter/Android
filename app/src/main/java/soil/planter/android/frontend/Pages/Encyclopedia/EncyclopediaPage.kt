package soil.planter.android.frontend.Pages.Encyclopedia

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soil.planter.android.R
import soil.planter.android.frontend.Composables.EncyclopediaCardItem

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun EncyclopediaPage() {

    LazyColumn {
        item {
            PlantsRowInfo(title = "Araceae", painter = painterResource(id = R.drawable.chrysalidocarpus),
                name = "Juniperus", description = "Home Plant")
        }
        item {
            PlantsRowInfo(title = "Cacti", painter = painterResource(id = R.drawable.chrysalidocarpus),
                name = "Juniperus", description = "Home Plant")
        }
        item {
            PlantsRowInfo(title = "Labia", painter = painterResource(id = R.drawable.chrysalidocarpus),
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
                EncyclopediaCardItem(painter = painter, name = name, description = description)
            }
        }

    }
}