package com.example.androidlearning.navigation.screens.build_basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlearning.C
import com.example.androidlearning.R

@Preview(
    showBackground = true
)
@Composable
fun BusinessCardScreen() {
    val backgroundImage = painterResource(id = R.drawable.business_card_bg)
    Image(
        painter = backgroundImage,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = 1f,
        modifier = Modifier.semantics { testTag = C.Tag.business_card_bg_image }
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .semantics { testTag = C.Tag.business_card_screen }
    ) {
        BusinessCardImage(
            R.drawable.bh_logo,
            modifier = Modifier.semantics { testTag = C.Tag.business_card_person_avatar }
        )
        BusinessCardPersonName(
            name = stringResource(R.string.business_card_person_name_text),
            status = stringResource(R.string.business_card_person_status_text),
            Modifier.padding(20.dp)
        )
        BusinessCardPersonContacts(
            phone = stringResource(R.string.business_card_contacts_phone_text),
            telegram = stringResource(R.string.business_card_contacts_telegram_text),
            email = stringResource(R.string.business_card_contacts_email_text),
        )
    }
}

@Composable
fun BusinessCardImage(imageResourceId: Int, modifier: Modifier = Modifier) {
    val image = painterResource(id = imageResourceId)
    Image(
        painter = image,
        contentDescription = "Person Avatar",
        modifier = modifier
            .border(5.dp, Brush.sweepGradient(
                listOf(
                    Color(0xFF9575CD),
                    Color(0xFF223DC5),
                    Color(0xFFBA68C8),
                    Color(0xFFAD32C2),
                    Color(0xFF4DD0E1),
                    Color(0xFF9575CD),
                )
            ), CircleShape)
            .clip(CircleShape).size(280.dp)
    )
}

@Composable
fun BusinessCardPersonName(name: String, status: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.semantics { testTag = C.Tag.business_card_person_name }
        )
        Text(
            text = status,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .padding(0.dp, 10.dp, 0.dp, 0.dp)
                .semantics { testTag = C.Tag.business_card_person_status }
        )
    }
}

@Composable
fun BusinessCardPersonContacts(
    phone: String,
    telegram: String,
    email: String,
    modifier: Modifier = Modifier
) {
    val phoneIcon = painterResource(id = R.drawable.ic_phone)
    val telegramIcon = painterResource(id = R.drawable.ic_telegram)
    val emailIcon = painterResource(id = R.drawable.ic_email)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp, 0.dp, 0.dp)
            .background(Brush.linearGradient(
                listOf(
                    Color(0xFF9E82F0),
                    Color(0xFF42A5F5)
                )
            ), RoundedCornerShape(10.dp), alpha = 0.7f)
            .border(5.dp, Brush.sweepGradient(
                    listOf(
                        Color(0xFF9575CD),
                        Color(0xFF223DC5),
                        Color(0xFFBA68C8),
                        Color(0xFFAD32C2),
                        Color(0xFF4DD0E1),
                        Color(0xFF9575CD),
                    )
                ), RoundedCornerShape(10.dp)
            )
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ){
            Icon(
                painter = phoneIcon,
                contentDescription = "Phone Icon",
                Modifier
                    .size(30.dp)
                    .semantics { testTag = C.Tag.business_card_contacts_phone_icon }
            )
            Text(
                text = phone,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 0.dp)
                    .semantics { testTag = C.Tag.business_card_contacts_phone_text }
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ){
            Icon(
                painter = telegramIcon,
                contentDescription = "Telegram Icon",
                Modifier
                    .size(30.dp)
                    .semantics { testTag = C.Tag.business_card_contacts_telegram_icon }
            )
            Text(
                text = telegram,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 0.dp)
                    .semantics { testTag = C.Tag.business_card_contacts_telegram_text }
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ){
            Icon(
                painter = emailIcon,
                contentDescription = "Email Icon",
                Modifier
                    .size(30.dp)
                    .semantics { testTag = C.Tag.business_card_contacts_email_icon }
            )
            Text(
                text = email,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 0.dp)
                    .semantics { testTag = C.Tag.business_card_contacts_email_text }
            )
        }
    }
}