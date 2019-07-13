package com.liangMei.xwjf.ui.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.view.KeyEvent
import com.liangMei.xwjf.R
import com.liangMei.xwjf.base.BaseActivity
import com.liangMei.xwjf.mvp.bean.TabEntity
import com.liangMei.xwjf.showToast
import com.liangMei.xwjf.ui.fragment.IntegralFragment
import com.liangMei.xwjf.ui.fragment.HomeFragment
//import com.fgh.kotlinmvp.ui.fragment.HomeFragment
import com.liangMei.xwjf.ui.fragment.CatFragment
import com.liangMei.xwjf.ui.fragment.MineFragment
import com.liangMei.xwjf.utils.StatusBarUtil
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    private val mTitles = arrayOf("商品", "积分商城", "购物车", "我的")
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal,
            R.mipmap.ic_integral_normal,
            R.mipmap.ic_cat_normal,
            R.mipmap.ic_mine_normal)
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected,
            R.mipmap.ic_integral_selected,
            R.mipmap.ic_hot_selected,
            R.mipmap.ic_mine_selected)

    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment: HomeFragment? = null
    private var mDiscoveryFragment: IntegralFragment? = null
    private var mHotFragment: CatFragment? = null
    private var mMineFragment: MineFragment? = null

    private var mIndex = 0

    override fun layoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
        initTab()
        tabLayout.currentTab = mIndex
        switchFragment(mIndex)
    }

    private fun switchFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (index) {
            0 -> mHomeFragment?.let { transaction.show(it) }
                    ?: HomeFragment.getInstance().let {
                        mHomeFragment = it
                        transaction.add(R.id.fl_container, it, "home")
                    }
            1 -> mDiscoveryFragment?.let { transaction.show(it) }
                    ?: IntegralFragment.getInstance().let {
                        mDiscoveryFragment = it
                        transaction.add(R.id.fl_container, it, "discovery")
                    }
            2 -> mHotFragment?.let { transaction.show(it) }
                    ?: CatFragment.getInstance().let {
                        mHotFragment = it
                        transaction.add(R.id.fl_container, it, "hot")
                    }
            3 -> mMineFragment?.let { transaction.show(it) }
                    ?: MineFragment.getInstance().let {
                        mMineFragment = it
                        transaction.add(R.id.fl_container, it, "mine")
                    }
            else -> {
            }
        }
        mIndex = index
        tabLayout.currentTab = mIndex
        transaction.commitAllowingStateLoss()
    }

    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let {
            transaction.hide(it)
        }
        mDiscoveryFragment?.let {
            transaction.hide(it)
        }
        mHotFragment?.let {
            transaction.hide(it)
        }
        mMineFragment?.let {
            transaction.hide(it)
        }
    }

    private fun initTab() {
        (0 until mTitles.size).mapTo(mTabEntities) {
            TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it])
        }
        tabLayout.setTabData(mTabEntities)
        tabLayout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabReselect(position: Int) {}
            override fun onTabSelect(position: Int) {
                switchFragment(position)
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
        if (tabLayout != null) {
            outState?.putInt("currTabIndex", mIndex)
        }
    }

    private var mExitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun initToolBar() {
        StatusBarUtil.darkMode(
                this,
                ContextCompat.getColor(this, R.color.colorSecondText),
                0.2f
        )
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun initEvent() {
    }

    override fun start() {
    }
}