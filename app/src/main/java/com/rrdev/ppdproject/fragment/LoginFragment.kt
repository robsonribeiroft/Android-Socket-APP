package com.rrdev.ppdproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rrdev.ppdproject.databinding.FragmentLoginBinding
import com.rrdev.ppdproject.extensions.extractText
import com.rrdev.ppdproject.viewmodel.SocketViewModel
import io.socket.client.IO
import io.socket.client.Socket
import org.koin.android.viewmodel.ext.android.sharedViewModel

class LoginFragment : Fragment() {

    private val viewModel: SocketViewModel by sharedViewModel()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mSocket = IO.socket("http://192.168.0.32:3000")
        mSocket.on(Socket.EVENT_CONNECT, { println("connected") })

        binding.buttonEnterChatRoom.setOnClickListener {
            viewModel.userName = binding.textSelectName.extractText()

            mSocket.connect()
            mSocket.emit("mayaCommand", "cmds.polyCube()")
            println("ok")

           // viewModel.init()
            //findNavController().navi  gate(LoginFragmentDirections.actionLoginFragmentToChatFragment())

        }
    }
}