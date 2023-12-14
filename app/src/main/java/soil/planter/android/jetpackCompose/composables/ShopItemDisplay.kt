package soil.planter.android.jetpackCompose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import soil.planter.android.R

@Preview
@Composable
fun ShopItemDisplay(modifier : Modifier = Modifier){

    val shoptags = List(5) { index ->
        ShopItemData(2,"Good for calm rooms", "Cactus, Rose", 2,null)
    }
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight().background(Color.White),
        verticalArrangement = Arrangement.Center


    ) {
        items(shoptags) { item ->
            ShopItemCard()
        }
    }//
}