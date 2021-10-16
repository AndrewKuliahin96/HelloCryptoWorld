package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Matlab : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "MATLAB"

    override fun getYear(): Int = 1970

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Functional,
        Paradigm.Imperative,
        Paradigm.Procedural,
        Paradigm.ObjectOriented
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "msgbox", color = primaryColor)
            append("(")
            appendWithColor(string = "'Hello, World!'", color = primaryVariantColor)
            append(")")
        }
    }
}
