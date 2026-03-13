package domain.model

import com.example.metroapp.domain.model.MetroLine

data class Station(
    val id: Int,
    val name: String,
    val line: MetroLine,
    val order: Int,
    val isTransfer: Boolean = false,
    val transferLines: List<MetroLine> = emptyList(),
    val platform: String? = null
)