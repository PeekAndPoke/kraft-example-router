package io.peekandpoke.kraft.examples.helloworld.forms

import de.peekandpoke.kraft.addons.forms.validation.numbers.greaterThan
import de.peekandpoke.kraft.addons.forms.validation.strings.notBlank
import de.peekandpoke.kraft.addons.semanticui.forms.UiInputField
import de.peekandpoke.kraft.components.Component
import de.peekandpoke.kraft.components.Ctx
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.semanticui.ui
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.mutator.Mutator
import io.peekandpoke.kraft.examples.helloworld.domain.Person
import io.peekandpoke.kraft.examples.helloworld.domain.address
import io.peekandpoke.kraft.examples.helloworld.domain.age
import io.peekandpoke.kraft.examples.helloworld.domain.firstName
import io.peekandpoke.kraft.examples.helloworld.domain.lastName
import kotlinx.css.sub
import kotlinx.html.Tag

@Suppress("FunctionName")
fun Tag.PersonEditor(
    subject: Mutator<Person>,
) = comp(
    PersonEditor.Props(subject = subject)
) {
    PersonEditor(it)
}

class PersonEditor(ctx: Ctx<Props>) : Component<PersonEditor.Props>(ctx) {

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

        AddressEditor(subject.address)
    }
}
