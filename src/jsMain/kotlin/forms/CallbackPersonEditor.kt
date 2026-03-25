package io.peekandpoke.kraft.examples.helloworld.forms

import io.peekandpoke.kraft.components.Component
import io.peekandpoke.kraft.components.Ctx
import io.peekandpoke.kraft.components.comp
import io.peekandpoke.kraft.examples.helloworld.domain.Person
import io.peekandpoke.kraft.forms.validation.numbers.greaterThan
import io.peekandpoke.kraft.forms.validation.strings.notBlank
import io.peekandpoke.kraft.semanticui.forms.UiInputField
import io.peekandpoke.kraft.vdom.VDom
import io.peekandpoke.ultra.common.OnChange
import io.peekandpoke.ultra.semanticui.ui
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
