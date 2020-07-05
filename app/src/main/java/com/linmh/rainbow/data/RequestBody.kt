package com.linmh.rainbow.data
//发送请求的请求体
data class RequestBod(var i:String,var salt:String,var sign:String,var ts:Long,var bv:String){
    var from="AUTO"
    var to="AUTO"
    var smartresult="dict"
    var client="fanyideskweb"
    var doctype = "json"
    var version=2.1
    var keyfrom="fanyi.web"
    var action="FY_BY_REALTlME"
}