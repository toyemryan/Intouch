package com.diegusmich.intouch.ui.auth.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.diegusmich.intouch.R
import com.diegusmich.intouch.databinding.FragmentAuthIntroBinding


class IntroFragment : Fragment() {

    private lateinit var _binding : FragmentAuthIntroBinding
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAuthIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            activity?.findNavController(R.id.nav_host_fragment_auth)?.navigate(R.id.action_Intro_to_SignIn)
        }
    }
}