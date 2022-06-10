import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun ScaffoldUI() {

    Scaffold(
        topBar = {

            Column() {


                TopAppBar(
                    //标题
                    title = {
                        Text(
                            modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center),
                            text = "TODO"
                        )

                    },
                    //导航按钮，一般为返回按钮
                    navigationIcon = {
                        IconButton(onClick = { println("返回") }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                        }
                    },
                    //其它按钮
                    actions = {
                        IconButton(onClick = { println("分享") }) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = null)
                        }
                        IconButton(onClick = { println("设置") }) {
                            Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                        }
                    },
                    //背景色
                    backgroundColor = Color(0xffffffaa),
                    //内容颜色
                    contentColor = Color.Black,
                    //底部阴影
                    elevation = 5.dp
                )

                Spacer(modifier = Modifier.padding(50.dp))

                TopAppBar(contentColor = Color.Black, backgroundColor =  Color(0xffffaaff)) {
                    //返回按钮
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                    Text(text = "TODO", modifier = Modifier.fillMaxWidth(0.9f).wrapContentSize(Alignment.Center))
                    IconButton(onClick = { println("分享") }) {
                        Icon(Icons.Default.Share, null)
                    }
                    IconButton(onClick = { println("设置") }) {
                        Icon(Icons.Default.Settings, null)
                    }
                }

            }
        },

        ) {

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        ScaffoldUI()
    }
}
