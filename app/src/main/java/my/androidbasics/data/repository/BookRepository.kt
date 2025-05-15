package my.androidbasics.data.repository

import my.androidbasics.data.model.Book

interface BookRepository {
    suspend fun search(query: String): List<Book>
    suspend fun getById(id: String): Book
}