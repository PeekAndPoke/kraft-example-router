package io.peekandpoke.kraft.examples.helloworld.forms

import de.peekandpoke.kraft.components.Component
import de.peekandpoke.kraft.components.Ctx
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.forms.validation.numbers.greaterThan
import de.peekandpoke.kraft.forms.validation.strings.notBlank
import de.peekandpoke.kraft.semanticui.forms.UiInputField
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.ultra.common.OnChange
import de.peekandpoke.ultra.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.domain.Person
import kotlinx.html.Tag

@Suppress("FunctionName")
fun Tag.CallbackPersonEditor(
    subject: Person,
    onChange: OnChange<Person>,
) = comp(
    CallbackPersonEditor.Props(subject = subject, onChange = onChange)
) {
    CallbackPersonEditor(it)
}

class CallbackPersonEditor(ctx: Ctx<Props>) : Component<CallbackPersonEditor.Props>(ctx) {

    //  PROPS  //////////////////////////////////////////////////////////////////////////////////////////////////

    data class Props(
        val subject: Person,
        val onChange: OnChange<Person>,
    )

    private val subject get() = props.subject

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {

        ui.three.fields {

            UiInputField(value = subject.firstName, onChange = { props.onChange(subject.copy(firstName = it)) }) {
                label("First Name")
                accepts(notBlank())
            }

            UiInputField(value = subject.lastName, onChange = { props.onChange(subject.copy(lastName = it)) }) {
                label("Last Name")
                accepts(notBlank())
            }

            UiInputField(value = subject.age, onChange = { props.onChange(subject.copy(age = it)) }) {
                label("Age")
                accepts(greaterThan(0))
            }
        }

        ui.divider()

        CallbackAddressEditor(subject.address) { props.onChange(subject.copy(address = it)) }
    }
}
