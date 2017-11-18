package com.zxy.yilunyasha.wechatlock.Lock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.leo.gesturelibray.enums.LockMode
import com.leo.gesturelibray.view.CustomLockView
import com.zxy.yilunyasha.wechatlock.Contants
import com.zxy.yilunyasha.wechatlock.R
import kotlinx.android.synthetic.main.activity_pic_lock.*
import org.jetbrains.anko.toast

class PicLockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic_lock)

        initView()
    }

    private fun initView() {
        guide_text1.text = "绘制解图案,请至少连接四个点"
        guide_text2.text = "请牢记您的密码,忘记后无法找回"

        supportActionBar!!.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            title = "选择您的图案"
        }

        lv_lock.apply {
            //显示绘制方向
            isShow = true
            // 密码最少位数
            passwordMinLength = 4
            // 保存密码到本地
            isSavePin = true
            // 保存密码Key
            saveLockKey = Contants.PASS_KEY
            // 设置模式
            mode = LockMode.SETTING_PASSWORD
            setOnCompleteListener(object : CustomLockView.OnCompleteListener {
                /**
                 * 两次输入密码不一致
                 */
                override fun onEnteredPasswordsDiffer() {
                    guide_text1.text = "两次绘制的图案不一致,请重试"
                }

                /**
                 * 画完了
                 */
                override fun onComplete(password: String?, indexs: IntArray?) {
                    toast("设置成功$password")
                    finish()
                }

                /**
                 * 设置密码再次输入密码
                 */
                override fun onAginInputPassword(mode: LockMode?, password: String?, indexs: IntArray?) {
                    guide_text1.text = "再次绘制图案进行确认"

                }

                /**
                 * 修改密码，输入新密码
                 */
                override fun onInputNewPassword() {
                }

                /**
                 * 密码太短
                 */
                override fun onPasswordIsShort(passwordMinLength: Int) {
                        guide_text1.text = "至少需要连接四个点,请重试"
                }

                /**
                 * 绘制错误
                 */
                override fun onError(errorTimes: String?) {
                }

                /**
                 * 密码输入错误次数，已达到设置次数
                 */
                override fun onErrorNumberMany() {
                }
            })
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
