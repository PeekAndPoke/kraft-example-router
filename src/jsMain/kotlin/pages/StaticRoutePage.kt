package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.components.NoProps
import de.peekandpoke.kraft.components.PureComponent
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.semanticui.ui
import de.peekandpoke.kraft.vdom.VDom
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
