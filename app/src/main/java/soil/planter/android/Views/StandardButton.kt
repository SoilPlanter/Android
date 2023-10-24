package soil.planter.android.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import soil.planter.android.R

class StandardButton {
    @Preview()
    @Composable
    public fun draw() {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Green)
                .size(25.dp)
                .border(1.dp, Color.Green, shape = RoundedCornerShape(5.dp))) {
            Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Soil")

        }

    }

}