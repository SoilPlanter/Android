package soil.planter.android.frontend.Pages.Shop

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import soil.planter.android.frontend.Composables.ShopItemCard
import soil.planter.android.frontend.Composables.ShopItemData
import soil.planter.android.frontend.Composables.TopBar


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ShopScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
    ) {
        ShopItemDisplay(modifier = Modifier.padding())

    }
}
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