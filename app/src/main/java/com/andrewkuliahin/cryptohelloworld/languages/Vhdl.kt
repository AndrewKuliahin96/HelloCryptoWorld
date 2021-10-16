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
object Vhdl : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 16.sp

    override fun getName(): String = "VHDL"

    override fun getYear(): Int = 1980

    override fun getParadigms(): List<Paradigm> = listOf(Paradigm.Concurrent)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "use ", color = primaryColor)
            appendWithColor(string = "std", color = secondaryColor)
            append(".")
            appendWithColor(string = "textio", color = secondaryColor)
            append(".")
            appendWithColor(string = "all", color = primaryColor)
            append(";\n\n")
            appendWithColor(string = "entity ", color = primaryColor)
            appendWithColor(string = "Hello", color = secondaryColor)
            appendWithColor(string = " is\n", color = primaryColor)
            appendWithColor(string = "end  ", color = primaryColor)
            appendWithColor(string = "Hello", color = secondaryColor)
            append(";\n\n")
            appendWithColor(string = "architecture ", color = primaryColor)
            appendWithColor(string = "Hello_Arch ", color = secondaryColor)
            appendWithColor(string = "of ", color = primaryColor)
            appendWithColor(string = "Hello ", color = secondaryColor)
            appendWithColor(string = "is\n", color = primaryColor)
            appendWithColor(string = "begin\n", color = primaryColor)
            append("${tab}p : ")
            appendWithColor(string = "process\n", color = primaryColor)
            appendWithColor(string = "${tab}variable ", color = primaryColor)
            append("l:line;\n")
            appendWithColor(string = "${tab}begin\n", color = primaryColor)
            appendWithColor(string = "$tab${tab}write", color = primaryVariantColor)
            append("(")
            appendWithColor(string = "l", color = primaryVariantColor)
            append(", ")
            appendWithColor(string = "String", color = secondaryVariantColor)
            append("'(")
            appendWithColor(string = "\"Hello, world!\"", color = secondaryVariantColor)
            append("));\n")
            appendWithColor(string = "$tab${tab}writeline", color = primaryVariantColor)
            append("(")
            appendWithColor(string = "output", color = primaryVariantColor)
            append(", ")
            appendWithColor(string = "l", color = primaryVariantColor)
            append(");\n")
            appendWithColor(string = "$tab${tab}wait", color = primaryColor)
            append(";\n")
            appendWithColor(string = "${tab}end process", color = primaryColor)
            append(";\n")
            appendWithColor(string = "end  ", color = primaryColor)
            appendWithColor(string = "Hello_Arch", color = secondaryColor)
            append(";")
        }
    }
}
