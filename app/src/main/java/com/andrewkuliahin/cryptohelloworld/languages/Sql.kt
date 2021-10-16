package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Sql : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 14.sp

    override fun getName(): String = "SQL"

    override fun getYear(): Int = 1974

    override fun getParadigms(): List<Paradigm> = listOf(Paradigm.Declarative)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "CREATE TABLE ", color = primaryColor)
            appendWithColor(string = "message ", color = secondaryColor)
            append("(")
            appendWithColor(string = "text char", color = secondaryVariantColor)
            append("(")
            appendWithColor(string = "15", color = primaryVariantColor)
            append("));\n")
            appendWithColor(string = "INSERT INTO ", color = primaryColor)
            appendWithColor(string = "message ", color = secondaryColor)
            append("(")
            appendWithColor(string = "text", color = secondaryVariantColor)
            append(")")
            appendWithColor(string = " VALUES ", color = primaryColor)
            append("(")
            appendWithColor(string = "'Hello, world!'", color = primaryVariantColor)
            append(");\n")
            appendWithColor(string = "SELECT ", color = primaryColor)
            appendWithColor(string = "text ", color = secondaryVariantColor)
            appendWithColor(string = "FROM ", color = primaryColor)
            appendWithColor(string = "message", color = secondaryColor)
            append(";\n")
            appendWithColor(string = "DROP TABLE ", color = primaryColor)
            appendWithColor(string = "message", color = secondaryColor)
            append(";")
        }
    }
}
