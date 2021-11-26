package com.frogobox.nutritionapp.mvvm.androidmethod.admob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.theme.NutritionFrameworkTheme
import com.frogobox.nutritionframework.admob.NutriAdmobBannerView
import com.frogobox.nutritionframework.admob.adsize_banner

class NutriAdmobComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutritionFrameworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        NutriAdmobBannerView(
                            mAdUnitID = getString(R.string.admob_banner),
                            mAdSize = adsize_banner
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    NutritionFrameworkTheme {
        Greeting("Android")
    }
}