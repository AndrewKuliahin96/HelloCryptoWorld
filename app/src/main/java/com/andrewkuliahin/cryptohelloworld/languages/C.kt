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
object C : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "C"

    override fun getYear(): Int = 1972

    override fun getParadigms(): List<Paradigm> = listOf(Paradigm.Imperative, Paradigm.Structured)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "#include ", color = primaryColor)
            appendWithColor(string = "<stdio.h>\n\n", color = primaryVariantColor)
            appendWithColor(string = "int ", color = secondaryColor)
            appendWithColor(string = "main", color = secondaryVariantColor)
            append("(")
            appendWithColor(string = "void", color = secondaryColor)
            append(") {\n")
            append("${tab}printf(")
            appendWithColor(string = "\"Hello, World!\"\\n", color = secondaryColor)
            append(");\n\n")
            appendWithColor(string = "${tab}return ", color = secondaryVariantColor)
            appendWithColor(string = "0", color = primaryVariantColor)
            append(";\n")
            append("}")
        }
    }
}
