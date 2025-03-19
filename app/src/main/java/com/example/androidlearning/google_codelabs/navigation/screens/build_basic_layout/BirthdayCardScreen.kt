package com.example.androidlearning.google_codelabs.navigation.screens.build_basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlearning.google_codelabs.C
import com.example.androidlearning.R

@Preview
@Composable
fun BirthdayCardScreen() {
    BirthdayCardImage(
        message = stringResource(R.string.birthday_card_message_text),
        from = stringResource(R.string.birthday_card_from_text),
        modifier = Modifier.semantics { testTag = C.Tag.birthday_card_screen }
    )
}

@Composable
fun BirthdayCardText(message: String, from: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.semantics { testTag = C.Tag.birthday_card_message_text }
        )
        Text(
            text = from,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(end = 20.dp)
                .align(alignment = Alignment.End)
                .background(color = Color.Cyan)
                .width(250.dp)
                .semantics { testTag = C.Tag.birthday_card_from_text }
        )
    }
}

@Composable
fun BirthdayCardImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.7f,
            modifier = Modifier.semantics { testTag = C.Tag.birthday_card_bg_image }
        )
        BirthdayCardText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp))
    }
}