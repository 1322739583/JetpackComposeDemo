// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {




    Column() {
        Row(modifier = Modifier.fillMaxWidth().background(Color.Gray)) {

            Text(
                text = "名字：",
                fontSize = 20.sp,
                color = Color.Green,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "张三",
                fontSize = 20.sp,
                color = Color.Green,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
        }



//        Row() {
//
//            Text(
//                text = "年龄：",
//                fontSize = 20.sp,
//                color = Color.Green,
//                fontStyle = FontStyle.Normal,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier
//                    .background(Color.Yellow)
//                    .align(Alignment.CenterVertically)
//            )
//            Text(
//                text = "20",
//                fontSize = 20.sp,
//                color = Color.Green,
//                fontStyle = FontStyle.Normal,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier
//                    .background(Color.Blue)
//                    .align(Alignment.CenterVertically)
//            )

       // }

    }


}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
