package com.rrdev.ppdproject.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.rrdev.ppdproject.adapter.ChatAdapter
import com.rrdev.ppdproject.databinding.FragmentChatBinding
import com.rrdev.ppdproject.extensions.dimensDrawableEnd
import com.rrdev.ppdproject.extensions.extractText
import com.rrdev.ppdproject.extensions.scrollToLastPosition
import com.rrdev.ppdproject.viewmodel.SocketViewModel
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ChatFragment: Fragment() {

    private val adapter = ChatAdapter()
    private lateinit var binding: FragmentChatBinding
    private val viewModel: SocketViewModel by sharedViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        addObserver()
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun setupView(){
        binding.recyclerChat.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)
        binding.recyclerChat.adapter = adapter
        binding.editInput.setOnTouchListener { _, event ->
            if(event.action == MotionEvent.ACTION_UP) {
                if(event.rawX >= binding.editInput.dimensDrawableEnd()) {
                    // your action here
                    viewModel.sendMessageToChat(binding.editInput.extractText())
                    return@setOnTouchListener true
                }
            }
            return@setOnTouchListener false
        }
    }

    private fun addObserver(){
        lifecycleScope.launchWhenCreated {
            viewModel.chatState.collect { message ->
                adapter.addMessage(message)
                binding.recyclerChat.scrollToLastPosition()
            }
        }
    }

}
