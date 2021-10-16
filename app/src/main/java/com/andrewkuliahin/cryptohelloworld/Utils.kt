package com.andrewkuliahin.cryptohelloworld

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import java.io.File

const val tab = "    "

fun AnnotatedString.Builder.appendWithColor(string: String, color: Color) {
    withStyle(style = SpanStyle(color = color)) {
        this.append(string)
    }
}

fun createBitmapFromView(view: View, width: Int, height: Int): Bitmap {
    view.layoutParams = LinearLayoutCompat.LayoutParams(
        LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
        LinearLayoutCompat.LayoutParams.WRAP_CONTENT
    )

    view.measure(
        View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
        View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
    )

    view.layout(0, 0, width, height)

    val canvas = Canvas()
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

    canvas.setBitmap(bitmap)
    view.draw(canvas)

    return bitmap
}

class FileManager constructor(private val context: Context) {

    private val filesDirectory: File? get() = context.filesDir

    private val fileDirectory = File(checkNotNull(filesDirectory).absolutePath)

    fun createPngFile(fileName: String): File {
        if (!fileDirectory.exists()) fileDirectory.mkdirs()
        val name = "${normalizeFileName(fileName)}.png"
        return File(fileDirectory, name)
    }

    private fun normalizeFileName(name: String): String {
        return name.replace(Regex(SIMPLE_FILE_NAME_REGEXP), "_")
    }

    companion object {
        private const val SIMPLE_FILE_NAME_REGEXP = "[ /:*?\"<>|]"
    }
}
