package my.androidbasics.ui.amphibians

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import my.androidbasics.data.model.Amphibian

@Composable
fun AmphibianList(
    items: List<Amphibian>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items) { amph ->
            AmphibianItem(amph)
        }
    }
}

@Composable
private fun AmphibianItem(amph: Amphibian) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(amph.imgSrcUrl),
                contentDescription = amph.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = amph.name,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = amph.type,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
            Text(
                text = amph.description,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}