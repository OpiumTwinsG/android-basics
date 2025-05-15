package my.androidbasics.ui.photos

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.androidbasics.data.model.MarsPhoto
import my.androidbasics.data.repository.MarsRepository

class PhotosViewModel(
    private val repository: MarsRepository = MarsRepository()
) : ViewModel() {

    val photos = mutableStateOf<List<MarsPhoto>>(emptyList())

    init {
        viewModelScope.launch {
            try {
                val list = repository.getPhotos()
                Log.d("PhotosVM", "Loaded ${list.size} photos")  // логируем количество
                photos.value = list
            } catch (e: Exception) {
                Log.e("PhotosVM", "Error loading photos", e)    // и ошибки, если есть
            }
        }
    }
}