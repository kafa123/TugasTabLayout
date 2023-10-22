package com.example.tugastablayout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.tugastablayout.databinding.FragmentRegisterBinding
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    // TODO: Rename and change types of parameters
    private var Username: String? = null
    private var Password: String? = null
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferencesHelper = SharedPreferencesHelper(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentRegisterBinding.inflate(layoutInflater)


        arguments?.let {
            Username = it.getString(R.id.text_username.toString())
            Password = it.getString(R.id.text_username.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflater=inflater.inflate(R.layout.fragment_register, container, false)
        val register=inflater.findViewById<Button>(R.id.register)
        val username=inflater.findViewById<TextInputEditText>(R.id.text_username)
        val password=inflater.findViewById<TextInputEditText>(R.id.text_password)


         with(binding){
            register.setOnClickListener {
                val intent = Intent(/* packageContext = */ activity,/* cls = */ MainActivity2::class.java)
                val sharedPreferencesHelper = SharedPreferencesHelper(requireContext())
                sharedPreferencesHelper.saveCredentials(username.text.toString(), password.text.toString())
                startActivity(intent)
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
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}