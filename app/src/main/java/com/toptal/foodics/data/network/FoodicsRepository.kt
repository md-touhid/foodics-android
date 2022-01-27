package com.toptal.foodics.data.network

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by touhid on 24/Jan/2022.
 */

object FoodicsRepository {

    private val BaseUrl = "https://api-sandbox.foodics.com/v5/"
    var token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjE2OTRiYjE0OGVmZDU0NzFmZjE1N2VhNzljYTY4NDJmZGViZTBmYzIyM2JlMDcxOGQ5ZmYwNzRlYzEyODE5YzAzYmQ3ZGQ1MzRmMzQzOTc4In0.eyJhdWQiOiI4ZjllYjNmNi02ZWZhLTRmZWYtODk1ZS1kMWJjNDRiYTQ4MWQiLCJqdGkiOiIxNjk0YmIxNDhlZmQ1NDcxZmYxNTdlYTc5Y2E2ODQyZmRlYmUwZmMyMjNiZTA3MThkOWZmMDc0ZWMxMjgxOWMwM2JkN2RkNTM0ZjM0Mzk3OCIsImlhdCI6MTY0MjkyNTc4NCwibmJmIjoxNjQyOTI1Nzg0LCJleHAiOjE4MDA2OTIxODQsInN1YiI6IjhmOWZiZjM2LTI1MGYtNDY4My1iY2QwLWUwY2YyOTMwZGYzNCIsInNjb3BlcyI6WyJnZW5lcmFsLnJlYWQiXSwiYnVzaW5lc3MiOiI4ZjlmYmYzNi0yNmRiLTQ0NWEtYmY3ZS03YjBiYTQzZjU2MWUiLCJyZWZlcmVuY2UiOiIyMjIyMjIifQ.lAfAUJMj99YaAUaW1ZUR23Tspf1fUCu8XLB_ylh_nCUKs1jP1MhApZdO9j4t3pMZR4JeGuUlbO3fm6170wKEFt4wDqNXWSTzrkyWoUQ6QxXhf-Z4yFTrDOzWUgLitSr7eD7MDI1uAyB4WxWPw95UkteenKh7cipOdkp7qV-7WiTRyBJRkzPCGkDzH9hY34FRQ9ItoVnKZldzQ0_c2pUg7kiLWKk4sSpY3EuikubLdkaJI3aHLWWzUaSKXnXl7Qgju-O8_N474SgtLUZYEfL7BkEjHgCqkbHLcV5L3d49GDtmIoswLlJMq2NDmFg44Gw4QLNRPpX-sawn05y3nmhCfgqtj27ywatT2_0APWAVQkQ3ZUBMMlbodAtEaiMWhcp2TCrd85lXKJYyflNdFhAJq9RileCuJgJmX-wrazfWS1u_4gbXcGBarHRsHlznxc-Y3ADA2S6S_QHCJJoHOMfJiCu6ksAOYDeW3fqafuUIAG7_oZNocGKtRox0Dp6XPxU0tcJU5pPg9rgwUNgo_iJ1SImf4wFE_v7fMOfkw4Msm8QvDbbE2bKE_TKTdqZ_jmqxbdntfqR5bvTZZhyO7iMbhlasDQ-_4psiqJY4vtMW5jPZVaxRBTvGMbFgE5NNmHmUb_MYwpdGzGRBS6x0LVbwrIXly0AcADoH8g63tI8AZHA"

    private val okClient = OkHttpClient.Builder().addInterceptor { chain ->
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        chain.proceed(newRequest)
    }.build()

    private val retrofit = Retrofit.Builder()
        .client(okClient)
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ApiService::class.java)
}
