package com.androidlearning.screens.kotlinlearning.designpatterns.builder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.androidlearning.arch.CoreComposeScreen
import com.androidlearning.arch.EventTrigger
import com.androidlearning.patterns.builder.Creature
import com.androidlearning.uikit.ScreenLayoutSize
import com.androidlearning.uikit.fillMaxWidthWithEdgeOffset

/**
 * Reference - [Строитель. RefactoringGuru.](https://refactoringguru.cn/ru/design-patterns/builder)
 */
@Composable
internal fun BuilderPatternScreen(viewModel: BuilderPatternScreenViewModel) {
    CoreComposeScreen(viewModel = viewModel) { state, onEvent ->
        Screen(
            screenState = state,
            onEvent = onEvent
        )
    }
}

@Composable
private fun Screen(
    screenState: State<BuilderPatternScreenState>,
    onEvent: EventTrigger<BuilderPatternScreenEvents>
) {
    val state = screenState.value

    LazyColumn(
        modifier = Modifier.fillMaxWidthWithEdgeOffset()
    ) {
        state.creatures.forEach { creature ->
            item {
                ItemBlock {
                    Creature(creature)
                }
            }
        }
        if (state.isCreating) {
            item {
                ItemBlock {
                    CreatureSettingsBlock(onEvent)
                }
            }
        } else {
            item {
                ItemBlock {
                    AddCreature(onEvent)
                }
            }
        }
    }
}

@Composable
private fun ItemBlock(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidthWithEdgeOffset()
            .padding(vertical = ScreenLayoutSize.dp16)
            .background(
                color = Color.DarkGray,
                shape = RoundedCornerShape(corner = CornerSize(ScreenLayoutSize.dp48))
            )
            .padding(vertical = ScreenLayoutSize.dp16)
    ) {
        content()
    }
}

@Composable
private fun Creature(creature: Creature) {
    Column(
        modifier = Modifier.fillMaxWidthWithEdgeOffset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(ScreenLayoutSize.dp16),
            text = creature.name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            modifier = Modifier.padding(vertical = ScreenLayoutSize.dp4),
            text = "Age: ${creature.age}",
            fontSize = 15.sp,
            color = Color.White
        )
        Text(
            modifier = Modifier.padding(vertical = ScreenLayoutSize.dp4),
            text = "Arms: ${creature.arms}",
            fontSize = 15.sp,
            color = Color.White
        )
        Text(
            modifier = Modifier.padding(vertical = ScreenLayoutSize.dp4),
            text = "Legs: ${creature.legs}",
            fontSize = 15.sp,
            color = Color.White
        )
        Text(
            modifier = Modifier.padding(vertical = ScreenLayoutSize.dp4),
            text = "Voice: ${creature.voice}",
            fontSize = 15.sp,
            color = Color.White
        )
    }
}

@Composable
private fun AddCreature(onEvent: EventTrigger<BuilderPatternScreenEvents>) {
    Column(
        modifier = Modifier.fillMaxWidthWithEdgeOffset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.padding(ScreenLayoutSize.dp16),
            onClick = {
                onEvent(BuilderPatternScreenEvents.StartCreatingCreature)
            }
        ) {
            Text(
                modifier = Modifier.padding(ScreenLayoutSize.dp8),
                text = "Add Creature",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
private fun CreatureSettingsBlock(onEvent: EventTrigger<BuilderPatternScreenEvents>) {
    Column(
        modifier = Modifier.fillMaxWidthWithEdgeOffset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CreatureSettingTemplate(
            label = "Name",
            onButtonClick = { name ->
                onEvent(BuilderPatternScreenEvents.AddName(name))
            }
        )
        CreatureSettingTemplate(
            label = "Age",
            onButtonClick = { age ->
                onEvent(BuilderPatternScreenEvents.AddAge(age.toInt()))
            }
        )
        CreatureSettingTemplate(
            label = "Arms",
            onButtonClick = { arms ->
                onEvent(BuilderPatternScreenEvents.AddArms(arms.toInt()))
            }
        )
        CreatureSettingTemplate(
            label = "Legs",
            onButtonClick = { legs ->
                onEvent(BuilderPatternScreenEvents.AddLegs(legs.toInt()))
            }
        )
        CreatureSettingTemplate(
            label = "Voice",
            onButtonClick = { voice ->
                onEvent(BuilderPatternScreenEvents.AddVoice(voice))
            }
        )
        Spacer(modifier = Modifier.height(ScreenLayoutSize.dp8))
        Button(onClick = { onEvent(BuilderPatternScreenEvents.BuildCreature) }) {
            Text(text = "Build")
        }
    }
}

@Composable
private fun CreatureSettingTemplate(
    label: String,
    onButtonClick: (name: String) -> Unit
) {
    Row {
        var inputValue by remember { mutableStateOf("") }

        TextField(
            value = inputValue,
            onValueChange = { newValue ->
                inputValue = newValue
            },
            label = {
                Label(label)
            }
        )
        Spacer(modifier = Modifier.width(ScreenLayoutSize.dp16))
        Button(onClick = {
            onButtonClick(inputValue)
            inputValue = ""
        }) {
            Text(text = "Add")
        }
    }
}

@Composable
private fun Label(text: String) {
    Text(text = text)
}