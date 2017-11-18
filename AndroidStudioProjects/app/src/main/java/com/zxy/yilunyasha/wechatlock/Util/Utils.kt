package com.zxy.yilunyasha.wechatlock.Util

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by YILUNYASHA on 2017/11/17.
 * SharedPreference 方法封装
 */

// 获得SharedPreference对象
fun Context.getDefaultSharedPreference() = getSharedPreferences("", Context.MODE_PRIVATE)

fun SharedPreferences.Editor.addString(key:String,value:String){
    this.apply {
        putString(key,value)
        commit()
    }
}