package my.androidbasics.ui.photos

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import my.androidbasics.data.model.MarsPhoto

@Composable
fun PhotoList(
    photos: List<MarsPhoto>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(photos) { photo ->
            PhotoItem(photo)
        }
    }
}

@Composable
private fun PhotoItem(photo: MarsPhoto) {
    Card(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "ID: ${photo.id}",
            modifier = Modifier.padding(16.dp)
        )
    }
}