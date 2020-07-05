package com.linmh.rainbow.data
//返回json数据实体类
data class ResultData(val translateResult:List<List<translate>>,val errorCode:Int,val type:String,val smartResult:smart)
data class smart(val entries:List<String>, val type:Int)
data class translate(val tgt:String,val src:String)