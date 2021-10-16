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
object Dart : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Dart"

    override fun getYear(): Int = 2012

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Functional,
        Paradigm.Imperative,
        Paradigm.ObjectOriented,
        Paradigm.Reflective
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "main", color = primaryColor)
            append("() {\n")
            appendWithColor(string = "${tab}print", color = primaryColor)
            append("(")
            appendWithColor(string = "'Hello, World!'", color = secondaryVariantColor)
            append(");\n")
            append("}")
        }
    }
}
