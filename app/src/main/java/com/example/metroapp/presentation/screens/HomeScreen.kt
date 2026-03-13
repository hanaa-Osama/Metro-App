package com.example.metroapp.presentation.screens

import android.graphics.drawable.Drawable
import android.text.Html
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.metroapp.R
import com.example.metroapp.presentation.component.CardStation
import com.example.metroapp.presentation.viewmodel.MetroViewModel
import com.example.metroapp.ui.theme.Purple40
import com.example.metroapp.ui.theme.metroColorPri


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MetroHomeScreen(
    navController: NavController,
    metroViewModel: MetroViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Cairo Metro",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 28.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = metroColorPri
                ),
                expandedHeight = 80.dp
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 5.dp,)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "    Find the fastest route",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = metroColorPri,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(44.dp))

            Image(
                painter = painterResource(R.drawable.my_metro),
                contentDescription = "Metro",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            CardStation(
                viewModel = metroViewModel,
                navController = navController,
                modifier = Modifier.fillMaxWidth(0.9f)
            )
        }
    }
}