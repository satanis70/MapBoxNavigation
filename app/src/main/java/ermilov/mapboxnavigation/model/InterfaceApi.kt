package ermilov.mapboxnavigation.model

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceApi {
    @GET("c734bae196cdc94676e6")
    suspend fun getMarkers(): Response<Markers>
}