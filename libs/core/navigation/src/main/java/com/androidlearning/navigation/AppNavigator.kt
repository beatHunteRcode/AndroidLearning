package com.androidlearning.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class AppNavigator {
    val navigationFlow: MutableSharedFlow<NavigationIntent> = MutableSharedFlow()

    fun navigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false
    ) {
        CoroutineScope(Dispatchers.Default).launch {
            navigationFlow.emit(NavigationIntent.NavigateTo(
                route = route,
                popUpToRoute = popUpToRoute,
                inclusive = inclusive
            ))
        }
    }
}