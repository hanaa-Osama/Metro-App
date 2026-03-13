package domain.usecases
import domain.model.Station

class GetDirectionUseCase(
    private val getFirstStationUseCase: GetFirstStationUseCase,
    private val getLastStationUseCase: GetLastStationUseCase
) {
    fun execute(
        current: Station,
        next: Station,
    ): String {
        val first = getFirstStationUseCase.execute(current.line)

        val last = getLastStationUseCase.execute(current.line)

        return if (next.order > current.order)
            last
        else
            first
    }
}