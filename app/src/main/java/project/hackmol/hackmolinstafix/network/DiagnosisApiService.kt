// DiagnosisApiService.kt
package project.hackmol.hackmolinstafix.network

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

// Data class for the result
data class DiagnosisResult(
    val diagnosis: String,
    val repair_cost: Int,
    val handyman_cost: Int,
    val total_cost: Int
)

interface DiagnosisApiService {
    @Multipart
    @POST("predict")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part
    ): DiagnosisResult
}
