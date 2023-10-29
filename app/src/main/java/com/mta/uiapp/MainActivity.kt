package com.mta.uiapp

import android.os.Build.VERSION_CODES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mta.uiapp.R.drawable
import com.mta.uiapp.ui.DoctorDetailScreen
import com.mta.uiapp.ui.HomeScreen
import com.mta.uiapp.ui.theme.UIAppTheme

data class NavigationItem(
  val title: String,
  val icon: Painter,
)

class MainActivity : ComponentActivity() {
  @RequiresApi(VERSION_CODES.M)
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      UIAppTheme {

        UIApp()

        // val navItems = listOf(
        //   NavigationItem(
        //     title = "Home",
        //     icon = painterResource(id = drawable.ic_home)
        //   ),
        //   NavigationItem(
        //     title = "Doctors",
        //     icon = painterResource(id = drawable.ic_doctors)
        //   ),
        //   NavigationItem(
        //     title = "Appointment",
        //     icon = painterResource(id = drawable.ic_appointment)
        //   ),
        //   NavigationItem(
        //     title = "Profile",
        //     icon = painterResource(id = drawable.ic_profile)
        //   )
        // )
        //
        // var selectedNavItemIndex by rememberSaveable {
        //   mutableStateOf(0)
        // }
        // Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        //   Scaffold(
        //     bottomBar = {
        //       NavigationBar(
        //         modifier = Modifier
        //           .clip(shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)),
        //       ) {
        //
        //         navItems.forEachIndexed { index, navItem ->
        //           NavigationBarItem(
        //             selected = selectedNavItemIndex == index,
        //             onClick = { selectedNavItemIndex = index },
        //             icon = {
        //               Icon(
        //                 painter = navItem.icon, contentDescription = navItem.title,
        //               )
        //             },
        //             label = {
        //               Text(
        //                 text = navItem.title,
        //               )
        //             },
        //             colors = NavigationBarItemDefaults.colors(
        //               selectedIconColor = MaterialTheme.colorScheme.primary,
        //               selectedTextColor = MaterialTheme.colorScheme.primary,
        //               unselectedIconColor = MaterialTheme.colorScheme.secondary,
        //               unselectedTextColor = MaterialTheme.colorScheme.secondary,
        //             )
        //           )
        //         }
        //       }
        //     }
        //   ) { contentPadding ->
        //     Column(
        //       modifier = Modifier
        //         .padding(contentPadding)
        //         .verticalScroll(rememberScrollState())
        //     ) {
        //
        //       HomeScreen()
        //       DoctorDetailScreen()
        //
        //     }
        //   }
        // }
      }
    }
  }
}


