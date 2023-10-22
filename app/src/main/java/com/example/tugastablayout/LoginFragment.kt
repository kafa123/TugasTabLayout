package com.example.tugastablayout

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.tugastablayout.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferencesHelper = SharedPreferencesHelper(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=FragmentLoginBinding.inflate(layoutInflater)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private fun authenticate(username: String, password: String): Boolean {
        return username==sharedPreferencesHelper.getUsername() && password==sharedPreferencesHelper.getPassword()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflater= inflater.inflate(R.layout.fragment_login, container, false)
        val login=inflater.findViewById<Button>(R.id.login)
        val username=inflater.findViewById<TextInputEditText>(R.id.text_username)
        val password=inflater.findViewById<TextInputEditText>(R.id.text_password)

        with(binding){
            login.setOnClickListener {
                val username=username.text.toString()
                val password=password.text.toString()

                val isAuthenticated = authenticate(username,password)

                if(isAuthenticated){
                    val intent = Intent(activity,MainActivity2::class.java)
                    startActivity(intent)
                }
                else{
                    inflater.findViewById<TextInputEditText>(R.id.text_password).error="invalid username or password"
                }
            }
        }
        return inflater
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}