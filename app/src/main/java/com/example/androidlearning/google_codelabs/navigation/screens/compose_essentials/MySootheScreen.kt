package com.example.androidlearning.google_codelabs.navigation.screens.compose_essentials

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidlearning.R
import com.example.androidlearning.google_codelabs.theme.MySootheTheme

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true)
@Composable
fun MySootheScreen() {
    MySootheTheme {
        Box(
            Modifier
                .background(Color(0xFFF0EAE2))
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column {
                SearchBar(
                    modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)
                )
                Section(
                    R.string.align_your_body,
                    content = {
                        AlignYourBodyRow(collection = alignYourBodyData)
                    }
                )
                Section(
                    title = R.string.favorite_collections,
                    content = {
                        FavouriteCollectionsGrid(collection = favoriteCollectionsData)
                    }
                )
            }
        }
    }
}

@Composable
fun Section (
    @StringRes title: Int,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        modifier.verticalScroll(rememberScrollState())
    ) {
        Text(
            stringResource(id = title).uppercase(),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .paddingFromBaseline(40.dp, 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}


@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(text = stringResource(R.string.placeholder_search))
        },
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.paddingFromBaseline(24.dp, 8.dp)
        )

    }
}

@Composable
fun FavouriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun AlignYourBodyRow(collection: List<DrawableStringPair>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(collection) {
            item -> AlignYourBodyElement(
                drawable = item.drawable,
                text = item.text,
            )
        }
    }
}

@Composable
fun FavouriteCollectionsGrid(
    collection: List<DrawableStringPair>,
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(10.dp)
            .height(120.dp),

    ) {
        items(collection) {
            item -> FavouriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                modifier = Modifier.height(56.dp)
            )
        }
    }
}