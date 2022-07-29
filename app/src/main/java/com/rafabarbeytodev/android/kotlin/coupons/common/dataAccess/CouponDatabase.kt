package com.rafabarbeytodev.android.kotlin.coupons.common.dataAccess

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rafabarbeytodev.android.kotlin.coupons.common.entities.CouponEntity

@Database(entities =[CouponEntity::class], version = 1)
abstract class CouponDatabase : RoomDatabase() {
    abstract fun couponDao() : CouponDao
}