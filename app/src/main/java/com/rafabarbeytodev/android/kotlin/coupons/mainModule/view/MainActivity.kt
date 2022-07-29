package com.rafabarbeytodev.android.kotlin.coupons.mainModule.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.rafabarbeytodev.android.kotlin.coupons.R
import androidx.databinding.library.baseAdapters.BR
import com.rafabarbeytodev.android.kotlin.coupons.common.utils.hideKeyboard
import com.rafabarbeytodev.android.kotlin.coupons.databinding.ActivityMainBinding
import com.rafabarbeytodev.android.kotlin.coupons.mainModule.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
        setupObservers()
    }

    private fun setupViewModel() {
        val vm: MainViewModel by viewModels()
        mBinding.lifecycleOwner = this
        mBinding.setVariable(BR.viewModel, vm)
    }

    private fun setupObservers() {
        mBinding.viewModel?.let {

            it.coupon.observe(this) { coupon ->
                mBinding.isActive = coupon != null && coupon.isActive
            }

            it.getSnackbarMsg().observe(this) { msg ->
                Snackbar.make(mBinding.root, msg, Snackbar.LENGTH_SHORT).show()

            }

            it.isHideKeyboard().observe(this) { isHide ->
                if (isHide) hideKeyboard(this, mBinding.root)
            }
        }

    }
}