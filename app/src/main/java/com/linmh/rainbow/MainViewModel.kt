package com.linmh.rainbow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.linmh.rainbow.data.Repository

class MainViewModel:ViewModel() {
    var tempQuery:String=""
    private var query = MutableLiveData<String>()
    val liveData= Transformations.switchMap(query){
        Repository.query(it)
    }
    fun setquery(string: String){
        query.value=string
    }
}