// RetrofitInstance.kt
package project.hackmol.hackmolinstafix.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            // Replace with your backend URL (e.g., your ngrok URL or cloud endpoint)
            .baseUrl("https://2mpro9m8.ngrok.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: DiagnosisApiService by lazy {
        retrofit.create(DiagnosisApiService::class.java)
    }
}
