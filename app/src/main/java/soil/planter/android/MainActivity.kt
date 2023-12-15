package soil.planter.android

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import soil.planter.android.frontend.BottomNavigationItemData
import soil.planter.android.frontend.Composables.TopBar
import soil.planter.android.frontend.Navigation
import soil.planter.android.frontend.Pages.Encyclopedia.DictionaryScreen

//TODO
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            soil.planter.android.frontend.ui.theme.SoilTheme {

                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize().background(color= Color.White),

                ) {
                    val navController = rememberNavController()

                    DisplayPages(
                        navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        }
                    )
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // no custom padding when using scaffold
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayPages(
    navController: NavHostController,
    onItemClick: (BottomNavigationItemData) -> Unit
) {
    val items = listOf(
        BottomNavigationItemData(
            title = "Home",
            route = "home_page",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItemData(
            title = "Dictionary",
            route = "encyclopedia_page",
            selectedIcon = Icons.Filled.Menu,
            unselectedIcon = Icons.Outlined.Menu,
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItemData(
            title = "Shop",
            route = "shop_page",
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
                Modifier
                    .offset(y = 1.dp)
                    .background(Color.White)
                    .shadow(
                        elevation = 10.dp,
                        spotColor = Color(0x40000000),
                        ambientColor = Color(0x40000000)
                    )
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                        )
                    )
                    .border(
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                        width = 1.dp,
                        color = Color.LightGray
                    )) {
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
    ) { innerpadding->
        var type by remember { mutableStateOf(1) }

        // Listen for changes in the back stack
        DisposableEffect(navController) {
            val listener = NavController.OnDestinationChangedListener { _, _, _ ->
                // Update the type based on the current destination or any other logic
                type = if (navController.currentDestination?.route == "home_page") {
                    0
                } else {
                    1
                }
            }

            // Add the listener
            navController.addOnDestinationChangedListener(listener)

            // Remove the listener when the effect leaves the composition
            //TODO understand this
            onDispose {
                navController.removeOnDestinationChangedListener(listener)
            }
        }

        Column(modifier = Modifier.padding(bottom = 60.dp)) {
            TopBar(type=type)
            Navigation(navController = navController)

        }


    }
}