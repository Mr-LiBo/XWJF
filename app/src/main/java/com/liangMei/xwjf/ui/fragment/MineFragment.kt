package com.liangMei.xwjf.ui.fragment

import com.liangMei.xwjf.MyApplication
import com.liangMei.xwjf.R
import com.liangMei.xwjf.base.BaseFragment
import com.liangMei.xwjf.utils.StatusBarUtil
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseFragment() {


    companion object {
        fun getInstance(): MineFragment {
            return MineFragment()
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_mine

    override fun initView() {
        mine_ly.setPadding(0, StatusBarUtil.getStatusBarHeight(MyApplication.context), 0, StatusBarUtil.getStatusBarHeight(MyApplication.context))

    }

    override fun lazyLoad() {
    }

    override fun initEvent() {

    }
}