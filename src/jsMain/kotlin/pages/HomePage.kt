package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.components.NoProps
import de.peekandpoke.kraft.components.PureComponent
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.routing.href
import de.peekandpoke.kraft.routing.router
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.ultra.html.onClick
import de.peekandpoke.ultra.semanticui.icon
import de.peekandpoke.ultra.semanticui.noui
import de.peekandpoke.ultra.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.routes
import kotlinx.html.FlowContent
import kotlinx.html.Tag

@Suppress("FunctionName")
fun Tag.HomePage() = comp {
    HomePage(it)
}

class HomePage(ctx: NoProps) : PureComponent(ctx) {

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {

        ui.header H2 { +"Navigation with a(href=...) style" }

        hrefStyle()

        ui.header H2 { +"Navigation with onClick" }

        onClickStyle()

        ui.header H2 { +"Demos" }

        demos()
    }

    private fun FlowContent.hrefStyle() {

        ui.relaxed.divided.list {
            noui.item A {
                val route = routes.staticRoute()
                href(route)
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a static route" }
                    noui.meta { +router.strategy.render(route) }
                }
            }

            noui.item A {
                val route = routes.oneParamRoute("val-1")
                href(route)
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a route with one parameters" }
                    noui.meta { +router.strategy.render(route) }
                }
            }

            noui.item A {
                val route = routes.twoParamsRoute("val-1", "val-2")
                href(route)
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a route with two parameters" }
                    noui.meta { +router.strategy.render(route) }
                }
            }

            noui.item A {
                val route = routes.threeParamsRoute("val-1", "val-2", "val-3")
                href(route)
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a route with three parameters" }
                    noui.meta { +router.strategy.render(route) }
                }
            }

            noui.item A {
                val route = routes.fourParamsRoute("val-1", "val-2", "val-3", "val-4")
                href(route)
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a route with four parameters" }
                    noui.meta { +router.strategy.render(route) }
                }
            }
        }
    }

    private fun FlowContent.onClickStyle() {

        ui.relaxed.divided.list {
            noui.link.item {
                val route = routes.staticRoute()
                onClick { evt ->
                    router.navToUri(evt, route)
                }
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a static route" }
                    noui.meta { +router.strategy.render(route) }
                }
            }

            noui.link.item {
                val route = routes.oneParamRoute("val-1")
                onClick { evt ->
                    router.navToUri(evt, route)
                }
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a route with one parameters" }
                    noui.meta { +router.strategy.render(route) }
                }
            }

            noui.link.item {
                val route = routes.twoParamsRoute("val-1", "val-2")
                onClick { evt ->
                    router.navToUri(evt, route)
                }
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a route with two parameters" }
                    noui.meta { +router.strategy.render(route) }
                }
            }

            noui.link.item {
                val route = routes.threeParamsRoute("val-1", "val-2", "val-3")
                onClick { evt ->
                    router.navToUri(evt, route)
                }
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a route with three parameters" }
                    noui.meta { +router.strategy.render(route) }
                }
            }

            noui.link.item {
                val route = routes.fourParamsRoute("val-1", "val-2", "val-3", "val-4")
                onClick { evt ->
                    router.navToUri(evt, route)
                }
                icon.big.mouse_pointer()
                noui.content {
                    noui.header { +"Navigate to a route with four parameters" }
                    noui.meta { +router.strategy.render(route) }
                }
            }
        }
    }

    private fun FlowContent.demos() {
        ui.relaxed.divided.list {
            noui.link.item {
                val route = routes.demoFormsWithMutator()
                onClick { evt ->
                    router.navToUri(evt, route)
                }
                icon.big.file_code()
                noui.content {
                    noui.header { +"Forms with Mutators demos" }
                    noui.meta { +router.strategy.render(route) }
                }
            }
        }
    }
}
