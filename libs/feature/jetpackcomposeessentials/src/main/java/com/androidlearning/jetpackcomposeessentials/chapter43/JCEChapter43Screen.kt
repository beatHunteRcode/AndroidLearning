package com.androidlearning.jetpackcomposeessentials.chapter43

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

@Composable
internal fun JCEChapter43Screen() {
    Screen()
}

@Composable
private fun Screen() {
    LazyColumn {
        item { Example1() }
        item { Example2() }
        item { Example3() }
        item { Example4() }
        item { Example5() }
        item { Example6() }
        item { Example7() }
        item { Example8() }
        item { Example9() }
        item { Example10() }
        item { Example11() }

        item { Spacer(Modifier.height(ScreenLayoutSize.dp200)) }
    }
}

@Composable
private fun Example1() {
    ExampleTemplate("Simple animation") { isContentVisible ->
        AnimatedVisibility(visible = isContentVisible) {
            BoxToAnimate()
        }
    }
}

@Composable
private fun Example2() {
    ExampleTemplate("Different enter / exit") { isContentVisible ->
        AnimatedVisibility(
            visible = isContentVisible,
            enter = fadeIn(),
            exit = slideOutVertically()
        ) {
            BoxToAnimate()
        }
    }
}

@Composable
private fun Example3() {
    ExampleTemplate("Mixed enter") { isContentVisible ->
        AnimatedVisibility(
            visible = isContentVisible,
            enter =  fadeIn() + expandHorizontally(),
            exit = slideOutVertically()
        ) {
            BoxToAnimate()
        }
    }
}

@Composable
private fun Example4() {
    ExampleTemplate("Slow enter") { isContentVisible ->
        AnimatedVisibility(
            visible = isContentVisible,
            enter =  fadeIn(animationSpec = tween(durationMillis = 5000)),
            exit = slideOutVertically()
        ) {
            BoxToAnimate()
        }
    }
}

@Composable
private fun Example5() {
    ExampleTemplate("Animation spec with custom easing") { isContentVisible ->
        AnimatedVisibility(
            visible = isContentVisible,
            enter =  slideInHorizontally(
                animationSpec = tween(durationMillis = 5000, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutVertically()
        ) {
            BoxToAnimate()
        }
    }
}

@Composable
private fun Example6() {
    ExampleTemplate("Animation spec with bezier easing") { isContentVisible ->
        AnimatedVisibility(
            visible = isContentVisible,
            enter =  slideInHorizontally(
                animationSpec = tween(durationMillis = 5000, easing = CubicBezierEasing(0f, 4f, 0f, 1f))
            ),
            exit = slideOutVertically()
        ) {
            BoxToAnimate()
        }
    }
}

@Composable
private fun Example7() {
    ExampleTemplate("Repeatable animation") { isContentVisible ->
        AnimatedVisibility(
            visible = isContentVisible,
            enter = fadeIn(
                animationSpec = repeatable(5, animation = tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse)
            ),
            exit = slideOutVertically()
        ) {
            BoxToAnimate()
        }
    }
}

@Composable
private fun Example8() {
    ExampleTemplate("Different animations for different children \n (WITH AnimatedVisibility enter / exit)") { isContentVisible ->
        AnimatedVisibility(
            visible = isContentVisible,
            enter = fadeIn(animationSpec = tween(durationMillis = 5500)),
            exit = fadeOut(animationSpec = tween(durationMillis = 5500))
        ) {
            Row {
                BoxToAnimate()
                Spacer(Modifier.width(ScreenLayoutSize.dp16))
                Box(
                    Modifier
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = tween(durationMillis = 5500)
                            ),
                            exit = slideOutVertically(
                                animationSpec = tween(durationMillis = 5500)
                            )
                        )
                        .size(width = 150.dp, height = 150.dp)
                        .background(Color.Black)
                )
            }
        }
    }
}

