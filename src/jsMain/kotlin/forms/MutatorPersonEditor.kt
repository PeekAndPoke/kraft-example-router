package io.peekandpoke.kraft.examples.helloworld.forms

import io.peekandpoke.kraft.components.Component
import io.peekandpoke.kraft.components.Ctx
import io.peekandpoke.kraft.components.comp
import io.peekandpoke.kraft.examples.helloworld.domain.*
import io.peekandpoke.kraft.forms.validation.numbers.greaterThan
import io.peekandpoke.kraft.forms.validation.strings.notBlank
import io.peekandpoke.kraft.semanticui.forms.UiInputField
import io.peekandpoke.kraft.vdom.VDom
import io.peekandpoke.mutator.Mutator
import io.peekandpoke.ultra.semanticui.ui
import kotlinx.html.Tag

@Suppress("FunctionName")
fun Tag.MutatorPersonEditor(
    subject: Mutator<Person>,
) = comp(
    MutatorPersonEditor.Props(subject = subject)
) {
    MutatorPersonEditor(it)
}

class MutatorPersonEditor(ctx: Ctx<Props>) : Component<MutatorPersonEditor.Props>(ctx) {

    //  PROPS  //////////////////////////////////////////////////////////////////////////////////////////////////

    data class Props(
        val subject: Mutator<Person>,
    )

    private val subject get() = props.subject

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {

        ui.three.fields {

            UiInputField(subject::firstName) {
                label("First Name")
                accepts(notBlank())
            }

            UiInputField(subject::lastName) {
                label("Last Name")
                accepts(notBlank())
            }

            UiInputField(subject::age) {
                label("Age")
                accepts(greaterThan(0))
            }
        }

        ui.divider()

        MutatorAddressEditor(subject.address)
    }
}
