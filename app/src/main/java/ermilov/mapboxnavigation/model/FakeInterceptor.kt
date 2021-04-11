package ermilov.mapboxnavigation.model

import ermilov.mapboxnavigation.BuildConfig
import okio.IOException
import java.net.URI
import android.os.Build;
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.net.ResponseCache
import java.net.URI.create

//Этот класс был создан для заглушки
class FakeInterceptor : Interceptor {
    private val MARKER_1 = "{\n" +
            "\t\"coordinates\": {\n" +
            "\t\t\"latitude\": \"55.0415\",\n" +
            "\t\t\"longitude\": \"82.9346\"\n" +
            "\t}\n" +
            "}"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var response: Response? = null
        if (BuildConfig.DEBUG) {
            val responseString: String = MARKER_1
            response = Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create("application/json".toMediaTypeOrNull(), responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()
        } else {
            response = chain.proceed(chain.request())
        }
        return response
    }
}