package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Haskell : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Haskell"

    override fun getYear(): Int = 1990

    override fun getParadigms(): List<Paradigm> = listOf(Paradigm.PurelyFunctional)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "main", color = primaryColor)
            appendWithColor(string = " = ", color = secondaryColor)
            appendWithColor(string = "putStrLn ", color = primaryVariantColor)
            appendWithColor(string = "\"Hello, World!\"", color = secondaryVariantColor)
        }
    }
}
