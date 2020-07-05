package com.linmh.rainbow.data
//处理token验证
public fun gethex(bytes: ByteArray): String? {
    val hexValue = StringBuffer()
    for (i in bytes.indices) {
        val `val` = bytes[i].toInt() and 0xff
        if (`val` < 16) hexValue.append("0")
        hexValue.append(Integer.toHexString(`val`))
    }
    return hexValue.toString()
}
