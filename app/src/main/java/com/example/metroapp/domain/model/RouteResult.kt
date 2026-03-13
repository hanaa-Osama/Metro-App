package domain.model

sealed class RouteResult {
    data class Success(
        val stations: List<Station>,
        val fromStation: String,
        val toStation: String,
        val fare: Int,
        val time: String,
        val lineChanges: Int
    ) : RouteResult()

    data class Error(val message: String) : RouteResult()
}
