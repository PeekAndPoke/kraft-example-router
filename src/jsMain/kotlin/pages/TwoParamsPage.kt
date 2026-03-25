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
fun Tag.TwoParamsPage(
    p1: String,
    p2: String,
) = comp(
    TwoParamsPage.Props(p1 = p1, p2 = p2)
) {
    TwoParamsPage(it)
}

class TwoParamsPage(ctx: Ctx<Props>) : Component<TwoParamsPage.Props>(ctx) {

    //  PROPS  //////////////////////////////////////////////////////////////////////////////////////////////////

    data class Props(
        val p1: String,
        val p2: String,
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
        p { +"Value for p2: "; b { +props.p2 } }
    }
}
