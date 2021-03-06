/*
 * Copyright (c) DAR Ecosystem 2018.
 *
 * Created by sough on 14/08/2018.
 */

package com.example.miras.magazine.core.util
import android.util.Log

/**
 * Handle Logging in app
 */
object Logger {

    fun msg(tag: String, msg: Any?) {
        Log.i(tag, "$msg")
    }

    fun msg(msg: Any?) {
        msg("MSG", "$msg")
    }

    fun api(msg: String?) {
        msg("API", "$msg")
    }

    fun test(whereRYouTesting: String?, msg: String?){
        msg("accepted", "$whereRYouTesting : $msg")
    }
}