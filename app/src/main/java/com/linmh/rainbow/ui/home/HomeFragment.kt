package com.linmh.rainbow.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import androidx.navigation.fragment.findNavController
import com.linmh.rainbow.MainViewModel
import com.linmh.rainbow.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    val viewmodel:MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchview.setIconifiedByDefault(false)
        searchview.setSubmitButtonEnabled(true)
        searchview.queryHint = "输入翻译内容..."
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.e("lin", query.toString())
                    viewmodel.tempQuery= query.toString()
                    findNavController().navigate(R.id.action_navigation_home_to_blankFragment)
               closeInput()
                return true

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    constraint.setOnClickListener { closeInput() }
    }
    private fun closeInput(){
        val inputMethod =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethod.hideSoftInputFromWindow(requireActivity().window.decorView.windowToken,0)
    }
}