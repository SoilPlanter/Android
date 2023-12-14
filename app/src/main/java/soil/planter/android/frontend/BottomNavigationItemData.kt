package soil.planter.android.frontend

import androidx.compose.ui.graphics.vector.ImageVector
data class BottomNavigationItemData(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
