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
object Php : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "PHP"

    override fun getYear(): Int = 1995

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Functional,
        Paradigm.Imperative,
        Paradigm.ObjectOriented,
        Paradigm.Procedural,
        Paradigm.Reflective
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "<?php\n", color = secondaryVariantColor)
            appendWithColor(string = "${tab}echo ", color = primaryColor)
            appendWithColor(string = "'Hello, world!'", color = secondaryColor)
            append(";\n")
            appendWithColor(string = "<?php", color = secondaryVariantColor)
        }
    }
}
