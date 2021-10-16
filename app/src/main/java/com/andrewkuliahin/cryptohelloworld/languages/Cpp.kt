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
object Cpp : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 18.sp

    override fun getName(): String = "C++"

    override fun getYear(): Int = 1985

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Procedural,
        Paradigm.Functional,
        Paradigm.ObjectOriented,
        Paradigm.Generic,
        Paradigm.Modular
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "#include ", color = primaryColor)
            appendWithColor(string = "<iostream>\n\n", color = primaryVariantColor)
            appendWithColor(string = "int ", color = secondaryColor)
            appendWithColor(string = "main", color = secondaryVariantColor)
            append("() {\n")
            append("${tab}std::cout ")
            appendWithColor(string = " << ", color = primaryVariantColor)
            appendWithColor(string = "\"Hello, World!\"", color = secondaryColor)
            appendWithColor(string = " << ", color = primaryVariantColor)
            append("std::endl;\n")
            appendWithColor(string = "${tab}return ", color = secondaryVariantColor)
            appendWithColor(string = "0", color = primaryVariantColor)
            append(";\n")
            append("}")
        }
    }
}
