import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.formdev.flatlaf.FlatIntelliJLaf


@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    var action by remember { mutableStateOf("Last action: None") }
    //菜单里面有一个exit功能，这个变量判断是否关闭应用
    var isOpen by remember { mutableStateOf(true) }


    FlatIntelliJLaf.setup()


    if (isOpen) {
        var isSubmenuShowing by remember { mutableStateOf(false) }
        //onCloseRequest 一般写成这样 onCloseRequest = ::exitApplication
        //::exitApplications是系统调用，这里我们定义一个isOpen手动控制
        Window(onCloseRequest = { isOpen = false }) {

            MenuBar {
                //mnemonic表示菜单快捷键，指定后按alt+对应的键是可以快速弹出菜单的
                Menu(text = "File", mnemonic = 'F') {
                    Item(
                        text = "Copy",
                        onClick = { action = "Last action: Copy" },
                        //显示快捷键
                        shortcut = KeyShortcut(Key.C, ctrl = true)
                    )
                    Item(
                        "Paste",
                        onClick = { action = "Last action: Paste" },
                        shortcut = KeyShortcut(Key.V, ctrl = true)
                    )
                    Item(
                        "Save",
                        onClick = { action = "Last action: Save" },
                        shortcut = KeyShortcut(Key.S, ctrl = true),
                        //可以自定义设置Icon，可以指定resource目录下的图片，也可以继承Painter自己话一个
                        icon = painterResource("save.png")
                    )
                }
                Menu("Actions", mnemonic = 'A') {
                    //CheckboxItem可以做判断隐藏显示一些功能
                    CheckboxItem(
                        "Advanced settings",
                        checked = isSubmenuShowing,
                        onCheckedChange = {
                            isSubmenuShowing = !isSubmenuShowing
                        }
                    )
                    //isSubmenuShowing为真，这些菜单才出现
                    if (isSubmenuShowing) {
                        Menu("Settings") {
                            Item("Setting 1", onClick = { action = "Last action: Setting 1" })
                            Item("Setting 2", onClick = { action = "Last action: Setting 2" })
                        }
                    }
                    //菜单分割线
                    Separator()
                    //TrayIcon是一个自定义Painter，还是直接用图片比较好
                    Item("About", icon = TrayIcon, onClick = { action = "Last action: About" })
                    Item("Exit", onClick = { isOpen = false }, shortcut = KeyShortcut(Key.Escape), mnemonic = 'E')
                }
            }

            //显示哪个菜单被点击
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = action)
            }

        }

    }
}
//自定义Painter，还是直接用图片比较好
object TrayIcon : Painter() {
    override val intrinsicSize = Size(256f, 256f)

    override fun DrawScope.onDraw() {
        drawOval(Color(0xFFFFA500))
    }
}