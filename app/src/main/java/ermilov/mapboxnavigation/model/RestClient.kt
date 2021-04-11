package ermilov.mapboxnavigation.model


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

//Этот класс был создан для заглушки
class RestClient {
    private var mRestService: InterfaceApi? = null
    fun getClient(): InterfaceApi? {
        if (mRestService == null) {
            val client = OkHttpClient()
            client.newBuilder().addInterceptor(FakeInterceptor()).build()
            val retrofit: Retrofit = Retrofit.Builder()
                    .addConverterFactory(JacksonConverterFactory.create())
                    .baseUrl("http://www.vavian.com/")
                    .client(client)
                    .build()
            mRestService = retrofit.create(InterfaceApi::class.java)
        }
        return mRestService
    }
}