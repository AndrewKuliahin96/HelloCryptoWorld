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
object Rust : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Rust"

    override fun getYear(): Int = 2010

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Imperative,
        Paradigm.Functional,
        Paradigm.Concurrent,
        Paradigm.Structured,
        Paradigm.Generic
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "fn ", color = primaryColor)
            appendWithColor(string = "main", color = primaryVariantColor)
            append("() {\n")
            appendWithColor(string = "${tab}println!", color = primaryVariantColor)
            append("(")
            appendWithColor(string = "\"Hello, world!\"", color = secondaryColor)
            append(")\n")
            append("}")
        }
    }
}
