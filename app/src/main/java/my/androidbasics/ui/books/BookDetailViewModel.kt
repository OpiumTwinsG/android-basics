package my.androidbasics.ui.books

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.androidbasics.data.model.Book
import my.androidbasics.data.repository.BookRepository
import my.androidbasics.data.repository.DefaultBookRepository

class BookDetailViewModel(
    private val repo: BookRepository = DefaultBookRepository()
) : ViewModel() {

    val bookState = mutableStateOf<Book?>(null)

    fun load(id: String) {
        viewModelScope.launch {
            bookState.value = repo.getById(id)
        }
    }
}