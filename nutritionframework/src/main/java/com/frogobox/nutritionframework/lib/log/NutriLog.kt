package com.frogobox.nutritionframework.lib.log

import android.content.Context
import android.util.Log
import android.widget.Toast

/*
 * Created by Faisal Amir on 14/01/2021
 * LogCat Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
object NutriLog : INutriLog {

    // Constant Variable Simple Message
    const val SIMPLE_MESSSAGE = "SIMPLE DEBUG FOR MARK LINE OF CODE"

    // Tag for get class name this function
    private fun tag() : String {
        return this.javaClass.simpleName
    }

    // Function for get line number of code
    private fun lineNumber(): String {
        return Thread.currentThread().stackTrace[4].let {
            "${it.className.substringAfterLast(".")}.${it.methodName}(${it.fileName}:${it.lineNumber})"
        }
    }

    // Function Log Simple Debug without message params
    override fun d(){
        Log.d(tag(), "${lineNumber()}: $SIMPLE_MESSSAGE")
    }

    // Function Log Debug
    override fun d(msg: String?) {
        Log.d(tag(), "${lineNumber()}: $msg")
    }

    // Function Log Verbose
    override fun v(msg: String?) {
        Log.v(tag(), "${lineNumber()}: $msg")
    }

    // Function Log Info
    override fun i(msg: String?) {
        Log.i(tag(), "${lineNumber()}: $msg")
    }

    // Function Log Warn
    override fun w(msg: String?) {
        Log.w(tag(), "${lineNumber()}: $msg")
    }

    // Function Log Warn
    override fun w(e: Throwable?) {
        Log.w(tag(), "${lineNumber()}: ${e?.localizedMessage}")
    }

    // Function Log Warn
    override fun w(e: Exception?) {
        Log.w(tag(), "${lineNumber()}: ${e?.localizedMessage}")
    }

    // Function Log Error
    override fun e(msg: String?) {
        Log.e(tag(), "${lineNumber()}: $msg")
    }

    // ---------------------------------------------------------------------------------------------

    // Function Log Simple Debug without message params
    override fun d(context: Context) {
        Log.d(tag(), SIMPLE_MESSSAGE)
        Toast.makeText(context, SIMPLE_MESSSAGE, Toast.LENGTH_LONG).show()
    }

    // Function Log Debug
    override fun d(msg: String?, context: Context) {
        Log.d(tag(), "${lineNumber()}: $msg")
        Toast.makeText(context, "${lineNumber()}: $msg", Toast.LENGTH_LONG).show()
    }

    // Function Log Verbose
    override fun v(msg: String?, context: Context) {
        Log.v(tag(), "${lineNumber()}: $msg")
        Toast.makeText(context, "${lineNumber()}: $msg", Toast.LENGTH_LONG).show()
    }

    // Function Log Info
    override fun i(msg: String?, context: Context) {
        Log.i(tag(), "${lineNumber()}: $msg")
        Toast.makeText(context, "${lineNumber()}: $msg", Toast.LENGTH_LONG).show()
    }

    // Function Log Warn
    override fun w(msg: String?, context: Context) {
        Log.w(tag(), "${lineNumber()}: $msg")
        Toast.makeText(context, "${lineNumber()}: $msg", Toast.LENGTH_LONG).show()
    }

    // Function Log Warn
    override fun w(e: Exception?, context: Context) {
        Log.w(tag(), "${lineNumber()}: ${e?.localizedMessage}")
        Toast.makeText(context, "${lineNumber()}: ${e?.localizedMessage}", Toast.LENGTH_LONG).show()
    }

    // Function Log Warn
    override fun w(e: Throwable?, context: Context) {
        Log.w(tag(), "${lineNumber()}: ${e?.localizedMessage}")
        Toast.makeText(context, "${lineNumber()}: ${e?.localizedMessage}", Toast.LENGTH_LONG).show()
    }

    // Function Log Error
    override fun e(msg: String?, context: Context) {
        Log.e(tag(), "${lineNumber()}: $msg")
        Toast.makeText(context, "${lineNumber()}: $msg", Toast.LENGTH_LONG).show()
    }

}