package my.androidbasics.data.network

import com.google.gson.annotations.SerializedName

data class BooksResponse(
    val items: List<VolumeDto>?
)

data class VolumeDto(
    val id: String,
    @SerializedName("volumeInfo") val info: VolumeInfoDto
)

data class VolumeInfoDto(
    val title: String,
    val authors: List<String>?,
    val description: String?,
    @SerializedName("imageLinks") val images: ImageLinksDto?
)

data class ImageLinksDto(
    val thumbnail: String?
)
