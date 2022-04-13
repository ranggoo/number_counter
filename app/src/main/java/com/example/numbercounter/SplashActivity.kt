package com.example.numbercounter

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.numbercounter.databinding.ActivitySplashBinding
import com.example.numbercounter.util.ActivityUtil.goStartActivity
import com.example.numbercounter.util.ActivityUtil.setStatusBarTransparent
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null

    private val binding get() = _binding!!

    lateinit var fadeInAnim: Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarTransparent()
        customAnimators()
        delayedMove(2500)

        // appName 애니메이션 작동
        fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.appName.startAnimation(fadeInAnim)

    }

    // lottieAnim 커스텀
    // 0f -> 0%, 1f -> 100%, ofFloat(시작,끝), setDuration(지속시간)
    // 지금은 autoPlay true 상태이므로 계속 실행됨
    private fun customAnimators(){
        val animator = ValueAnimator.ofFloat(0f,0.4f).setDuration(0)
        animator.addUpdateListener {
            binding.lottieAnim.progress = it.animatedValue as Float
        }
        animator.start()
    }

    // 액티비티 화면 이동 시 화면 유지? 시간
    private fun delayedMove(delayMills:Int){
        Handler(Looper.getMainLooper()).postDelayed({
            goStartActivity<MainActivity> {  }
        },delayMills.toLong())
    }




}