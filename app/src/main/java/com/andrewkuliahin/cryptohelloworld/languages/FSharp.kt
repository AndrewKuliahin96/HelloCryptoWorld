package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object FSharp : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "F#"

    override fun getYear(): Int = 2005

    override fun getParadigms(): List<Paradigm> =
        listOf(Paradigm.Functional, Paradigm.Imperative, Paradigm.ObjectOriented)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "printfn ", color = primaryColor)
            appendWithColor(string = "\"Hello, World!\"", color = secondaryColor)
        }
    }
}
