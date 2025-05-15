package my.androidbasics.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BooksApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: BooksApiService =
        retrofit.create(BooksApiService::class.java)
}