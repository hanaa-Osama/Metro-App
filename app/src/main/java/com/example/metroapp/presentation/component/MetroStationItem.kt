package com.example.metroapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.metroapp.domain.model.MetroLine
import com.example.metroapp.ui.theme.Line1Red
import com.example.metroapp.ui.theme.Line2Green
import com.example.metroapp.ui.theme.MetroAppTheme
import domain.model.Station

@Composable
fun MetroStationItem(
    station: Station,
    lineColor: Color,
    isFirst: Boolean = false,
    isLast: Boolean = false
) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .padding(horizontal = 16.dp)
    ) {
        // Timeline Column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(24.dp)
        ) {
            // Top line
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .weight(1f)
                    .background(if (isFirst) Color.Transparent else lineColor)
            )

            // Station Dot
            Box(
                modifier = Modifier
                    .size(if (station.isTransfer) 16.dp else 12.dp)
                    .clip(CircleShape)
                    .background(if (station.isTransfer) Color.White else lineColor)
                    .then(
                        if (station.isTransfer) {
                            Modifier.background(lineColor, CircleShape).padding(3.dp).background(Color.White, CircleShape)
                        } else Modifier
                    )
            )

            // Bottom line
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .weight(1f)
                    .background(if (isLast) Color.Transparent else lineColor)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Station Info
        Column(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .weight(1f)
        ) {
            Text(
                text = station.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = if (station.isTransfer) FontWeight.Bold else FontWeight.Medium,
                color = if (station.isTransfer) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )

            if (station.isTransfer) {
                val transferText = "Transfer to ${station.transferLines.joinToString { it.name.replace("_", " ") }}"
                Text(
                    text = transferText,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MetroStationItemPreview() {
    MetroAppTheme {
        Surface {
            Column {
                MetroStationItem(
                    station = Station(1, "Helwan", MetroLine.LINE_1, 1),
                    lineColor = Line1Red,
                    isFirst = true
                )
                MetroStationItem(
                    station = Station(2, "Sadat", MetroLine.LINE_1, 2, isTransfer = true, transferLines = listOf(MetroLine.LINE_2)),
                    lineColor = Line1Red
                )
                MetroStationItem(
                    station = Station(3, "Sayeda Zeinab", MetroLine.LINE_1, 3),
                    lineColor = Line1Red,
                    isLast = true
                )
            }
        }
    }
}