package io.peekandpoke.kraft.examples.helloworld.forms

import de.peekandpoke.kraft.components.Component
import de.peekandpoke.kraft.components.Ctx
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.forms.validation.strings.notBlank
import de.peekandpoke.kraft.semanticui.forms.UiInputField
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.ultra.common.OnChange
import de.peekandpoke.ultra.semanticui.ui
import io.peekandpoke.kraft.examples.helloworld.domain.Address
import kotlinx.html.Tag

@Suppress("FunctionName")
fun Tag.CallbackAddressEditor(
    subject: Address,
    onChange: OnChange<Address>,
) = comp(
    CallbackAddressEditor.Props(subject = subject, onChange = onChange)
) {
    CallbackAddressEditor(it)
}

class CallbackAddressEditor(ctx: Ctx<Props>) : Component<CallbackAddressEditor.Props>(ctx) {

    //  PROPS  //////////////////////////////////////////////////////////////////////////////////////////////////

    data class Props(
        val subject: Address,
        val onChange: OnChange<Address>,
    )

    private val subject get() = props.subject

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {

        UiInputField(value = subject.line1, onChange = { props.onChange(subject.copy(line1 = it)) }) {
            label("Address line 1")
            accepts(notBlank())
        }
        UiInputField(value = subject.line2, onChange = { props.onChange(subject.copy(line2 = it)) }) {
            label("Address line 2")
        }

        ui.three.fields {
            UiInputField(value = subject.zip, onChange = { props.onChange(subject.copy(zip = it)) }) {
                label("ZIP")
                accepts(notBlank())
            }
            UiInputField(value = subject.city, onChange = { props.onChange(subject.copy(city = it)) }) {
                label("City")
                accepts(notBlank())
            }
            UiInputField(value = subject.country, onChange = { props.onChange(subject.copy(country = it)) }) {
                label("Country")
                accepts(notBlank())
            }
        }
    }
}
