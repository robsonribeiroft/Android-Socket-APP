package com.rrdev.ppdproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rrdev.ppdproject.databinding.AdapterItemChatBinding
import com.rrdev.ppdproject.model.ChatMessage

class ChatAdapter: RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    private var listItems = mutableListOf<ChatMessage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterItemChatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int = listItems.size

    fun addMessage(message: ChatMessage){
        listItems.add(message)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: AdapterItemChatBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(message: ChatMessage){
            binding.textMessage.text = message.formatToChat()
        }
    }
}