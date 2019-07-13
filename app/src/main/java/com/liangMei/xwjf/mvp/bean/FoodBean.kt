package com.liangMei.xwjf.mvp.bean

data class FoodBean(
        val erro_code: Int,
        val reason: String,
        val resultcode: String,
        val result: Result
) {
    data class Result(
            val rn: String,
            val pn: String,
            val pr: String,
            val data: ArrayList<Data>
    ) {

        data class Data(
                val sk: String,
                val burden: String,
                val id: String,
                val imtro: String,
                val ingredients: String,
                val title: String
        )
    }
}