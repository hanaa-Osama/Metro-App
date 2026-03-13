package data.repo

import data.datasource.MetroDataSource
import data.mapper.MetroMapper
import com.example.metroapp.domain.repo.MetroRepository

class MetroRepositoryImpl(
    private val dataSource: MetroDataSource
) : MetroRepository {

    override fun getStations() =
        dataSource.loadStations()
            .map { MetroMapper.toDomain(it) }

    override fun getTravelTime() = dataSource.getTravelTime()

}