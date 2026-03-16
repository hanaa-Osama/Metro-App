package domain.usecases

import com.example.metroapp.domain.repo.MetroRepository
import domain.model.*

class FindRouteUseCase(
    private val repo: MetroRepository,
    private val calculateFareUseCase: CalculateFareUseCase,
    private val calculateTimeUseCase: CalculateTimeUseCase,
    private val bfsUseCase: BFSUseCase
) {

    operator fun invoke(
        startName: String,
        endName: String
    ): RouteResult {

        val stations = repo.getStations()

        val start = stations.find { it.name.equals(startName.trim(), ignoreCase = true) }
            ?: return RouteResult.Error("Start station not found")

        val end = stations.find { it.name.equals(endName.trim(), ignoreCase = true) }
            ?: return RouteResult.Error("End station not found")

        val path = bfsUseCase.execute(start, end, stations)
            ?: return RouteResult.Error("No route found")

        val fare = calculateFareUseCase.execute(path.size)
        val timeMinutes = calculateTimeUseCase.execute(path.size - 1)
        val timeText = "${timeMinutes} mins"

        val lineChanges = countLineChanges(path)

        return RouteResult.Success(
            stations = path,
            fromStation = start.name,
            toStation = end.name,
            fare = fare,
            time = timeText,
            lineChanges = lineChanges
        )
    }

    private fun countLineChanges(path: List<Station>): Int {
        var changes = 0
        for (i in 1 until path.size) {
            if (path[i].line != path[i-1].line) {
                changes++
            }
        }
        return changes
    }
}