package di

import android.content.Context
import com.example.metroapp.domain.use_case.GetAllStationsUseCase
import data.datasource.MetroJsonDataSource
import data.repo.MetroRepositoryImpl
import domain.usecases.*

object AppModule {

    fun provideFindRoute(context: Context): FindRouteUseCase {

        val dataSource =
            MetroJsonDataSource(context)

        val repository =
            MetroRepositoryImpl(dataSource)

        val fare = CalculateFareUseCase()
        val time = CalculateTimeUseCase(repository)
        val bfsUseCase = BFSUseCase()

        return FindRouteUseCase(
            repository,
            fare,
            time,
            bfsUseCase
        )
    }

    fun provideDirection(context: Context): GetDirectionUseCase {

        val dataSource =
            MetroJsonDataSource(context)

        val repository =
            MetroRepositoryImpl(dataSource)

        val getFirstStationUseCase =
            GetFirstStationUseCase(repository)

        val getLastStationUseCase =
            GetLastStationUseCase(repository)

        return GetDirectionUseCase(
            getFirstStationUseCase,
            getLastStationUseCase
        )
    }

    fun provideGetStations(context: Context): GetAllStationsUseCase{
        val dataSourse = MetroJsonDataSource(context)
        val repository = MetroRepositoryImpl(dataSourse)
        return GetAllStationsUseCase(repository)

    }
}