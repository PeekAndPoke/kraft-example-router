package io.peekandpoke.kraft.examples.helloworld.forms

import de.peekandpoke.kraft.components.Component
import de.peekandpoke.kraft.components.Ctx
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.forms.validation.strings.notBlank
import de.peekandpoke.kraft.semanticui.forms.UiInputField
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.mutator.Mutator
import de.peekandpoke.ultra.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.domain.*
import kotlinx.html.Tag

@Suppress("FunctionName")
fun Tag.MutatorAddressEditor(
    subject: Mutator<Address>,
) = comp(
    MutatorAddressEditor.Props(subject = subject)
) {
    MutatorAddressEditor(it)
}

class MutatorAddressEditor(ctx: Ctx<Props>) : Component<MutatorAddressEditor.Props>(ctx) {

    //  PROPS  //////////////////////////////////////////////////////////////////////////////////////////////////

    data class Props(
        val subject: Mutator<Address>,
    )

    private val subject get() = props.subject

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {

        UiInputField(subject::line1) {
            label("Address line 1")
            accepts(notBlank())
        }
        UiInputField(subject::line2) {
            label("Address line 2")
        }

        ui.three.fields {
            UiInputField(subject::zip) {
                label("ZIP")
                accepts(notBlank())
            }
            UiInputField(subject::city) {
                label("City")
                accepts(notBlank())
            }
            UiInputField(subject::country) {
                label("Country")
                accepts(notBlank())
            }
        }
    }
}
