package soil.planter.android.jetpackCompose.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun AddButton(onClick: () -> Unit, text: String?) {
    Button(onClick = { onClick() }) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = "Add plant",
            modifier = Modifier.size(18.dp)
        )
        if(text != null) {
            Text(text = text)
        }
        //Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        //Spacer(modifier = Modifier.width(8.dp))
    }
}