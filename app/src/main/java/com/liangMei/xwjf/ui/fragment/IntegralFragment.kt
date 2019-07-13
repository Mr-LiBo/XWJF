package com.liangMei.xwjf.ui.fragment

import android.support.v7.widget.GridLayoutManager
import com.liangMei.xwjf.MyApplication
import com.liangMei.xwjf.R
import com.liangMei.xwjf.base.BaseFragment
import com.liangMei.xwjf.ui.adapter.IntegralGoodsAdapter
import com.liangMei.xwjf.utils.StatusBarUtil
import kotlinx.android.synthetic.main.fragment_integral.*
import kotlinx.android.synthetic.main.fragment_integral.rightLayout
import kotlinx.android.synthetic.main.fragment_integral.titleName


class IntegralFragment : BaseFragment() {


    companion object {
        fun getInstance(): IntegralFragment {
            return IntegralFragment()
        }
    }

    private val mAdapter by lazy { IntegralGoodsAdapter(context) }
    override fun getLayoutId(): Int = R.layout.fragment_integral

    override fun initView() {
        titleName.text = "积分商城"
        titleBackground.setPadding(0, StatusBarUtil.getStatusBarHeight(MyApplication.context), 0, StatusBarUtil.getStatusBarHeight(MyApplication.context))

        integral_rl.layoutManager = GridLayoutManager(context, 2)
        integral_rl.adapter = mAdapter
    }

    override fun lazyLoad() {
    }

    override fun initEvent() {
        //点击更多按钮
        rightLayout.setOnClickListener {

        }
    }
}