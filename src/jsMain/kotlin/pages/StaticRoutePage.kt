package io.peekandpoke.kraft.examples.helloworld.pages

import io.peekandpoke.kraft.components.NoProps
import io.peekandpoke.kraft.components.PureComponent
import io.peekandpoke.kraft.components.comp
import io.peekandpoke.kraft.vdom.VDom
import io.peekandpoke.ultra.semanticui.ui
import kotlinx.html.Tag
import kotlinx.html.div
import kotlinx.html.p

@Suppress("FunctionName")
fun Tag.StaticRoutePage() = comp {
    StaticRoutePage(it)
}

class StaticRoutePage(ctx: NoProps) : PureComponent(ctx) {

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {

        div {
            renderBackButton()
        }

        ui.divider()

        p { +"This page is mounted by a static route" }
    }
}
