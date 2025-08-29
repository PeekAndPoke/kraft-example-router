package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.components.Component
import de.peekandpoke.kraft.components.Ctx
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.semanticui.ui
import de.peekandpoke.kraft.vdom.VDom
import kotlinx.html.Tag
import kotlinx.html.b
import kotlinx.html.div
import kotlinx.html.p

@Suppress("FunctionName")
fun Tag.ThreeParamsPage(
    p1: String,
    p2: String,
    p3: String,
) = comp(
    ThreeParamsPage.Props(p1 = p1, p2 = p2, p3 = p3)
) {
    ThreeParamsPage(it)
}

class ThreeParamsPage(ctx: Ctx<Props>) : Component<ThreeParamsPage.Props>(ctx) {

    //  PROPS  //////////////////////////////////////////////////////////////////////////////////////////////////

    data class Props(
        val p1: String,
        val p2: String,
        val p3: String,
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
        p { +"Value for p3: "; b { +props.p3 } }
    }
}
