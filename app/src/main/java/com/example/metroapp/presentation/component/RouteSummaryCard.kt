package com.example.metroapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.metroapp.ui.theme.Grey40
import java.nio.file.WatchEvent

@Composable
fun RouteSummaryCard(
    fromStation: String,
    toStation: String,
    fare: Int,
    totalTime: String,
    totalStations: Int,
    lineChanges: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
//            .background(Grey40)
            .border(
                1.dp,
                Color(0xFFE5E5E5),
                RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Column(
            modifier = Modifier
                .background(Grey40)
                .padding(20.dp)

        ) {

            // Top Row
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "$fromStation → $toStation",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF333333)
                )


                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = " $fare EGP",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2E7D32)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Divider()

            Spacer(modifier = Modifier.height(12.dp))

            // Stations
            Text(

                text = totalTime,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF8E0B0B)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Stats Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                StatItem(
                    label = "Stations",
                    value = totalStations.toString()
                )

                StatItem(
                    label = "Time",
                    value = totalTime
                )

                StatItem(
                    label = "Changes",
                    value = lineChanges.toString()
                )
            }
        }
    }
}

@Composable
fun StatItem(
    label: String,
    value: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(
                Color(0xFFF7F7F7),
                RoundedCornerShape(12.dp)
            )
            .padding(
                horizontal = 14.dp,
                vertical = 10.dp
            )
    ) {

        Text(
            text = label,
            fontSize = 13.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )


    }
}