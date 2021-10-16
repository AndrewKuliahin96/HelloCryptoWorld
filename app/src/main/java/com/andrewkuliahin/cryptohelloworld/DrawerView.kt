package com.andrewkuliahin.cryptohelloworld

import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.ComposeView
import com.andrewkuliahin.cryptohelloworld.languages.Fortran
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import com.andrewkuliahin.cryptohelloworld.languages.ProgrammingLanguage
import com.andrewkuliahin.cryptohelloworld.languages.programmingLanguages
import java.util.Calendar
import kotlin.random.Random

class DrawerView constructor(context: Context) : LinearLayoutCompat(context) {

    constructor(
        context: Context,
        languageName: String,
        onBitmapCreated: (bitmap: Bitmap, forLanguage: String?) -> Unit
    ) : this(context) {
        this.onBitmapCreated = onBitmapCreated
        this.languageName = languageName
    }

    private var onBitmapCreated: ((bitmap: Bitmap, forLanguage: String?) -> Unit)? = null
    private var languageName: String? = null

    init {
        val view = ComposeView(context)

        addView(view)

        view.setBackgroundColor(android.graphics.Color.WHITE)

        view.setContent {
            programmingLanguages.firstOrNull { it.getName() == languageName }?.let {
                ProgrammingLanguageCanvas(it)
            }
        }

        postDelayed({
            val bitmap = createBitmapFromView(view = view, width = width, height = height)
            onBitmapCreated?.invoke(bitmap, languageName)
        }, 3_000L)
    }
}

@Composable
fun ProgrammingLanguageCanvas(programmingLanguage: ProgrammingLanguage) {
    val circleCenters by remember { mutableStateOf(getCirclesCenters(programmingLanguage.getParadigms())) }

    Box(
        Modifier
            .fillMaxWidth()
            .aspectRatio(1F)
            .background(
                color = programmingLanguage.backgroundColor.copy(
                    alpha = getAlphaForProgrammingLanguage(programmingLanguage)
                )
            )
    ) {
        Canvas(
            modifier = Modifier,
            onDraw = {
                circleCenters.forEach { center ->
                    drawCircle(
                        color = Color.Green.copy(
                            red = randomFloat(0.0, 1.0),
                            green = randomFloat(0.0, 1.0),
                            blue = randomFloat(0.0, 1.0)
                        ),
                        radius = randomFloat(25.0, 150.0),
                        alpha = 0.2F,
                        center = center
                    )
                }
            })

        Text(
            modifier = Modifier
                .fillMaxSize(fraction = 1F)
                .wrapContentSize(Alignment.Center),
            text = programmingLanguage.getAnnotatedHelloWorld(),
            fontSize = programmingLanguage.getTextSize(),
            style = MaterialTheme.typography.h4.copy(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(2F, 2F),
                    blurRadius = 4F
                )
            )
        )
    }
}

private fun getCirclesCenters(paradigms: List<Paradigm>): List<Offset> {
    return paradigms.indices.map {
        Offset(x = randomFloat(50.0, 950.0), y = randomFloat(50.0, 950.0))
    }
}

private fun randomFloat(from: Double = 0.0, to: Double) = Random.nextDouble(from, to).toFloat()

private fun getAlphaForProgrammingLanguage(
    programmingLanguage: ProgrammingLanguage,
    maxAlpha: Float = 0.3F
): Float {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)

    val firstProgrammingLanguageYears = currentYear - Fortran.getYear()
    val languageYears = currentYear - programmingLanguage.getYear()

    return maxAlpha / firstProgrammingLanguageYears * languageYears
}
