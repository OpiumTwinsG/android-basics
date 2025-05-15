package my.androidbasics.data.repository

import my.androidbasics.data.model.Book
import my.androidbasics.data.network.BooksApi
import my.androidbasics.data.network.toBook

class DefaultBookRepository : BookRepository {
    override suspend fun search(query: String): List<Book> {
        val resp = BooksApi.service.searchBooks(query)
        return resp.items
            ?.map { it.toBook() }
            ?: emptyList()
    }

    override suspend fun getById(id: String): Book {
        return BooksApi.service.getBook(id).toBook()
    }
}