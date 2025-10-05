package io.peekandpoke.kraft.examples.helloworld.forms

import de.peekandpoke.kraft.components.Component
import de.peekandpoke.kraft.components.Ctx
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.forms.validation.numbers.greaterThan
import de.peekandpoke.kraft.forms.validation.strings.notBlank
import de.peekandpoke.kraft.semanticui.forms.UiInputField
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.mutator.Mutator
import de.peekandpoke.ultra.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.domain.*
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
