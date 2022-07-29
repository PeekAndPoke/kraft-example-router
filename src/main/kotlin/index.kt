package io.peekandpoke.kraft.examples.helloworld

import de.peekandpoke.kraft.Kraft
import de.peekandpoke.kraft.vdom.preact.PreactVDomEngine
import kotlinx.browser.document
import kotlinx.html.h1
import org.w3c.dom.HTMLElement

fun main() {
    Kraft.initialize()

    // Get the DOM-Element into which the app should be mounted
    val mountPoint = document.getElementById("spa") as HTMLElement

    // Initialize the VDOM-engine (in this case Preact) and render some content
    PreactVDomEngine(mountPoint) {
        h1 { +"Hello World!" }
    }
}
