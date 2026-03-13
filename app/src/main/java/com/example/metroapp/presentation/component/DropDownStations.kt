package com.example.metroapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.metroapp.ui.theme.Grey40
import com.example.metroapp.ui.theme.metroColorPri
import domain.model.Station

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownStations(
    value: String,
    stations: List<Station>,
    label: String,
    onStationSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf(value) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Grey40)
    ) {
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            placeholder = { Text("Select a station") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                focusedBorderColor = metroColorPri,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = metroColorPri,
                unfocusedLabelColor = Color.Gray,
            ),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .padding(horizontal =18.dp)
                .fillMaxWidth()
                .heightIn(max = 300.dp)
                .background(Grey40),
            shape = RoundedCornerShape(bottomEnd = 35.dp, bottomStart = 35.dp)
        ) {
            stations.forEach { station ->
                DropdownMenuItem(
                    text = { Text(station.name, fontSize = 16.sp) },
                    onClick = {
                        textFieldValue = station.name
                        onStationSelected(station.name)
                        expanded = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )
                Divider(color = Color.LightGray, thickness = 0.5.dp)
            }
        }
    }
}