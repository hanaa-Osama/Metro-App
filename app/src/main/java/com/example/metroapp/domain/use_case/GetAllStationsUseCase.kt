package com.example.metroapp.domain.use_case

import data.model.StationDTO
import com.example.metroapp.domain.repo.MetroRepository
import domain.model.Station

class GetAllStationsUseCase(
    private val repository: MetroRepository
) {

    operator fun invoke(): List<Station>{
        return repository.getStations()
    }
}