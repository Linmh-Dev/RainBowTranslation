package com.linmh.rainbow.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.linmh.rainbow.MainViewModel
import com.linmh.rainbow.R
import kotlinx.android.synthetic.main.fragment_detail.*
import java.lang.Exception


class DetailFragment : Fragment() {

    val viewmodel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this?.activity?.let {
            viewmodel.liveData.observe(it, Observer {
                try {
                    val aaa = it.getOrNull()?.translateResult?.get(0)?.get(0)?.tgt.toString()
                    if (it.isFailure) {
                        maintext.text = "网络出问题了"
                        secondtext.visibility = View.GONE
                    } else {
                        if (aaa.equals(viewmodel.tempQuery) || aaa.equals("null")) {
                            maintext.text = "抱歉，我还在学习该语种中"
                            secondtext.visibility = View.GONE
                        } else {
                            maintext.text = aaa
                            secondtext.visibility = View.VISIBLE
                        }

                        val ss = it.getOrNull()?.smartResult?.entries
                        var aa = ""
                        for (i in ss!!) {
                            aa = aa.plus(i)
                        }
                        if (aa.length > 2)
                            secondtext.text = aa

                    }

                } catch (e: Exception) {
                    Log.e("lin", "error: " + e.printStackTrace())
                }


            })
        }

    }

    override fun onResume() {
        super.onResume()
        maintext.hint = "查询中..."
        secondtext.text = ""
        viewmodel.setquery(viewmodel.tempQuery)
    }
}