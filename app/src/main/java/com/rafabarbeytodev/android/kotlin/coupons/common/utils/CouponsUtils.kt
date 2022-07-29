package com.rafabarbeytodev.android.kotlin.coupons.common.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.rafabarbeytodev.android.kotlin.coupons.R

fun validateTextCode(code:String):Boolean{
    return (code.length in 6..9)
}

fun getMsgErrorByCode(errorCode:String?): Int = when(errorCode){
    Constants.ERROR_EXIST -> R.string.error_unique_code
    Constants.ERROR_LENGTH -> R.string.error_invalid_length
    else -> R.string.error_unknow
}

fun hideKeyboard(context: Context, view: View){
    val im = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    im?.hideSoftInputFromWindow(view.windowToken, 0)
}
