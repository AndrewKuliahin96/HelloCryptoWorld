package com.andrewkuliahin.cryptohelloworld.languages

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.TextUnit
import com.andrewkuliahin.cryptohelloworld.languages.colors.Colors
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm

sealed class ProgrammingLanguage : Parcelable {
    val backgroundColor: Color by lazy { Colors.background.random() }
    protected val primaryColor: Color by lazy { Colors.primary.random() }
    protected val primaryVariantColor: Color by lazy { Colors.primaryVariant.random() }
    protected val secondaryColor: Color by lazy { Colors.secondary.random() }
    protected val secondaryVariantColor: Color by lazy { Colors.secondaryVariant.random() }

    abstract fun getTextSize(): TextUnit
    abstract fun getName(): String
    abstract fun getYear(): Int
    abstract fun getParadigms(): List<Paradigm>
    abstract fun getAnnotatedHelloWorld(): AnnotatedString
}
