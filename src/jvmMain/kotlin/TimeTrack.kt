import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File
import java.time.LocalDateTime

var fileName = getTime()
val trackFile = File("timeTrack/$fileName")
var textList = mutableMapOf<Int,String>()
var flag=true


@Composable
@Preview
fun TimeTrackUI() {
    val colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )


    Column() {


        Row(modifier = Modifier.height(50.dp)) {
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

        Divider(color = Color.DarkGray)


        for (i in 0..9) {
            println(i)
            var text by remember { mutableStateOf("") }

            //这样会导致不能编辑，每次更新UI读取数据
            if (trackFile.exists()&&flag ){
                var lineStr = textList.get(i)
                //需要判断，不然恢复的数据会显示null
                if (lineStr==null){
                    lineStr=""
                }
                text=lineStr
            }else{
                //不存在
                textList.put(i,text)
            }

            Row {
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                        flag=false
                    },
                    colors = colors,
                    modifier = Modifier.fillMaxWidth().padding(0.dp),
                    textStyle = TextStyle.Default.copy(fontWeight = Bold, fontSize = 20.sp),
                    visualTransformation = VisualTransformation.None
                )
            }
            // Spacer(modifier = Modifier.background(Color.Blue).height(2.dp))
            Divider(color = Color.DarkGray)
        }

    }
}

fun getTime(): String {
    return LocalDateTime.now().toString().substring(0, 10)
}

fun readFromFile(): MutableMap<Int,String> {
    if (trackFile.exists()) {
        var mutableMap=mutableMapOf<Int,String>()
        trackFile.readLines().forEachIndexed { index, s->

            mutableMap.put(index,s)
        }
        return mutableMap
    }
    flag=true
    throw Exception("File is never created!")
}

private fun saveToFile(textList: MutableMap<Int,String>) {

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
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        try {
            textList = readFromFile()
            println(textList)
        } catch (e: Exception) {
            e.printStackTrace()

        }
        TimeTrackUI()
    }
}
