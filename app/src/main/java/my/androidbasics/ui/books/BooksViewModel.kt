package my.androidbasics.ui.books

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.androidbasics.data.model.Book
import my.androidbasics.data.repository.BookRepository
import my.androidbasics.data.repository.DefaultBookRepository

sealed interface BooksUiState {
    object Empty : BooksUiState
    object Loading : BooksUiState
    data class Success(val books: List<Book>) : BooksUiState
    data class Error(val message: String) : BooksUiState
}

class BooksViewModel(
    private val repo: BookRepository = DefaultBookRepository()
) : ViewModel() {

    val uiState = mutableStateOf<BooksUiState>(BooksUiState.Empty)

    fun search(query: String) {
        uiState.value = BooksUiState.Loading
        viewModelScope.launch {
            try {
                val list = repo.search(query)
                uiState.value = BooksUiState.Success(list)
            } catch (e: Exception) {
                uiState.value = BooksUiState.Error(e.message ?: "Unknown")
            }
        }
    }
}