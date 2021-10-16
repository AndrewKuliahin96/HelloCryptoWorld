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
object Fortran : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Fortran"

    override fun getYear(): Int = 1957

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Structured,
        Paradigm.Imperative,
        Paradigm.Procedural,
        Paradigm.ObjectOriented
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "program ", color = primaryColor)
            appendWithColor(string = "hello\n", color = primaryVariantColor)
            appendWithColor(string = "${tab}write", color = primaryColor)
            append("(")
            appendWithColor(string = "*", color = secondaryVariantColor)
            append(",")
            appendWithColor(string = "*", color = secondaryVariantColor)
            append(") ")
            appendWithColor(string = "'Hello, World!'\n", color = secondaryColor)
            appendWithColor(string = "end program ", color = primaryColor)
            appendWithColor(string = "hello", color = primaryVariantColor)
        }
    }
}
