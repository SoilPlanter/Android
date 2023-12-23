package soil.planter.android.frontend.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soil.planter.android.R
@Preview
@Composable
fun TagView (painter: Painter = painterResource(id = R.drawable.baseline_local_fire_department_24), color1: Color = Color.Blue, text2 : String = "Alert"){
    Row (Modifier.padding(0.dp).wrapContentWidth().defaultMinSize(minWidth = 50.dp).background(color = color1, shape= RoundedCornerShape(16.dp)), horizontalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier.padding(start =4.dp,top =4.dp,bottom =4.dp),
            painter = painter ,
            contentDescription = "TagImg",
            colorFilter = ColorFilter.tint(Color.White)
        )

        Text(modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, end = 4.dp),text =  text2 ,  style = TextStyle(
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.k2d_medium)),
            fontWeight = FontWeight(400),
            color = Color.White,
            textAlign = TextAlign.Center
        ))
    }
}