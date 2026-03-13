package domain.usecases

import com.example.metroapp.domain.model.MetroLine
import com.example.metroapp.domain.repo.MetroRepository

class GetLastStationUseCase(val repo: MetroRepository) {

    fun execute(line: MetroLine): String {
        return repo.getStations()
            .filter { it.line == line }
            .maxBy { it.order }
            .name
    }
}