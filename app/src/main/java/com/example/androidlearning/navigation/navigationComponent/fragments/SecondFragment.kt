package com.example.androidlearning.navigation.navigationComponent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.compose.content
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidlearning.navigation.navigationComponent.ui.SecondFragmentContent

class SecondFragment : Fragment() {

    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = content {
        SecondFragmentContent(
            navController = findNavController(),
            inputText = args.inputText
        )
    }

}