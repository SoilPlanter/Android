package soil.planter.android.jetpackCompose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import soil.planter.android.R

@Preview
@Composable
fun RoundRectangleButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 5.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .width(50.dp)
            .height(50.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 15.dp))
    ){
        Image(modifier = Modifier.align(Alignment.Center),painter = painterResource(id = R.drawable.baseline_filter_list_24),contentDescription = "Filter")
    }
}