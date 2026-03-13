package domain.usecases

import com.example.metroapp.domain.repo.MetroRepository

class CalculateTimeUseCase(
    private val repo: MetroRepository,
) {

    fun execute(count: Int) =
        count * repo.getTravelTime()
}