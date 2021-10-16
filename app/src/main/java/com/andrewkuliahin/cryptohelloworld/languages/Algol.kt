package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Algol : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "ALGOL 68"

    override fun getYear(): Int = 1968

    override fun getParadigms(): List<Paradigm> = listOf(Paradigm.Concurrent, Paradigm.Imperative)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            append("( ")
            appendWithColor(string = "printf", color = primaryColor)
            append("( ")
            appendWithColor(string = "${'$'}", color = secondaryColor)
            appendWithColor(string = "\"Hello, World!\"", color = primaryVariantColor)
            appendWithColor(string = "l${'$'}", color = secondaryColor)
            append(") )")
        }
    }
}
