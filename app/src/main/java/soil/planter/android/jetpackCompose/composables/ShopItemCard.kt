package soil.planter.android.jetpackCompose.composables


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import soil.planter.android.R
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter

@Preview
@Composable
fun ShopItemCard(modifier: Modifier = Modifier) {
    
    Column(modifier = Modifier
        .wrapContentHeight()
        .padding(20.dp), // Adjust the height range as needed

        verticalArrangement = Arrangement.Center) {

        AsyncImage(
            model = "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            contentDescription = "Translated description of what the image contains",
            modifier = Modifier
                .shadow(
                    elevation = 5.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                )
                .scale(1.0f, 1.0f)
                .align(CenterHorizontally)
                .fillMaxWidth()
                .heightIn(min = 214.dp, max= 250.dp),
            contentScale = ContentScale.Crop

        )
        Row(Modifier.padding(top=8.dp)) {
            Text(text = "Peanut, Cactus")
            Row (Modifier.padding(start= 8.dp)){
                Image(painterResource(id = R.drawable.baseline_local_fire_department_24), contentDescription = "Fire")
                Spacer(modifier = Modifier.width(0.dp))
                Image(painterResource(id = R.drawable.baseline_local_fire_department_24), contentDescription = "Fire")
            }
        }
        Text(text = "Great for light and calm rooms with aesthetically pleasing Furniture")
        Row(Modifier.padding(top= 8.dp)) {
            Text(
                text = "12€",
                style = TextStyle(
                    fontSize = 20.sp,
                    textDecoration = TextDecoration.LineThrough,
                    fontFamily = FontFamily(Font(R.font.k2d_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "8€",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.k2d_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }
    }

    

}