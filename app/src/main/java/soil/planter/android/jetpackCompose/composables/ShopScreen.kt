package soil.planter.android.jetpackCompose.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ShopScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
    ) {
        TopBar(modifier = Modifier.align(Alignment.CenterHorizontally))
        ShopItemDisplay(modifier = Modifier.padding())

    }
}