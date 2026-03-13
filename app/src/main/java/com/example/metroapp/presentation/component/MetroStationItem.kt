package com.example.metroapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.metroapp.ui.theme.Grey40
import domain.model.Station

@Composable
fun MetroStationItem(
    station: Station,
    lineColor: Color,
    isLast: Boolean
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        // Timeline (Circle + Line)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(30.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(18.dp)
                    .background(lineColor, CircleShape)
                    .border(3.dp, Color.White, CircleShape)
            )

            if (!isLast) {
                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .width(3.dp)
                        .height(60.dp)
                        .background(lineColor)
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Station Card
        Card(
            modifier = Modifier

                .fillMaxWidth()
//                .background(Grey40)
                .border(
                    width = 1.dp,
                    color = Color(0xFFE0E0E0),
                    shape = RoundedCornerShape(12.dp)
                ),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Grey40)
            ) {
                Column(
                    modifier = Modifier
                        .background(Grey40)
                        .padding(16.dp)
                ) {

                    // Station Name
                    Text(
                        text = station.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Line Name
                    Text(
                        text = station.line.name,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    if (station.isTransfer) {

                        Spacer(modifier = Modifier.height(6.dp))

                        val transferText = buildString {
                            append("Transfer: ")
                            append(station.transferLines.joinToString { it.name })
                            station.platform?.let { append(" (Platform $it)") }
                        }

                        Text(
                            text = transferText,
                            fontSize = 13.sp,
                            color = Color(0xFF1976D2),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}