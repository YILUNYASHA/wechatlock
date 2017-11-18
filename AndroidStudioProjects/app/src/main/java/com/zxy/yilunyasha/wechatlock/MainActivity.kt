package com.zxy.yilunyasha.wechatlock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AlphaAnimation
import com.zxy.yilunyasha.wechatlock.Lock.MixLockActivity
import com.zxy.yilunyasha.wechatlock.Lock.PicLockActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val ALPHAANIMATION_DURATION: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startAnimation()
        setListener()
    }

    private fun setListener() {
        pic_lock.setOnClickListener(this)
        mix_lock.setOnClickListener(this)
    }

    private fun startAnimation() {
        pic_lock.setShowAnimation(ALPHAANIMATION_DURATION)
        mix_lock.setShowAnimation(ALPHAANIMATION_DURATION)
    }


    private fun View.setShowAnimation(duration: Long) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = duration
        animation.fillAfter = true
        this.startAnimation(animation)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.pic_lock -> {
                startActivity<PicLockActivity>()
            }
            R.id.mix_lock -> {
                startActivity<MixLockActivity>()
            }
            else -> {
            }
        }
    }

}


