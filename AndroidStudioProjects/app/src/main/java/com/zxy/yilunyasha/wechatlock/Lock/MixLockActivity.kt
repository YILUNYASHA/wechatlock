package com.zxy.yilunyasha.wechatlock.Lock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.zxy.yilunyasha.wechatlock.Contants
import com.zxy.yilunyasha.wechatlock.R
import com.zxy.yilunyasha.wechatlock.Util.addString
import com.zxy.yilunyasha.wechatlock.Util.getDefaultSharedPreference
import kotlinx.android.synthetic.main.activity_mix_lock.*
import org.jetbrains.anko.toast

class MixLockActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mix_lock)

        init()
    }

    private fun init() {
        // 给密码输入框设置监听事件
        edt_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                btn_sure.isEnabled = s!!.length in 4..17
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btn_sure.isEnabled = s!!.length in 4..17
            }
        })

        // 是否是首次点击
        var isFirstClick = true
        // 首次输入的内容
        var firstPassword: String? = null

        btn_sure.setOnClickListener {
            guide_text.text = "再次输入密码"
            btn_sure.text = "完成"

            // 判断按钮是不是第一次点击
            if (isFirstClick) {
                firstPassword = edt_password.text.toString()
                isFirstClick = false
                edt_password.setText("")
                return@setOnClickListener
            }
            val secondPassword = edt_password.text.toString()
            // 判断两次输入的密码是否相等
            if (secondPassword == firstPassword!!) {
                // 将密码保存到本地文件中
                val sp = this.getDefaultSharedPreference()
                sp.edit().addString(Contants.MIX_PASSWORD, secondPassword)


                finish()
            } else {
                toast("两次输入的密码不一致,请重新输入")
            }
        }
    }
}
