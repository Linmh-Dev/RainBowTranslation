package com.linmh.rainbow.data

import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

object OkHttpQuery {
    suspend fun query(str:String):ResultData{
        val okHttpClient = OkHttpClient()
        val requestBody: RequestBody = FormBody.Builder()
            .add("i", str)
            .add("client", "fanyideskweb")
            .add("from", "AUTO")
            .add("to", "AUTO")
            .add("smartresult", "dict")
            .add("doctype", "json")
            .add("version", "2.1")
            .add("keyfrom", "fanyi.web")
            .add("action", "FY_BY_REALTlME")
            .add("salt", RequestInfo.getSalt())
            .add("sign", RequestInfo.getSign(str))
            .add("ts", RequestInfo.getTs().toString())
            .add("bv", RequestInfo.getBv())
            .build()
        val request: Request = Request.Builder().url("http://fanyi.youdao.com/translate_o?smartresult=dict&smartresult=rule")
            .post(requestBody)
            .header(
                "Cookie",
                "OUTFOX_SEARCH_USER_ID=1474458966@10.169.0.102; JSESSIONID=aaaKVlv4kCidg5fNvLaex; OUTFOX_SEARCH_USER_ID_NCOO=1264177066.6226926; ___rl__test__cookies=1584852732402"
            )
            .header("Referer", "http://fanyi.youdao.com/")
            .header("User-Agent", RequestInfo.getUa())
            .build()
        val execute = okHttpClient.newCall(request).execute()
        val gson= Gson()
        return gson.fromJson(execute.body().string(),ResultData::class.java)
    }
}