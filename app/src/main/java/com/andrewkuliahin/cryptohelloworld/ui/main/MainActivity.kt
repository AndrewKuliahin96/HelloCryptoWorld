package com.andrewkuliahin.cryptohelloworld.ui.main

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.andrewkuliahin.cryptohelloworld.DrawerView
import com.andrewkuliahin.cryptohelloworld.FileManager
import com.andrewkuliahin.cryptohelloworld.languages.ProgrammingLanguage
import com.andrewkuliahin.cryptohelloworld.languages.programmingLanguages
import com.andrewkuliahin.cryptohelloworld.ui.theme.CanvasArtTheme
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : ComponentActivity() {

    private var currentLanguage: String? = null

    private val programmingLanguagesSorted by lazy {
        programmingLanguages.sortedBy { it.getName() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            CanvasArtTheme {
                Scaffold {
                    NavigationComponent(navController)
                }
            }
        }
    }

    @Composable
    fun NavigationComponent(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Screens.LANGUAGES_SCREEN.screenName
        ) {
            composable(route = Screens.LANGUAGES_SCREEN.screenName) {
                LanguagesScreen(navController)
            }

            composable(
                route = "${Screens.LANGUAGE_SCREEN.screenName}/{${NavArguments.PROGRAMMING_LANGUAGE.argumentName}}",
                arguments = listOf(navArgument(NavArguments.PROGRAMMING_LANGUAGE.argumentName) {
                    type = NavType.StringType
                })
            ) { backStackEntry ->
                backStackEntry.arguments?.getString(NavArguments.PROGRAMMING_LANGUAGE.argumentName)
                    ?.let { programmingLanguage ->
                        LanguageDetailScreen(navController, programmingLanguage)
                    }
            }
        }
    }

    @Composable
    fun LanguagesScreen(navController: NavController) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(programmingLanguagesSorted) { programmingLanguage ->
                ProgrammingLanguageItem(programmingLanguage) {
                    navigateToLanguage(navController, it.getName())
                }
            }

            if (currentLanguage != null) {
                val index =
                    programmingLanguagesSorted.indexOfFirst { it.getName() == currentLanguage }

                programmingLanguagesSorted.getOrNull(index + 1)?.let {
                    navigateToLanguage(navController, it.getName())
                }

                currentLanguage = null
            }
        }
    }

    @Composable
    fun ProgrammingLanguageItem(
        programmingLanguage: ProgrammingLanguage,
        onItemClicked: (ProgrammingLanguage) -> Unit
    ) {
        Text(
            text = programmingLanguage.getName(),
            modifier = Modifier.clickable { onItemClicked(programmingLanguage) })
    }

    @Composable
    fun LanguageDetailScreen(navController: NavController, languageName: String) {
        Surface(color = MaterialTheme.colors.background) {
            AndroidView(factory = { context ->
                DrawerView(context, languageName) { bitmap, forLanguage ->
                    saveBitmap(bitmap, forLanguage)
                    navController.popBackStack()
                    currentLanguage = forLanguage
                }
            })
        }
    }

    private fun navigateToLanguage(navController: NavController, language: String) {
        navController.navigate("${Screens.LANGUAGE_SCREEN.screenName}/$language")
    }

    private fun saveBitmap(bitmap: Bitmap, forLanguage: String?) {
        try {
            val file = FileManager(this).createPngFile(
                forLanguage ?: System.currentTimeMillis().toString()
            )

            FileOutputStream(file).use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    enum class Screens(val screenName: String) {
        LANGUAGES_SCREEN("languages"),
        LANGUAGE_SCREEN("language");
    }

    enum class NavArguments(val argumentName: String) {
        PROGRAMMING_LANGUAGE("languageId")
    }
}
