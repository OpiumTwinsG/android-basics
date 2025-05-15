package my.androidbasics.data.repository

import my.androidbasics.data.model.Amphibian
import my.androidbasics.data.network.AmphibianApi

class AmphibianRepository {
    suspend fun getAmphibians(): List<Amphibian> =
        AmphibianApi.service.getAmphibians()
}