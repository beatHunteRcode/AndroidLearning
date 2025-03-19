package com.example.androidlearning.google_codelabs.navigation.screens.build_basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidlearning.google_codelabs.C
import com.example.androidlearning.R
import com.example.androidlearning.google_codelabs.navigation.screens.Utils

@Preview(
    showBackground = true
)
@Composable
fun ComposeQuadrantScreen() {
    Column() {
        Row(Modifier.weight(50f)) {
            Quadrant(
                header = Utils.QUADRANT_TEXT_COMPOSABLE_TITLE,
                text = Utils.QUADRANT_TEXT_COMPOSABLE_TEXT,
                padding = PaddingValues(16.dp),
                backgroundColor = colorResource(id = R.color.lavender),
                columnModifier = Modifier.weight(50f),
                titleModifier = Modifier.semantics { testTag = C.Tag.compose_quadrant_text_composable_title_text },
                textModifier = Modifier.semantics { testTag = C.Tag.compose_quadrant_text_composable_text }
            )
            Quadrant(
                header = Utils.QUADRANT_IMAGE_COMPOSABLE_TITLE,
                text = Utils.QUADRANT_IMAGE_COMPOSABLE_TEXT,
                padding = PaddingValues(16.dp),
                backgroundColor = colorResource(id = R.color.perfume),
                columnModifier = Modifier.weight(50f),
                titleModifier = Modifier.semantics { testTag = C.Tag.compose_quadrant_image_composable_title_text },
                textModifier = Modifier.semantics { testTag = C.Tag.compose_quadrant_image_composable_text }
            )
        }
        Row(Modifier.weight(50f)) {
            Quadrant(
                header = Utils.QUADRANT_ROW_COMPOSABLE_TITLE,
                text = Utils.QUADRANT_ROW_COMPOSABLE_TEXT,
                padding = PaddingValues(16.dp),
                backgroundColor = colorResource(id = R.color.biloba_flower),
                columnModifier = Modifier.weight(50f),
                titleModifier = Modifier.semantics { testTag = C.Tag.compose_quadrant_row_composable_title_text },
                textModifier = Modifier.semantics { testTag = C.Tag.compose_quadrant_row_composable_text }
            )
            Quadrant(
                header = Utils.QUADRANT_COLUMN_COMPOSABLE_TITLE,
                text = Utils.QUADRANT_COLUMN_COMPOSABLE_TEXT,
                padding = PaddingValues(16.dp),
                backgroundColor = colorResource(id = R.color.selago),
                columnModifier = Modifier.weight(50f),
                titleModifier = Modifier.semantics { testTag = C.Tag.compose_quadrant_column_composable_title_text },
                textModifier = Modifier.semantics { testTag = C.Tag.compose_quadrant_column_composable_text }
            )
        }
    }
}

@Composable
fun Quadrant(
    header: String,
    text: String,
    padding: PaddingValues,
    backgroundColor: Color,
    columnModifier: Modifier = Modifier,
    titleModifier : Modifier = Modifier,
    textModifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = columnModifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(backgroundColor)

    ) {
        Text (
            text = header,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            modifier = titleModifier.padding(padding),
        )
        Text (
            text = text,
            textAlign = TextAlign.Justify,
            fontSize = Utils.DEFAULT_FONT_SIZE,
            modifier = textModifier.padding(padding)
        )
    }
}