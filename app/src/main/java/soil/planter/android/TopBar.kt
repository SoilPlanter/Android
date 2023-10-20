package soil.planter.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun createTopBar(){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End) {
        Image(painterResource(id = R.drawable.baseline_question_mark_24), contentDescription = "ic_account" )
        Image(painterResource(id = R.drawable.baseline_account_circle_24), contentDescription = "ic_account" )
        Image(painterResource(id = R.drawable.baseline_settings_24), contentDescription = "ic_account" )

    }
}