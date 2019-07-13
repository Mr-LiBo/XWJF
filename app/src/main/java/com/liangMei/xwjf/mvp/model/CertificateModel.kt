package com.liangMei.xwjf.mvp.model

import com.liangMei.xwjf.base.BaseBean
import com.liangMei.xwjf.net.RetrofitManager
import com.liangMei.xwjf.scheduler.SchedulerUtils
import io.reactivex.Observable

class CertificateModel {

    fun requestBankAccount(attribute: String): Observable<BaseBean<Unit>> {
        return RetrofitManager.service.setBankAccount(attribute)
                .compose(SchedulerUtils.ioToMain())
    }

}