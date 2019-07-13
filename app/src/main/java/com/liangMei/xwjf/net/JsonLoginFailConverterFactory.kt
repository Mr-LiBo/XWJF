package com.liangMei.xwjf.net


import com.liangMei.xwjf.base.BaseBean
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type

class JsonLoginFailConverterFactory constructor(private val gson: Gson) : Converter.Factory() {

    init {
        if (gson == null) {
            throw NullPointerException("gson == null")
        }
    }

    companion object {

        @JvmOverloads
        fun create(gson: Gson = Gson()): JsonLoginFailConverterFactory {
            return JsonLoginFailConverterFactory(gson)
        }
    }

            override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *> {
        val adapter = gson.getAdapter(TypeToken.get(type)) as TypeAdapter<*>
        return JsonLoginFailBodyConverterKt(gson, adapter)
    }

    inner class JsonLoginFailBodyConverterKt<T> constructor(val gSon: Gson, adapter: TypeAdapter<T>) : Converter<ResponseBody, T> {
        private val adapter: TypeAdapter<T> = adapter

        @Throws(IOException::class)
        override fun convert(responseBody: ResponseBody): T {
            val response = responseBody.string()
            val gson = Gson()
            val bean = gson.fromJson(response, BaseBean::class.java)
//            Log.e("检测",">>>>>>errno:"+bean.errno)
            if (bean.code == 402) {
//                //未携带userId，跳转到登录页面
//                Log.e("检测",">>>>>>>token")
//                /** 在主线程操作 */
//                val disposable = Observable.create<String> {
//                    it.onNext("")
//                }.compose(SchedulerUtils.ioToMain())
//                        .subscribe {
//                            Preference.clearPreference(UriConstant.USER_ID)
//                            UserInfoLiveData.value = null
//                            val intent = Intent(MyApplication.context, LoginActivity::class.java)
//                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                            MyApplication.context.startActivity(intent)
//                        }
            }
            return adapter.fromJson(response)
        }

    }


}