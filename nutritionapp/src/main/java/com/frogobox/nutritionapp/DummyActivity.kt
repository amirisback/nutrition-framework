package com.frogobox.nutritionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.frogobox.nutritionapp.mvvm.nutrition.article.NutritionArticleViewModel
import com.frogobox.nutritionapp.theme.NutritionFrameworkTheme
import com.frogobox.nutritioncore.compose.ui.nutri_dimen_16dp
import com.frogobox.nutritioncore.compose.ui.nutri_dimen_4dp
import com.frogobox.nutritioncore.compose.widget.NutriCircularProgressIndicator
import com.frogobox.nutritioncore.compose.widget.NutriLazyColumn
import com.frogobox.nutritioncore.compose.widget.NutriListType1
import com.frogobox.nutritioncore.compose.widget.NutriSimpleTopAppBar
import com.frogobox.nutritioncore.model.news.Article
import com.frogobox.nutritionframework.compose.widget.NutriListType11
import org.koin.androidx.viewmodel.ext.android.viewModel

class DummyActivity : ComponentActivity() {

    private val nutritionArticleViewModel: NutritionArticleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var dataState: List<Article> by remember { mutableStateOf(emptyList()) }
            var progressState: Boolean by remember { mutableStateOf(false) }

            nutritionArticleViewModel.apply {

                getEverythings()
                topHeadlineLive.observe(this@DummyActivity, {
                    it.articles?.let { it1 -> dataState = it1 }
                })

                eventShowProgress.observe(this@DummyActivity, {
                    progressState = it
                })
            }

            NutritionFrameworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    if (progressState) {
                        NutriCircularProgressIndicator()
                    } else {
                        UiRv(listData = dataState)
                    }

                }
            }
        }
    }


}

@Composable
fun UiRv(listData: List<Article>) {
    Column() {
        NutriSimpleTopAppBar(
            titleContent = "Nutrition Framework Development",
            elevationContent = nutri_dimen_4dp
        )
        NutriLazyColumn(
            data = listData,
            contentPadding = PaddingValues(bottom = nutri_dimen_16dp)
        ) {
            it.urlToImage?.let { it1 ->
                it.title?.let { it2 ->
                    it.author?.let { it3 ->
                        it.content?.let { it4 ->
                            NutriListType11(
                                imageUrlContent = it1,
                                titleTextContent = it2,
                                subTitleTextContent = it3,
                                descTitleTextContent = it4,
                                isAndroid = true
                            )
                        }
                    }
                }
            }
        }
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