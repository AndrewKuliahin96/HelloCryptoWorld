package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Ruby : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Ruby"

    override fun getYear(): Int = 1995

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Imperative,
        Paradigm.ObjectOriented,
        Paradigm.Functional,
        Paradigm.Reflective
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "puts ", color = primaryColor)
            appendWithColor(string = "'Hello, world!'", color = primaryVariantColor)
        }
    }
}