@Composable
private fun Example9() {
    ExampleTemplate("Different animations for different children \n (WITHOUT AnimatedVisibility enter / exit)") { isContentVisible ->
        AnimatedVisibility(
            visible = isContentVisible,
            enter = EnterTransition.None,
            exit = ExitTransition.None
        ) {
            Row {
                BoxToAnimate()
                Spacer(Modifier.width(ScreenLayoutSize.dp16))
                Box(
                    Modifier
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = tween(durationMillis = 5500)
                            ),
                            exit = slideOutVertically(
                                animationSpec = tween(durationMillis = 5500)
                            )
                        )
                        .size(width = 150.dp, height = 150.dp)
                        .background(Color.Black)
                )
            }
        }
    }
}

@Composable
private fun Example10() {
    ExampleTemplate("Auto-started animation") { _ ->
        val state = remember { MutableTransitionState(false) }
        state.apply { targetState = true }

        AnimatedVisibility(
            visibleState = state,
            enter = fadeIn(
                animationSpec = repeatable(100, animation = tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse)
            ),
            exit = slideOutVertically(),
        ) {
            BoxToAnimate()
        }
    }
}

@Composable
private fun Example11() {
    Box(modifier = Modifier
        .fillMaxWidthWithEdgeOffset()
        .padding(vertical = ScreenLayoutSize.dp16)
        .background(
            color = Color.DarkGray,
            shape = RoundedCornerShape(corner = CornerSize(ScreenLayoutSize.dp48))
        )
        .padding(vertical = ScreenLayoutSize.dp16)
    ) {
        var isContentVisible by remember { mutableStateOf(true) }
        val onClick = { newState: Boolean ->
            isContentVisible = newState
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(ScreenLayoutSize.dp16),
                text = "Crossfade",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = ScreenLayoutSize.dp16),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Crossfade(
                    targetState = isContentVisible,
                    animationSpec = tween(5000),
                    label = "crossFade"
                ) { visible ->
                    when (visible) {
                        true -> {
                            CustomButton(
                                text = "Hide",
                                targetState = false,
                                bgColor = COLOR_PURPLE,
                                onClick = onClick)
                        }
                        false -> {
                            CustomButton(
                                text = "Show",
                                targetState = true,
                                bgColor = Color.Black,
                                onClick = onClick
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(ScreenLayoutSize.dp20))
            AnimatedVisibility(
                visible = isContentVisible,
                enter = fadeIn(animationSpec = tween(durationMillis = 5500)),
                exit = fadeOut(animationSpec = tween(durationMillis = 5500))
            ) {
                Box(modifier = Modifier
                    .size(height = 200.dp, width = 200.dp)
                    .background(COLOR_PURPLE))
            }
        }
    }
}

@Composable
private fun ButtonsRow(onClick: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = ScreenLayoutSize.dp16),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CustomButton(text = "Show", targetState = true, onClick = onClick)
        CustomButton(text = "Hide", targetState = false, onClick = onClick)
    }
}

@Composable
private fun ExampleTemplate(
    title: String,
    content: @Composable (isContentVisible: Boolean) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxWidthWithEdgeOffset()
        .padding(vertical = ScreenLayoutSize.dp16)
        .background(
            color = Color.DarkGray,
            shape = RoundedCornerShape(corner = CornerSize(ScreenLayoutSize.dp48))
        )
        .padding(vertical = ScreenLayoutSize.dp16)
    ) {
        var isContentVisible by remember { mutableStateOf(true) }
        val onClick = { newState: Boolean ->
            isContentVisible = newState
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(ScreenLayoutSize.dp16),
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            ButtonsRow(onClick)
            content(isContentVisible)
        }
    }
}

@Composable
private fun BoxToAnimate() {
    Box(
        modifier = Modifier
            .size(height = ScreenLayoutSize.dp100, width = ScreenLayoutSize.dp100)
            .background(COLOR_PURPLE)
    )
}

@Composable
fun CustomButton(
    text: String,
    targetState: Boolean,
    onClick: (Boolean) -> Unit,
    bgColor: Color = COLOR_PURPLE
) {
    Button(
        onClick = { onClick(targetState) },
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = Color.White
        )
    ) {
        Text(text)
    }
}

private val COLOR_PURPLE = Color.hsl(265F, 0.344F, 0.478F)

@Preview
@Composable
private fun JCEChapter43ScreenPreview() {
    JCEChapter43Screen()
}