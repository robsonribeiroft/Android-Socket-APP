package com.rrdev.ppdproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rrdev.ppdproject.databinding.FragmentLoginBinding
import com.rrdev.ppdproject.extensions.extractText
import com.rrdev.ppdproject.viewmodel.SocketViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class LoginFragment: Fragment(){

    private val viewModel: SocketViewModel by sharedViewModel()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonEnterChatRoom.setOnClickListener {
            viewModel.userName = binding.textSelectName.extractText()
            viewModel.connectSocket()
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToChatFragment())
        }

    }
}