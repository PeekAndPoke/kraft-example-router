package io.peekandpoke.kraft.examples.helloworld.pages

import io.peekandpoke.kraft.components.Component
import io.peekandpoke.kraft.components.Ctx
import io.peekandpoke.kraft.components.comp
import io.peekandpoke.kraft.vdom.VDom
import io.peekandpoke.ultra.semanticui.ui
import kotlinx.html.Tag
import kotlinx.html.b
import kotlinx.html.div
import kotlinx.html.p

@Suppress("FunctionName")
fun Tag.OneParamPage(
    p1: String,
) = comp(
    OneParamPage.Props(p1 = p1)
) {
    OneParamPage(it)
}

class OneParamPage(ctx: Ctx<Props>) : Component<OneParamPage.Props>(ctx) {

    //  PROPS  //////////////////////////////////////////////////////////////////////////////////////////////////

    data class Props(
        val p1: String,
    )

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {
        div {
            renderBackButton()
        }

        ui.divider()

        p { +"This page is mounted by a route with the following parameters" }

        p { +"Value for p1: "; b { +props.p1 } }
    }
}
