package com.androidlearning.patterns.abstractfactory

interface AFDialogFactory<T> {
    fun getText(): AFText
    fun getButton(): AFButton<T>
    fun getBackgroundColor(): AFBackgroundColor
}