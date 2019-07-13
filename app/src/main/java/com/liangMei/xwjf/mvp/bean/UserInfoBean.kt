package com.liangMei.xwjf.mvp.bean

data class UserInfoBean(
        val expire: String,
        val user: UserInfo,
        val token: String
)

class UserInfo(
        val userId: String
)