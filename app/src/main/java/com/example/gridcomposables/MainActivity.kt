package com.example.gridcomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridcomposables.ui.theme.GridComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridComposablesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var osList =
                        listOf(
                            "Android", "IOS", "Widndows", "Linux", "MacOS", "Unix",
                            "Android", "IOS", "Widndows", "Linux", "MacOS", "Unix",
                            "Android", "IOS", "Widndows", "Linux", "MacOS", "Unix",
                            "Android", "IOS", "Widndows", "Linux", "MacOS", "Unix",
                            "Android", "IOS", "Widndows", "Linux", "MacOS", "Unix",
                            "Android", "IOS", "Widndows", "Linux", "MacOS", "Unix",
                            "Android", "IOS", "Widndows", "Linux", "MacOS", "Unix",
                            "Android", "IOS", "Widndows", "Linux", "MacOS", "Unix",
                        )
                        PopulateItems(osList)
                }
            }
        }
    }
}

/*
*
* The lazy option let you lay out the component when
* they're visible in the widget viewport
*
* The available list of components includes lazycolumn,
* LazyRow and their grid alternatives.
*
* Lazy composables follow the same set of principles as the RecyclerView
* widget but remove all that annoying boilerplate code.
*
* To arrange list items in a grid, lazyVerticalGrid
* provides a cells parameter that controls how cells are formed into columns.
*
* */

@Composable
fun PopulateItems(osList: List<String>){
    LazyVerticalGrid(
//        reverseLayout = true,
        columns = GridCells.Fixed(2),
        content = {
            items(osList.size){
                    index  ->   Card(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults
                    .cardElevation(8.dp),
                colors = CardDefaults
                    .cardColors(Color.Blue)
                    ) {
                    Text(text = osList[index],
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                        )
            }
            }
        },
        state = LazyGridState(0)
        )
}