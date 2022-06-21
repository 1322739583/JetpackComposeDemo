import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.mouseClickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.Key.Companion.Menu
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.input.pointer.isSecondaryPressed
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.formdev.flatlaf.FlatIntelliJLaf
import java.awt.Menu
import java.awt.MenuBar
import java.awt.MenuItem

import java.io.File
import java.time.LocalDateTime
import javax.swing.KeyStroke

var fileName = getTime()
val trackFile = File("timeTrack/$fileName")
var textList = mutableMapOf<Int, String>()
var flag = true


@Composable
@Preview
fun TimeTrackUI() {



    val colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )

    //外面套一层是为了解决圆角背景色不正常。
    Column(modifier = Modifier.background(Color.White)) {


        Column(
            modifier = Modifier.padding(10.dp).background(color = Color(0xffffffcc), shape = RoundedCornerShape(30.dp))
        ) {
            Row(modifier = Modifier.height(50.dp).padding(start = 28.dp, end = 28.dp)) {
//                DropdownMenuItem(onClick = {} ){
//                    Text("item")
//                }
                Button(onClick = {
                    saveToFile(textList)
                }) {
                    Text(text = "保存")
                }
                Text(
                    text = getTime(),
                    modifier = Modifier.fillMaxHeight().wrapContentHeight(Alignment.CenterVertically).padding(10.dp)
                )
            }

            Divider(modifier = Modifier.padding(start = 28.dp, end = 28.dp), color = Color.DarkGray)

            for (i in 0..10) {
                //   println(i)
                var text by remember { mutableStateOf("") }

                //这样会导致不能编辑，每次更新UI读取数据
                if (trackFile.exists() && flag) {
                    var lineStr = textList.get(i)
                    //需要判断，不然恢复的数据会显示null
                    if (lineStr == null) {
                        lineStr = ""
                    }
                    text = lineStr
                } else {
                    //不存在
                    textList.put(i, text)
                }

                Row(modifier = Modifier.padding(start = 28.dp, end = 28.dp)) {
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                            flag = false
                        },
                        colors = colors,
                        modifier = Modifier.fillMaxWidth().padding(0.dp),
                        textStyle = TextStyle.Default.copy(fontWeight = Bold, fontSize = 20.sp),
                        visualTransformation = VisualTransformation.None
                    )
                }
                // Spacer(modifier = Modifier.background(Color.Blue).height(2.dp))
                Divider(modifier = Modifier.padding(start = 28.dp, end = 28.dp), color = Color.DarkGray)
            }

        }
    }
}

fun getTime(): String {
    return LocalDateTime.now().toString().substring(0, 10)
}

fun readFromFile(): MutableMap<Int, String> {
    if (trackFile.exists()) {
        var mutableMap = mutableMapOf<Int, String>()
        trackFile.readLines().forEachIndexed { index, s ->
            mutableMap.put(index, s)
        }
        return mutableMap
    }
    flag = true
    throw Exception("File is never created!")
}


private fun saveToFile(textList: MutableMap<Int, String>) {

    Thread(Runnable {
        var logStr = String()
        textList.forEach { k, v ->
            logStr += v
            if (k < textList.size - 1) {
                logStr += "\n"
            }
        }

        //创建目录
        trackFile.parentFile.mkdirs()
        //创建文件
        trackFile.createNewFile()
        //写入数据
        trackFile.writeText(logStr)
        println("保存成功")
    }).run()


}

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "寸金",
        state = rememberWindowState(width = 500.dp, height = 733.dp),
        icon = painterResource("time.webp"),
        //没有顶部
    ) {
        try {
            textList = readFromFile()
            //  println(textList)
        } catch (e: Exception) {
            e.printStackTrace()

        }

        FlatIntelliJLaf.setup()

        MenuBar {
            //mnemonic表示菜单快捷键，指定后按alt+对应的键是可以快速弹出菜单的
            Menu(text = "文件", mnemonic = 'F') {
                Item(
                    "保存",
                    onClick = {saveToFile(textList) },
                    shortcut = KeyShortcut(Key.S, ctrl = true),
                    //可以自定义设置Icon，可以指定resource目录下的图片，也可以继承Painter自己话一个
                    icon = painterResource("save.png")
                )
            }
            Menu("关于", mnemonic = 'A') {
                Item(
                    "更新",
                    onClick = { }

                    //可以自定义设置Icon，可以指定resource目录下的图片，也可以继承Painter自己话一个

                )

                //菜单分割线
                Separator()
                //TrayIcon是一个自定义Painter，还是直接用图片比较好
                Item(
                    "关于",
                    onClick = { }

                    //可以自定义设置Icon，可以指定resource目录下的图片，也可以继承Painter自己话一个

                )
            }
        }
        TimeTrackUI()
    }

    //定时保存
    Thread(Runnable {
        while (true) {
            Thread.sleep(20000)
            saveToFile(textList)
        }
    }).start()
}

@Composable
fun deskTopeMenu() {

}
