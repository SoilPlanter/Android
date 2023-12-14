package soil.planter.android.frontend.Composables

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import soil.planter.android.R
import soil.planter.android.frontend.Navigation
import soil.planter.android.frontend.BottomNavigationItemData


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
@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun TopBar(modifier : Modifier = Modifier) {
    Column(
        modifier
            .wrapContentHeight()
            .shadow(
                elevation = 5.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .background(color = Color(android.graphics.Color.parseColor("#FFFFFF")))
            .fillMaxWidth()
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
                    .padding(end = 20.dp).wrapContentWidth().align(Alignment.CenterVertically),
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
            RoundRectangleButton(modifier = Modifier.padding(end = 20.dp).align(Alignment.CenterVertically))
        }

        generateTagDataList(Modifier)




    }


}

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // no custom padding when using scaffold
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav(
    navController: NavHostController,
    onItemClick: (BottomNavigationItemData) -> Unit
) {
    val items = listOf(
        BottomNavigationItemData(
            title = "Home",
            route = "home_screen",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItemData(
            title = "Dictionary",
            route = "dictionary_screen",
            selectedIcon = Icons.Filled.Menu,
            unselectedIcon = Icons.Outlined.Menu,
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItemData(
            title = "Shop",
            route = "shop_screen",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
            hasNews = false,
            badgeCount = null
        ),
    )
    val backStackEntry = navController.currentBackStackEntryAsState()
    var selected = true
    var contentColorSelected = Color.Black
    var contentColorUnselected = Color.White

    Scaffold(

        bottomBar = {

            NavigationBar(
                tonalElevation=5.dp,
                contentColor = if(selected)contentColorSelected else contentColorUnselected,
                containerColor = Color.White,
                modifier =
            Modifier.offset(y=1.dp).background(Color.White).shadow(
                elevation = 10.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            ).
            clip(
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                )
            ).border(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp), width= 1.dp, color = Color.LightGray)) {
                items.forEach{ item ->
                    val selected1 = item.route == backStackEntry.value?.destination?.route
                    selected = selected1

                    NavigationBarItem(
                        selected = selected1,
                        onClick = { onItemClick(item) },
                        label = {
                            //Text(text = item.title) // no title for cleaner look
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if(item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if(item.hasNews) {
                                        Badge()
                                    }
                                },
                            ) {
                                Icon(
                                    imageVector = if (selected) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title,
                                    modifier = Modifier.size(35.dp),
                                    tint = Color.Black
                                )
                            }

                        }
                    )
                }
            }
        }
    ) {
        Navigation(navController = navController)
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
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 15.dp)).padding(start = 20.dp)
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