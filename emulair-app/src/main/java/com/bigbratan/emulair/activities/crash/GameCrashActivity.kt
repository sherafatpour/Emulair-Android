package com.bigbratan.emulair.activities.crash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.isVisible
import com.bigbratan.emulair.R
import com.bigbratan.emulair.activities.BaseThemedActivity

class GameCrashActivity : BaseThemedActivity() {

    override fun getActivityName(): String {
        return "GameCrashActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crash)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val messageDetail = intent.getStringExtra(EXTRA_MESSAGE_DETAIL)

        findViewById<TextView>(R.id.text1).apply {
            isVisible = !message.isNullOrEmpty()
            text = message
        }

        findViewById<TextView>(R.id.text2).apply {
            isVisible = !messageDetail.isNullOrEmpty()
            text = messageDetail
        }
    }

    companion object {
        private const val EXTRA_MESSAGE = "EXTRA_MESSAGE"
        private const val EXTRA_MESSAGE_DETAIL = "EXTRA_MESSAGE_DETAIL"

        fun launch(activity: Activity, message: String, messageDetail: String?) {
            val intent = Intent(activity, GameCrashActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
                putExtra(EXTRA_MESSAGE_DETAIL, messageDetail)
            }
            activity.startActivity(intent)
        }
    }
}
