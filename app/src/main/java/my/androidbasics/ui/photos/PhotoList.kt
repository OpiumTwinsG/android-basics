package my.androidbasics.ui.photos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
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
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(photo.imgSrcUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "ID: ${photo.id}",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}