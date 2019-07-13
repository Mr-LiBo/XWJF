package com.liangMei.xwjf.base

interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}