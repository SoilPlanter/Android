package soil.planter.android.frontend.Composables.Bar

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soil.planter.android.R
import soil.planter.android.Views.TopBar
import soil.planter.android.frontend.Composables.DescriptiveImageCard
import soil.planter.android.frontend.Composables.RoundRectangleButton
import soil.planter.android.frontend.Composables.TagViewData


//shopTags : List<Tags>
@Composable
fun generateTagDataList(modifier: Modifier){
    val shoptags = List(5) { index ->
        TagViewData(painterResource(id = R.drawable.baseline_forest_24), "Planter")
    }
    LazyRow(
        modifier
            .fillMaxWidth(1f)
            .height(100.dp)
            .padding(top = 20.dp)
    ) {
        items(shoptags) { item ->
            DescriptiveImageCard(modifier, item)
        }
    }
}
fun Boolean.toInt() = if (this) 1 else 0

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun TopBar(modifier : Modifier = Modifier,pageData: PageData) {
    var modifier1 : Modifier = modifier.shadow(
    elevation = 5.dp,
    spotColor = Color(0x40000000),
    ambientColor = Color(0x40000000)
    )
    .background(color = Color(android.graphics.Color.parseColor("#FFFFFF")))
        .fillMaxWidth()

    if (type == TopBarTypes.OTHER){
        modifier1 = modifier1.wrapContentHeight()
    }
    else if (type == TopBarTypes.HOME){
        modifier1 = modifier1.height(160.dp)
    }

    Column(
            modifier = modifier1
    ) {
        Row(
            modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            Text(
                text = "Shop",
                modifier = modifier.padding(start = 20.dp, top = 20.dp),
                style = TextStyle(
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.k2d_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
            Spacer(modifier = modifier.weight(1f))

            Row(
                modifier = modifier
                    .wrapContentHeight()
                    .padding(end = 20.dp)
                    .wrapContentWidth()
                    .align(Alignment.CenterVertically),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    modifier = modifier
                        .height(30.dp)
                        .width(30.dp)
                        .align(Alignment.CenterVertically)
                        .fillMaxHeight(),
                    painter = painterResource(R.drawable.baseline_notifications_none_24),
                    contentDescription = "Notifications",
                )
                Spacer(modifier = Modifier.width(8.dp))

                Image(
                    modifier = modifier
                        .height(30.dp)
                        .width(30.dp)
                        .align(Alignment.CenterVertically)
                        .fillMaxHeight(),
                    painter = painterResource(R.drawable.baseline_settings_24),
                    contentDescription = "Settings",
                )
            }

        }
        if (type == TopBarTypes.OTHER) {

            Row(
                modifier
                    .wrapContentHeight()
                    .fillMaxWidth(1f)
                    .padding(top = 20.dp)
                    .graphicsLayer { clip = false }


            ) {
                SearchBar(
                    modifier
                        .padding(start = 20.dp)
                        .weight(1f)
                        .wrapContentWidth()
                )

                Spacer(modifier = Modifier.width(20.dp))
                RoundRectangleButton(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }

        generateTagDataList(Modifier)




    }


}


@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .shadow(
                elevation = 5.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .fillMaxWidth()
            .height(56.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 15.dp))
            .padding(start = 20.dp)
    ) {
        Image(
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(R.drawable.baseline_search_24),
            contentDescription = "Search",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Planter · Plant · Soil",
            modifier = Modifier
                .align(Alignment.CenterVertically),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.k2d_medium)),
                fontWeight = FontWeight(400),
                color = Color(0xFF040404),
            )
        )
    }
}