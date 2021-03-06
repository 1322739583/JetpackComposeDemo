// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
@Preview
fun TestCheckBox() {

    var state by remember { mutableStateOf(false) }

    Checkbox(  checked = state, onCheckedChange = { state=!state})
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        TestCheckBox()
    }
}
