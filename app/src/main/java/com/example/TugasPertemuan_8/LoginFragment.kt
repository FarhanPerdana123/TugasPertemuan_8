package com.example.TugasPertemuan_8

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.TugasPertemuan_8.R
import com.example.TugasPertemuan_8.databinding.FragmentLoginBinding

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
    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
    }
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnLogin.setOnClickListener {
                val username = etUser.text.toString()
                val password = etPassword.text.toString()

                if (username.isNotEmpty() && password.isNotEmpty()) {
                    val intentToSecondActivity = Intent(activity, Homepage::class.java).apply {
                        putExtra(EXTRA_USERNAME, username)
                        putExtra(EXTRA_PASSWORD, password)
                    }
                    startActivity(intentToSecondActivity)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "Please enter both username and password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            register.setOnClickListener {
                activity?.findViewById<ViewPager2>(R.id.view_pager)?.currentItem = 0 // pindah ke tab register (index 0)
            }
        }
    }
}