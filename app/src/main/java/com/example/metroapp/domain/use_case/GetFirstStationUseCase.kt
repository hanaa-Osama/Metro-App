package domain.usecases

import com.example.metroapp.domain.model.MetroLine
import com.example.metroapp.domain.repo.MetroRepository

class GetFirstStationUseCase(val repo: MetroRepository) {

    fun execute(line: MetroLine): String {
        return repo.getStations()
            .filter { it.line == line }
            .minBy { it.order }
            .name
    }
}