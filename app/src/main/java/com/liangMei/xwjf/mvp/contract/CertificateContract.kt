package com.liangMei.xwjf.mvp.contract

import com.liangMei.xwjf.base.IBaseView
import com.liangMei.xwjf.base.IPresenter


interface CertificateContract {
    interface View : IBaseView {

        fun showError(msg: String, errorCode: Int)
    }

    interface Presenter : IPresenter<View> {

        fun requestBankAccount(attribute: String)
    }
}