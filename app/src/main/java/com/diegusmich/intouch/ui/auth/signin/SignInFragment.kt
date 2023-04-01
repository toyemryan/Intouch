package com.diegusmich.intouch.ui.auth.signin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.diegusmich.intouch.MainActivity
import com.diegusmich.intouch.databinding.FragmentAuthSigninBinding
import com.google.android.material.snackbar.Snackbar

class SignInFragment : Fragment() {

    private var _binding: FragmentAuthSigninBinding? = null
    private var signInViewModel: SignInViewModel? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        signInViewModel = ViewModelProvider(this)[SignInViewModel::class.java]
        _binding = FragmentAuthSigninBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginActionBtn.addOnActionClickListener{

            val email = binding.emailTextField.text.toString()
            val pwd = binding.passwordTextField.text.toString()

            if(email.isNullOrEmpty() || pwd.isNullOrEmpty()){
                binding.emailTextField.error = "Campo vuoto"
                return@addOnActionClickListener
            }

            signInViewModel?.performLogin(this.requireActivity(), email, pwd) { res, ex ->

                if (ex != null)
                    Snackbar.make(binding.root, ex.message.toString(), Toast.LENGTH_SHORT).show()
                else if (res?.user != null) {
                    this.startActivity(Intent(this.requireContext(), MainActivity::class.java))
                    this.requireActivity().finish()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}