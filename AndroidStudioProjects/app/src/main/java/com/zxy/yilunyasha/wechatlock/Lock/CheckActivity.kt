package com.zxy.yilunyasha.wechatlock.Lock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zxy.yilunyasha.wechatlock.Contants
import com.zxy.yilunyasha.wechatlock.MainActivity
import com.zxy.yilunyasha.wechatlock.R
import com.zxy.yilunyasha.wechatlock.Util.getDefaultSharedPreference
import kotlinx.android.synthetic.main.activity_check.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by YILUNYASHA on 2017/11/17.
 */
class CheckActivity : AppCompatActivity() {

    private lateinit var mixPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isOpenMainActivity()
        setContentView(R.layout.activity_check)

        initView()
    }

    private fun initView() {


        btn_sure.setOnClickListener {
            val password = edt_password.text.toString()
            when {
                password == mixPassword -> {
                    startActivity<MainActivity>()
                    finish()
                }
                password.isEmpty() -> toast("请输入密码")
                else -> toast("密码错误,请重新输入")
            }
        }
    }

    // 检查混合密码是否存在 不存在关闭此Activity
    private fun isOpenMainActivity() {
        // 混合密码
        mixPassword = this.getDefaultSharedPreference().getString(Contants.MIX_PASSWORD, "")
        if (mixPassword == "") {
            startActivity<MainActivity>()
            finish()
        }
    }
}