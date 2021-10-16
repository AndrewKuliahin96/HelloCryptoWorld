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
object Verilog : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 18.sp

    override fun getName(): String = "Verilog"

    override fun getYear(): Int = 1984

    override fun getParadigms(): List<Paradigm> = listOf(Paradigm.Structured)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "module ", color = primaryColor)
            appendWithColor(string = "main", color = secondaryColor)
            append("();\n")
            appendWithColor(string = "${tab}initial begin\n", color = primaryColor)
            append("$tab$tab#0")
            appendWithColor(string = "${'$'}display", color = primaryVariantColor)
            append("(")
            appendWithColor(string = "\"Hello, world!\"", color = secondaryVariantColor)
            append(");\n")
            append("$tab$tab#1")
            appendWithColor(string = "${'$'}finish", color = primaryVariantColor)
            append(";\n")
            appendWithColor(string = "${tab}end\n", color = primaryColor)
            appendWithColor(string = "endmodule", color = primaryColor)
        }
    }
}
