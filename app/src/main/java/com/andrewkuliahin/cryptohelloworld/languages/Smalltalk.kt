package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Smalltalk : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Smalltalk"

    override fun getYear(): Int = 1972

    override fun getParadigms(): List<Paradigm> = listOf(Paradigm.ObjectOriented)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "Transcript ", color = primaryColor)
            appendWithColor(string = "show", color = secondaryColor)
            append(": ")
            appendWithColor(string = "'Hello, world!'", color = secondaryVariantColor)
        }
    }
}
