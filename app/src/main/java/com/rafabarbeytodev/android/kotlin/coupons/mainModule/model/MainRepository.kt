package com.rafabarbeytodev.android.kotlin.coupons.mainModule.model

import com.rafabarbeytodev.android.kotlin.coupons.common.entities.CouponEntity
import com.rafabarbeytodev.android.kotlin.coupons.common.utils.Constants
import com.rafabarbeytodev.android.kotlin.coupons.common.utils.validateTextCode
import java.lang.Exception

class MainRepository {
    private val roomDatabase = RoomDatabase()

    suspend fun consultCouponByCode(code:String) = roomDatabase.consultCouponByCode(code)

    suspend fun saveCoupon(couponEntity: CouponEntity){
        if(validateTextCode(couponEntity.code)){
            roomDatabase.saveCoupon(couponEntity)
        }else{
            throw Exception(Constants.ERROR_LENGTH)
        }
    }

}