
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun MessageList(  ) {


    LazyColumn(   ) {
        // Add a single item
        item {
            Text(text = "First item")
        }

        // Add 5 items
        items(5) { index ->
            MessageRow(index)
        }

        // Add another single item
        item {
            Text(text = "Last item")
        }
    }

}

@Composable
fun MessageRow(index: Int) {
    Row(){
        Text(text = "item")
        Icon(imageVector = Icons.Default.Star,contentDescription = null)
    }
}



fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MessageList()
    }
}