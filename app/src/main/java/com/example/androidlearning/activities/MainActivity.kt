package com.example.androidlearning.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidlearning.C
import com.example.androidlearning.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize().semantics { testTag = C.Tag.main_activity_screen }
    ) {
        TransferToActivityButton(
            text = stringResource(R.string.go_to_build_basic_layout_activity),
            BuildBasicLayoutActivity::class.java,
            modifier = Modifier.semantics { testTag = C.Tag.go_to_buildBasicLayoutActivity_button }
        )
        Spacer(modifier = Modifier.height(100.dp))
        TransferToActivityButton(
            text = stringResource(R.string.go_to_compose_essentials_activity),
            activityClass = ComposeEssentialsActivity::class.java,
            modifier = Modifier.semantics { testTag = C.Tag.go_to_composeEssentialsActivity_button }
        )
    }
}

@Composable
fun TransferToActivityButton(text: String, activityClass: Class<*>, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, activityClass))
    },
    modifier = modifier
    ) {
        Text(text = text)
    }
}