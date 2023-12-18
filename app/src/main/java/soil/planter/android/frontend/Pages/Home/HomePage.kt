package soil.planter.android.frontend.Pages.Home

import android.graphics.drawable.Icon
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import soil.planter.android.R
import soil.planter.android.frontend.Composables.DescriptiveImageCard
import soil.planter.android.frontend.Composables.ImageCard

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        PlantCarousel()
        PlantInformation(info1 = "Moderate", info2 = "Moderate", info3 = 86, info4 = 21.7f)
        Extras()
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
            fontSize = 40.sp,
            fontFamily = FontFamily(Font(R.font.k2d_medium)),
            fontWeight = FontWeight(400),
            color = Color.Black,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier.padding(vertical = 16.dp)
    )
    Card(
        modifier = Modifier
            .size(width = 200.dp, height = 80.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, Color.Black)
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
                PlantText(text = info2, Icons.Rounded.Home)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                PlantText(text = "$info3%", Icons.Rounded.Home)
                PlantText(text = "$info4 C°", Icons.Rounded.Home)
            }
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
            contentDescription = null
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
fun Extras(

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
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

            ) {
                item {
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        title = "Shiitake"
                    )
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        title = "Shiitake"
                    )
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        title = "Shiitake"
                    )
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        title = "Shiitake"
                    )
                }
            }
        }
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

            ) {
                item {
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        title = "Shiitake"
                    )
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        title = "Shiitake"
                    )
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        title = "Shiitake"
                    )
                    ImageCard(
                        painter = painterResource(R.drawable.shiitake),
                        contentDescription = "Shiitake",
                        title = "Shiitake"
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PlantCarousel(

) {
    val images = remember {
        mutableStateListOf(
            "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?q=80&w=2449&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        )
    }

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        // provide pageCount
        images.size
    }

    Box(

    ) {
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fixed(250.dp),
            //contentPadding = PaddingValues(horizontal = 4.dp)
        ) { index ->
            // checks if page is in the middle of the screen, offset = 0 -> middle, else -> not
            val pageOffset =
                (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
            val imageSize by animateFloatAsState(
                targetValue = if (pageOffset != 0.0f) 0.75f else 1f, label = "",
                animationSpec = tween(durationMillis = 300)
            )
            AsyncImage(
                modifier = Modifier
                    .padding(16.dp)
                    .height(200.dp)
                    .width(250.dp)
                    .graphicsLayer {
                        scaleX = imageSize
                        scaleY = imageSize
                    }
                    .clip(RoundedCornerShape(16.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(images[index])
                    .build(),
                contentDescription = "Translated description of what the image contains",
                contentScale = ContentScale.Crop,
                //alignment = Alignment.Center,
            )
        }

    }


}