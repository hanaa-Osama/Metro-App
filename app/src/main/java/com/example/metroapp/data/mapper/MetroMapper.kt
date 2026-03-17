package data.mapper

import com.example.metroapp.domain.model.MetroLine
import data.model.StationDTO
import domain.model.Station

object MetroMapper {

    fun toDomain(dto: StationDTO): Station {
        return Station(
            id = dto.id,
            name = dto.name,
            line = dto.line.toMetroLine(),
            order = dto.order,
            isTransfer = dto.is_transfer,
            transferLines = dto.transfer_lines
                ?.map { it.toMetroLine() }
                ?: emptyList(),
            platform = dto.platform
        )
    }

    private fun String.toMetroLine(): MetroLine =
        when (this.trim().uppercase()) {
            "LINE_1", "FIRST LINE", "1" -> MetroLine.LINE_1
            "LINE_2", "SECOND LINE", "2" -> MetroLine.LINE_2
            "LINE_3", "THIRD LINE", "3" -> MetroLine.LINE_3
            "YELLOW", "YELLOW LINE" -> MetroLine.YELLOW
            else -> throw IllegalArgumentException("Unknown line: $this")
        }
}