package com.linmh.rainbow.data

import java.security.MessageDigest
import java.util.*
//提供请求信息
object RequestInfo {
    val date = Date()
    val time = date.time
    var md5 = MessageDigest.getInstance("MD5")
    fun getSalt() = ""+ time+"4"
    fun getUa() = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36"

    fun getTs() = time
    fun getBv() = gethex(md5.digest(getUa().toByteArray())).toString()
    fun getSign(str:String): String {
        val string = "fanyideskweb" + str + getSalt() + "Nw(nmmbP%A-r6U3EUn]Aj"
        return gethex(md5.digest(string.toByteArray())).toString()
    }
    fun getCookie()="OUTFOX_SEARCH_USER_ID=1474458966@10.169.0.102; JSESSIONID=aaaKVlv4kCidg5fNvLaex; OUTFOX_SEARCH_USER_ID_NCOO=1264177066.6226926; ___rl__test__cookies=1584852732402"


}