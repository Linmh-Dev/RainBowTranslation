package com.linmh.rainbow.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

object Repository {
    fun query(string: String) = liveData(Dispatchers.IO) {
        val data=try {
            val resultService = OkHttpQuery.query(string)
           // if (resultService.errorCode==0){
                Result.success(resultService)
          /*  }
            else{
                Result.failure<ResultData>(Exception("网络错误"))
            }*/
        }catch (e:Exception){
            Result.failure<ResultData>(Exception("网络错误"))
        }

        emit(data)
    }
}