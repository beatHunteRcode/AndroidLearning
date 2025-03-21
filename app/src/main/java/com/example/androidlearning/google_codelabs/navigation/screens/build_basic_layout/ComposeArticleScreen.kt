package com.example.androidlearning.google_codelabs.navigation.screens.build_basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlearning.google_codelabs.C
import com.example.androidlearning.R
import com.example.androidlearning.google_codelabs.navigation.screens.Utils

@Preview (
    showBackground = true
)
@Composable
fun ComposeArticleScreen() {
    Column (
        modifier = Modifier.semantics { testTag = C.Tag.compose_article_screen }
    ) {
        ArticleImage(
            R.drawable.bg_compose_article_background,
            modifier = Modifier.semantics { testTag = C.Tag.compose_article_image }
        )
        ArticleParagraph(
            text = Utils.ARTICLE_TOPIC_STRING,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            padding = PaddingValues(16.dp),
            modifier = Modifier.semantics { testTag = C.Tag.compose_article_topic }
        )
        ArticleParagraph(
            text = Utils.ARTICLE_FIRST_PARAGRAPH_STRING,
            fontSize = Utils.DEFAULT_FONT_SIZE,
            textAlign = TextAlign.Justify,
            padding = PaddingValues(16.dp, 0.dp, 16.dp, 0.dp),
            modifier = Modifier.semantics { testTag = C.Tag.compose_article_first_paragraph }
        )
        ArticleParagraph(
            text = Utils.ARTICLE_SECOND_PARAGRAPH_STRING,
            fontSize = Utils.DEFAULT_FONT_SIZE,
            textAlign = TextAlign.Justify,
            padding = PaddingValues(16.dp),
            modifier = Modifier.semantics { testTag = C.Tag.compose_article_second_paragraph }
        )
    }
}

@Composable
fun ArticleImage(imageResourceId: Int, modifier: Modifier = Modifier) {
    val image = painterResource(id = imageResourceId)
    Image(
        painter = image,
        contentDescription = "Article Image",
        modifier = modifier
    )
}

@Composable
fun ArticleParagraph(
    text: String,
    fontSize: TextUnit,
    padding: PaddingValues,
    textAlign: TextAlign,
    modifier: Modifier = Modifier) {
    Text (
        text = text, 
        fontSize = fontSize,
        textAlign = textAlign,
        modifier = modifier.padding(padding)
    )
}