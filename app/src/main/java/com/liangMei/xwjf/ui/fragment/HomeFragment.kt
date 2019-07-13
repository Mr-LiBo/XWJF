package com.liangMei.xwjf.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.liangMei.xwjf.MyApplication
import com.liangMei.xwjf.R
import com.liangMei.xwjf.base.BaseFragment
import com.liangMei.xwjf.ui.adapter.HomeGoodsAdapter
import com.liangMei.xwjf.utils.GlideImageLoader
import com.liangMei.xwjf.utils.StatusBarUtil
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {


    companion object {
        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    private val images = arrayListOf(R.drawable.banner1, R.drawable.banner1, R.drawable.banner1, R.drawable.banner1)

    private val mAdapter by lazy { HomeGoodsAdapter(context) }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView() {
        home_ly.setPadding(0, StatusBarUtil.getStatusBarHeight(MyApplication.context), 0, StatusBarUtil.getStatusBarHeight(MyApplication.context))
        /** 轮播图*/
//        val images = ArrayList<String>()
//        for (banner in bean.slide) {
//            images.add(UriConstant.BASE_IMG_URL + banner.thumb)
//        }
//        banner.setDelayTime() //轮播时间间隔 默认2000
        banner.setImageLoader(GlideImageLoader())
        banner.setImages(images)
        banner.start()

        home_rl.layoutManager = LinearLayoutManager(context)
        home_rl.adapter = mAdapter
    }

    override fun lazyLoad() {
    }

    override fun initEvent() {
        banner.setOnBannerListener {
            Log.e("检测", ">>>>>+" + it)
        }

    }
}