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
object Go : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 18.sp

    override fun getName(): String = "Go"

    override fun getYear(): Int = 2009

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Functional,
        Paradigm.Concurrent,
        Paradigm.Imperative,
        Paradigm.ObjectOriented
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "package ", color = primaryColor)
            appendWithColor(string = "main\n\n", color = primaryVariantColor)
            appendWithColor(string = "import ", color = primaryColor)
            appendWithColor(string = "\"fmt\"\n\n", color = secondaryColor)
            appendWithColor(string = "func ", color = primaryColor)
            appendWithColor(string = "main", color = secondaryVariantColor)
            append("() {\n")
            appendWithColor(string = "${tab}fmt.Println", color = secondaryVariantColor)
            append("(")
            appendWithColor(string = "\"Hello, World!\"", color = secondaryColor)
            append(")\n")
            append("}")
        }
    }
}
