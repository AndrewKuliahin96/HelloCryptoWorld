package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Swift : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 20.sp

    override fun getName(): String = "Swift"

    override fun getYear(): Int = 2014

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.ProtocolOriented,
        Paradigm.ObjectOriented,
        Paradigm.Functional,
        Paradigm.Imperative,
        Paradigm.BlockStructured,
        Paradigm.Declarative
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "print", color = primaryColor)
            append("(")
            appendWithColor(string = "\"Hello, world!\"", color = secondaryVariantColor)
            append(")")
        }
    }
}
