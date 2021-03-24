package com.rrdev.ppdproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rrdev.ppdproject.databinding.FragmentBoardGameBinding

class BoardGameFragment: Fragment() {

    private lateinit var binding: FragmentBoardGameBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentBoardGameBinding.inflate(inflater, container, false)
        return binding.root
    }


}