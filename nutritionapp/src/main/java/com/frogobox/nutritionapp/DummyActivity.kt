package com.frogobox.nutritionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.frogobox.nutritionapp.mvvm.nutrition.article.NutritionArticleViewModel
import com.frogobox.nutritionapp.theme.NutritionFrameworkTheme
import com.frogobox.nutritioncore.compose.ui.nutri_dimen_16dp
import com.frogobox.nutritioncore.compose.widget.NutriLazyColumn
import com.frogobox.nutritioncore.compose.widget.NutriListType1
import com.frogobox.nutritioncore.model.news.Article
import org.koin.androidx.viewmodel.ext.android.viewModel

class DummyActivity : ComponentActivity() {

    private val nutritionArticleViewModel: NutritionArticleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var newsState: List<Article> by remember { mutableStateOf(emptyList()) }

            nutritionArticleViewModel.apply {

                getEverythings()
                topHeadlineLive.observe(this@DummyActivity, {
                    it.articles?.let { it1 -> newsState = it1 }
                })
            }

            NutritionFrameworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    UiRv(listData = newsState)
                }
            }
        }
    }


}

@Composable
fun UiRv(listData: List<Article>) {
    NutriLazyColumn(
        data = listData,
        contentPadding = PaddingValues(bottom = nutri_dimen_16dp)
    ) {
        it.title?.let { it1 -> NutriListType1(textContent = it1) }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    NutritionFrameworkTheme {
        NutriListType1("Card Framework Ini Multiplatform")
    }
}