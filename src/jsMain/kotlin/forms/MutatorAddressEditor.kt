package io.peekandpoke.kraft.examples.helloworld.forms

import io.peekandpoke.kraft.components.Component
import io.peekandpoke.kraft.components.Ctx
import io.peekandpoke.kraft.components.comp
import io.peekandpoke.kraft.examples.helloworld.domain.*
import io.peekandpoke.kraft.forms.validation.strings.notBlank
import io.peekandpoke.kraft.semanticui.forms.UiInputField
import io.peekandpoke.kraft.vdom.VDom
import io.peekandpoke.mutator.Mutator
import io.peekandpoke.ultra.semanticui.ui
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
