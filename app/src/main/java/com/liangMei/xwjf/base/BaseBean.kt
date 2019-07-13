package com.liangMei.xwjf.base

import java.io.Serializable

class BaseBean<T>(
        val code: Int,
        val message: String,
        val data: T
) : Serializable