package data.datasource

import data.model.StationDTO

interface MetroDataSource {

    fun loadStations(): List<StationDTO>

    fun getTravelTime(): Int
}