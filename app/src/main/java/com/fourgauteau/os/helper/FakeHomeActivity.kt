package com.fourgauteau.os.helper

import android.app.Activity
import android.os.Bundle

class FakeHomeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    }
}
