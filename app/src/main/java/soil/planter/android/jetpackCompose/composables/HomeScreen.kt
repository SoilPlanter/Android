package soil.planter.android.jetpackCompose.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soil.planter.android.R

@Composable
fun HomeScreen() {
    Column {
        Column{
            //TODO: make this one text instead of two text composable
            Text(
                text = "Welcome Back",
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                fontSize = 50.sp,
                fontFamily = FontFamily.SansSerif,
                maxLines = 2,
                overflow = TextOverflow.Visible,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = "Caleb",
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                fontSize = 50.sp,
                fontFamily = FontFamily.SansSerif,
                maxLines = 2,
                overflow = TextOverflow.Visible,
                textDecoration = TextDecoration.Underline
            )
        }

        val cutePlant = painterResource(id = R.drawable.plant_template)
        val shiitake = painterResource(id = R.drawable.shiitake)
        LazyColumn{
            item {
                PlantsRow(text = "Your planters", painter = cutePlant, description = "")
                PlantsRow(text = "Your active plants", painter = shiitake, description = "")
            }
        }
    }
}