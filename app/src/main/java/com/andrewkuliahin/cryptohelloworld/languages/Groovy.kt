package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Groovy : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Groovy"

    override fun getYear(): Int = 2003

    override fun getParadigms(): List<Paradigm> =
        listOf(Paradigm.ObjectOriented, Paradigm.Imperative, Paradigm.Scripting)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "println ", color = primaryColor)
            appendWithColor(string = "\"Hello, World!\"", color = secondaryColor)
        }
    }
}
