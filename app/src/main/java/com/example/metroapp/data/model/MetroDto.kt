package data.model

data class MetroDTO(

    val stations: List<StationDTO>,

    val travel_time_between_stations_minutes: Int
)