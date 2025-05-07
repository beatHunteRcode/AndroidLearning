package com.androidlearning.patterns.adapter

import androidx.compose.runtime.Composable

/**
 * Адаптер (обёртка, wrapper) позволяющий создать объект Compose-функциями в любом месте
 * без compose-контекста, чтобы затем достать эту compose-функцию в compose-контексте
 *
 * @param composeItem Compose-функция, которую можно отрисовать в compose-контексте с помощью метода [get]
 */
class ComposeItemAdapter<T>(
    private val composeItem: @Composable () -> T
) {

    @Composable
    fun get() = composeItem.invoke()

}