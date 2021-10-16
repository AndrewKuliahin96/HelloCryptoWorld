package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Lua : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Lua"

    override fun getYear(): Int = 1993

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Scripting,
        Paradigm.Imperative,
        Paradigm.PrototypeBased,
        Paradigm.ObjectOriented,
        Paradigm.Functional
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "print", color = primaryColor)
            append("(")
            appendWithColor(string = "\"Hello, World!\"", color = primaryVariantColor)
            append(")")
        }
    }
}
