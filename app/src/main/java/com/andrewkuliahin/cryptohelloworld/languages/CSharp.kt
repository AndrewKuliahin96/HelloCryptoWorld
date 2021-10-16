package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import com.andrewkuliahin.cryptohelloworld.tab
import kotlinx.parcelize.Parcelize

@Parcelize
object CSharp : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 16.sp

    override fun getName(): String = "C#"

    override fun getYear(): Int = 2000

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Structured,
        Paradigm.Imperative,
        Paradigm.Functional,
        Paradigm.ObjectOriented,
        Paradigm.Generic,
        Paradigm.EventDriven,
        Paradigm.TaskDriven,
        Paradigm.Reflective,
        Paradigm.Concurrent
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "using ", color = primaryColor)
            appendWithColor(string = "System;\n\n", color = primaryVariantColor)
            appendWithColor(string = "class ", color = primaryColor)
            appendWithColor(string = "Main\n", color = primaryVariantColor)
            append("{\n")
            appendWithColor(string = "${tab}static void ", color = primaryColor)
            appendWithColor(string = "Main", color = secondaryColor)
            append("()\n")
            append("$tab{\n")
            append("$tab${tab}Console.WriteLine(")
            appendWithColor(string = "\"Hello, World!\"", color = secondaryVariantColor)
            append(");\n")
            append("$tab}\n")
            append("}")
        }
    }
}
