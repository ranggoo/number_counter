package com.example.numberCounter.util

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.view.WindowManager
import androidx.core.view.WindowCompat

object ActivityUtil {

    /**
     * stateBar, navigationBar 투명도 삽입
     */
    fun Activity.setStatusBarTransparent() {
        window.apply {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        if (Build.VERSION.SDK_INT >= 30) {    // API 30 에 적용
            WindowCompat.setDecorFitsSystemWindows(window, false)
        }
    }

    /**
     * 액티비티 네비게이터.
     *
     */
    inline fun <reified T : Activity> Activity.goStartActivity(block: (Intent) -> Unit) =
        Intent(this, T::class.java)
            .apply {
                block(this)
            }
            .let(::startActivity)
            .also {
                finish()
            }


}