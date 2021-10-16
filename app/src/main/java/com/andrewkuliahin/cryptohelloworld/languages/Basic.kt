package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Basic : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "BASIC"

    override fun getYear(): Int = 1964

    override fun getParadigms(): List<Paradigm> =
        listOf(Paradigm.NonStructured, Paradigm.Procedural, Paradigm.ObjectOriented)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "PRINT ", color = primaryColor)
            appendWithColor(string = "\"Hello, World!\"\n", color = primaryVariantColor)
            appendWithColor(string = "END", color = primaryColor)
        }
    }
}
