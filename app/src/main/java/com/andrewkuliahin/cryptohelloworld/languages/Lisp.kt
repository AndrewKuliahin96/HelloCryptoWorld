package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Lisp : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Lisp"

    override fun getYear(): Int = 1958

    override fun getParadigms(): List<Paradigm> =
        listOf(Paradigm.Functional, Paradigm.Procedural, Paradigm.Reflective, Paradigm.Meta)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            append("(")
            appendWithColor(string = "write-line ", color = primaryColor)
            appendWithColor(string = "\"Hello, World!\"", color = primaryVariantColor)
            append(")")
        }
    }
}
