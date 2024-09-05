package com.example.compose_ipp.bottom_navigation_project.pages

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem (
    val label : String,
    val icon : ImageVector,
    val badgeCount : Int
)