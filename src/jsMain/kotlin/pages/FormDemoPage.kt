package io.peekandpoke.kraft.examples.helloworld.pages

import de.peekandpoke.kraft.addons.forms.formController
import de.peekandpoke.kraft.components.NoProps
import de.peekandpoke.kraft.components.PureComponent
import de.peekandpoke.kraft.components.comp
import de.peekandpoke.kraft.components.onClick
import de.peekandpoke.kraft.semanticui.noui
import de.peekandpoke.kraft.semanticui.ui
import de.peekandpoke.kraft.vdom.VDom
import de.peekandpoke.mutator.onChange
import io.peekandpoke.kraft.examples.helloworld.domain.Address
import io.peekandpoke.kraft.examples.helloworld.domain.Person
import io.peekandpoke.kraft.examples.helloworld.domain.mutator
import io.peekandpoke.kraft.examples.helloworld.forms.PersonEditor
import io.peekandpoke.kraft.examples.helloworld.util.JsonUtil
import kotlinx.browser.window
import kotlinx.html.Tag
import kotlinx.html.div
import kotlinx.html.pre

@Suppress("FunctionName")
fun Tag.FormDemoPage() = comp {
    FormDemoPage(it)
}

class FormDemoPage(ctx: NoProps) : PureComponent(ctx) {

    //  STATE  //////////////////////////////////////////////////////////////////////////////////////////////////

    val subject = Person(
        firstName = "John",
        lastName = "Doe",
        age = 35,
        address = Address(
            line1 = "Some street",
            line2 = "c/o Someone",
            zip = "ABC-12345",
            city = "Some-Francisco",
            country = "Somewhere",
        )
    )

    val subjectMutator = subject.mutator().onChange { triggerRedraw() }

    val formCtrl = formController()

    //  IMPL  ///////////////////////////////////////////////////////////////////////////////////////////////////

    override fun VDom.render() {

        div {
            renderBackButton()
        }

        ui.divider()

        ui.header H1 { +"Form Demo" }

        ui.form {
            PersonEditor(subjectMutator)

            ui.divider()

            ui.horizontal.list {
                noui.item {
                    +"Is modified: ${subjectMutator.isModified()}"
                }
                noui.item {
                    +"Is valid: ${formCtrl.isValid}"
                }
            }

            ui.divider()

            val canSubmit = formCtrl.isValid && subjectMutator.isModified()

            ui.fluid.orange.givenNot(canSubmit) { disabled }.button {
                onClick {
                    if (formCtrl.validate()) {
                        subjectMutator.commit()
                        window.alert("Commited...")
                    }
                }
                +"Commit"
            }
        }

        ui.divider()

        ui.two.column.grid {
            ui.row {
                ui.column {
                    ui.header { +"Initial Value" }
                    ui.segment {
                        pre {
                            +JsonUtil.prettyJson.encodeToString(subjectMutator.getInitialValue())
                        }
                    }
                }
                ui.column {
                    ui.header { +"Modified Value" }
                    ui.segment {
                        pre {
                            +JsonUtil.prettyJson.encodeToString(subjectMutator())
                        }
                    }
                }
            }
        }
    }
}
