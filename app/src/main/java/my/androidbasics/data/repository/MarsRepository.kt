package my.androidbasics.data.repository

import my.androidbasics.data.model.MarsPhoto
import my.androidbasics.data.network.MarsApi

class MarsRepository {
    suspend fun getPhotos(): List<MarsPhoto> =
        MarsApi.service.getPhotos()
}