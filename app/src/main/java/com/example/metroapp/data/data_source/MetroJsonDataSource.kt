package data.datasource

import android.content.Context
import com.google.gson.Gson
import data.model.MetroDTO

class MetroJsonDataSource(
    private val context: Context
) : MetroDataSource {

    private val gson = Gson()

    private val dto by lazy {

        val json = context.assets
            .open("cairo_metro_structured.json")
            .bufferedReader()
            .use { it.readText() }

        gson.fromJson(
            json,
            MetroDTO::class.java
        )
    }

    override fun loadStations() =
        dto.stations

    override fun getTravelTime() =
        dto.travel_time_between_stations_minutes
}