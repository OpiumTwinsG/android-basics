package my.androidbasics.data.network

import my.androidbasics.data.model.Book

fun VolumeDto.toBook(): Book {
    return Book(
        id = id,
        title = info.title,
        authors = info.authors?.joinToString(", ") ?: "Unknown",
        description = info.description ?: "—",
        thumbnailUrl = info.images?.thumbnail
            ?.replace("http://", "https://") ?: ""
    )
}