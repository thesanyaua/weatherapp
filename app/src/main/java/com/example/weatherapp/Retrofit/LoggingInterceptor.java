package com.example.weatherapp.Retrofit;

import com.example.weatherapp.sss.Utils;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by Aleksandr Aleksandrov
 * Date: 12/20/20
 * Time: 9:45 PM
 */
class LoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();

        Utils.log(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));

        Utils.log("Request body: " + bodyToString(request));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        Utils.log(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        String responseString = response.body().string();
        if (responseString.isEmpty()) {
            responseString = "";
            Logger.v("Response is empty");
        } else {
            Utils.log("Response body: " + responseString);
        }

        Response newResponse = response.newBuilder().body(ResponseBody.create(response.body().contentType(),
                responseString.getBytes())
        ).build();

        return newResponse;
    }

    private String bodyToString(Request request) {
        Request copy = request.newBuilder().build();
        Buffer buffer = new Buffer();
        if (copy.body() != null) {
            try {
                copy.body().writeTo(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.readUtf8();
    }
}
