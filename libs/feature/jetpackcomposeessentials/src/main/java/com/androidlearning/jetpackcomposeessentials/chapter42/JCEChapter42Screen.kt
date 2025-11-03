package com.androidlearning.jetpackcomposeessentials.chapter42

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.androidlearning.jetpackcomposeessentials.R
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset
import kotlinx.coroutines.launch

/**
 * The Pager composables provide a simple yet effective way to present multiple content elements in scrollable
 * pages. When content is presented this way, users move between pages using swipe gestures.
 */
@Composable
internal fun JCEChapter42Screen() {
    Screen()
}

@Composable
private fun Screen() {
    Column {
        CoverHorizontalPager()
        Spacer(modifier = Modifier.height(ScreenLayoutSize.dp16))
        CoverVerticalPager()
        Spacer(modifier = Modifier.height(ScreenLayoutSize.dp16))
        Box(
            modifier = Modifier
                .height(ScreenLayoutSize.dp10)
                .fillMaxWidthWithEdgeOffset()
                .background(Color.Blue)
        )
    }
}

@Composable
fun CoverHorizontalPager() {
    val pagerState = rememberPagerState { drawables.size - 1 }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidthWithEdgeOffset()) {
        HorizontalPager(
            state = pagerState
        ) { page ->
            Image(
                modifier = Modifier
                    .padding(ScreenLayoutSize.dp10)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(ScreenLayoutSize.dp10)),
                painter = painterResource(drawables[page]),
                contentDescription = null
            )
        }
        Row(horizontalArrangement = Arrangement.Center) {
            Icon(
                modifier = Modifier
                    .size(ScreenLayoutSize.dp75)
                    .clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    },
                painter = painterResource(R.drawable.baseline_arrow_back_24),
                contentDescription = null
            )
            Icon(
                modifier = Modifier
                    .size(ScreenLayoutSize.dp75)
                    .clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                painter = painterResource(R.drawable.baseline_arrow_forward_24),
                contentDescription = null
            )
        }
    }
}

@Composable
fun CoverVerticalPager() {
    val pagerState = rememberPagerState { drawables.size - 1 }
    val coroutineScope = rememberCoroutineScope()

    Row {
        Column(verticalArrangement = Arrangement.Center) {
            Icon(
                modifier = Modifier
                    .size(ScreenLayoutSize.dp75)
                    .clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    },
                painter = painterResource(R.drawable.baseline_arrow_upward_24),
                contentDescription = null
            )
            Icon(
                modifier = Modifier
                    .size(ScreenLayoutSize.dp75)
                    .clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                painter = painterResource(R.drawable.baseline_arrow_downward_24),
                contentDescription = null
            )
        }
        VerticalPager(
            state = pagerState,
        ) { page ->
            Image(
                modifier = Modifier
                    .padding(ScreenLayoutSize.dp10)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(ScreenLayoutSize.dp10)),
                painter = painterResource(drawables[page]),
                contentDescription = null
            )
        }
    }
}

private val drawables = listOf(
    R.drawable.cover_1,
    R.drawable.cover_2,
    R.drawable.cover_3,
    R.drawable.cover_4,
    R.drawable.cover_5,
)

@Preview(showBackground = true)
@Composable
private fun JCEChapter42ScreenPreview() {
    JCEChapter42Screen()
}