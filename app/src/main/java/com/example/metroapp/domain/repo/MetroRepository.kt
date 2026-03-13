package com.example.metroapp.domain.repo

import domain.model.Station

interface MetroRepository {

    fun getStations(): List<Station>

    fun getTravelTime(): Int

}