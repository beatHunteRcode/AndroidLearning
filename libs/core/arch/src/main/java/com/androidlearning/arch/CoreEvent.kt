package com.androidlearning.arch

import kotlin.reflect.KFunction1

interface CoreEvent

typealias EventTrigger<T> = KFunction1<T, Unit>