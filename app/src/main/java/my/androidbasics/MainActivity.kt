package my.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import my.androidbasics.ui.books.BookListScreen
import my.androidbasics.ui.books.BooksViewModel
import my.androidbasics.ui.books.BookDetailScreen
import my.androidbasics.ui.books.BookDetailViewModel

import my.androidbasics.ui.theme.AndroidBasicsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding   ->
                    NavHost(
                        navController = navController,
                        startDestination = "list",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("list") {
                            BookListScreen { id ->
                                navController.navigate("detail/$id")
                            }
                        }
                        composable(
                            "detail/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id = backStackEntry.arguments!!.getString("id")!!
                            BookDetailScreen(bookId = id)
                        }
                    }
                }
            }
        }
    }
}