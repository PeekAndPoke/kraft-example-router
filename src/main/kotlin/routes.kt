package io.peekandpoke.kraft.examples.helloworld

import de.peekandpoke.kraft.addons.routing.*
import io.peekandpoke.kraft.examples.helloworld.pages.*

class Routes {
    val home = Static("")
    val homeSlash = Static("/")

    val staticRoute = Static("/static-route")
    val oneParamRoute = Route1("/params/one/{p1}")
    val twoParamsRoute = Route2("/params/one/{p1}/two/{p2}")
    val threeParamsRoute = Route3("/params/one/{p1}/two/{p2}/three/{p3}")
    val fourParamsRoute = Route4("/params/one/{p1}/two/{p2}/three/{p3}/four/{p4}")
}

fun RouterBuilder.mount(routes: Routes) {
    mount(routes.home) { HomePage() }
    mount(routes.homeSlash) { HomePage() }

    mount(routes.staticRoute) { StaticRoutePage() }
    mount(routes.oneParamRoute) { OneParamPage(it["p1"]) }
    mount(routes.twoParamsRoute) { TwoParamsPage(it["p1"], it["p2"]) }
    mount(routes.threeParamsRoute) { ThreeParamsPage(it["p1"], it["p2"], it["p3"]) }
    mount(routes.fourParamsRoute) { FourParamsPage(it["p1"], it["p2"], it["p3"], it["p4"]) }
}
