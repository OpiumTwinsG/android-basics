package my.androidbasics.ui.amphibians

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.androidbasics.data.model.Amphibian
import my.androidbasics.data.repository.AmphibianRepository
import android.util.Log

class AmphibiansViewModel(
    private val repo: AmphibianRepository = AmphibianRepository()
) : ViewModel() {

    val amphibians = mutableStateOf<List<Amphibian>>(emptyList())

    init {
        viewModelScope.launch {
            try {
                val list = repo.getAmphibians()
                Log.d("AmphibiansVM", "Loaded ${list.size} amphibians")
                amphibians.value = list
            } catch (e: Exception) {
                Log.e("AmphibiansVM", "Error loading amphibians", e)
            }
        }
    }
}