package soil.planter.android.frontend.Pages.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import soil.planter.android.R
import soil.planter.android.frontend.Composables.ImageCard
import soil.planter.android.frontend.Composables.CarouselCard

val sliderList = listOf(
    "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
)
@Composable
fun HomePage() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        CarouselCard(sliderList)
        PlantInformation(info1 = "Moderate", info2 = "Moderate", info3 = 86, info4 = 21.7f)
        PlantInformationDisplay()
    }
}

@Composable
fun PlantInformation(
    info1: String,
    info2: String,
    info3: Int,
    info4: Float
) {
    Text(
        text = "Nate",
        style = TextStyle(
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.k2d_medium)),
            fontWeight = FontWeight(400),
            color = Color.Black,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier.padding(bottom = 16.dp)
    )
    PlantInformationDisplay(info1,
        info2,
        info3,
        info4)

}
@Composable
fun PlantInformationDisplay(info1: String,
                            info2: String,
                            info3: Int,
                            info4: Float){
    Row {
        Spacer(modifier = Modifier.weight(0.5f))
        Card(
            modifier = Modifier
                .size(width = 200.dp, height = 80.dp)
                .weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ) {
                        PlantText(text = info1, Icons.Rounded.Home)
                        PlantText(text = info2, Icons.Rounded.Check)
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ) {
                        PlantText(text = "$info3%", Icons.Rounded.Build)
                        PlantText(text = "$info4" + "C°", Icons.Rounded.Face)
                    }
                }
            }
        }
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 28.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(50.dp))
        ) {
            Icon(
                Icons.Rounded.PlayArrow,
                contentDescription = null
            )
        }
    }
}

@Composable
fun PlantText(
    text: String,
    image: ImageVector
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            image,
            contentDescription = null,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
                .padding(end = 4.dp)
        )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.k2d_medium)),
                fontWeight = FontWeight(400),
                color = Color.Black,
            ),
        )
    }
}

@Composable
fun PlantInformationDisplay(

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ,
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
        ) {
            Text(
                text = "Plant History",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.k2d_medium)),
                    fontWeight = FontWeight(400),
                    color = Color.Black
                )
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                items(4) {
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        modifier = Modifier.size(72.dp)

                    )

                }
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Photos",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.k2d_medium)),
                    fontWeight = FontWeight(400),
                    color = Color.Black
                )
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start)


            ) {
                items(4) {
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        modifier = Modifier.size(72.dp)

                    )

                }
            }
        }
    }
}
