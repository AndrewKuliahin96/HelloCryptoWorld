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
object Scala : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Scala"

    override fun getYear(): Int = 2004

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Concurrent,
        Paradigm.Functional,
        Paradigm.Imperative,
        Paradigm.ObjectOriented
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "object ", color = primaryColor)
            appendWithColor(string = "HelloWorld ", color = secondaryColor)
            appendWithColor(string = "object ", color = primaryColor)
            appendWithColor(string = "App ", color = secondaryColor)
            append("{\n")
            appendWithColor(string = "${tab}println", color = primaryVariantColor)
            append("(")
            appendWithColor(string = "\"Hello, world!\"", color = secondaryVariantColor)
            append(")\n")
            append("}")
        }
    }
}