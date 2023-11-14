package xyz.teamgravity.coilimagecaching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.imageLoader
import coil.memory.MemoryCache
import xyz.teamgravity.coilimagecaching.ui.theme.CoilImageCachingTheme

class MainActivity : ComponentActivity() {

    private companion object {
        const val IMAGE_1 = "https://wallpapers.com/images/high/dope-tupac-c9vwk8smqdtq03z6.webp"
        const val IMAGE_2 = "https://wallpapers.com/images/high/dope-tupac-yhnq90aald491099.webp"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageCachingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AsyncImage(
                            model = IMAGE_1,
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                        AsyncImage(
                            model = IMAGE_2,
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                        Button(
                            onClick = {
                                imageLoader.memoryCache?.remove(MemoryCache.Key(IMAGE_1))
                                imageLoader.diskCache?.remove(IMAGE_2)
                            }
                        ) {
                            Text(
                                text = stringResource(id = R.string.clear_image_cache)
                            )
                        }
                    }
                }
            }
        }
    }
}