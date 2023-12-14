package soil.planter.android.jetpackCompose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soil.planter.android.R

@Composable
fun DescriptiveImageCard(modifier: Modifier = Modifier, item: TagViewData) {
    Column(modifier = modifier
        .height(100.dp)
        .width(100.dp),verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = item.image,
            modifier = modifier.align(Alignment.CenterHorizontally),
            contentDescription = "image description",
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = item.description,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.k2d_medium)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),

                textAlign = TextAlign.Center,
            )
        )

    }
}