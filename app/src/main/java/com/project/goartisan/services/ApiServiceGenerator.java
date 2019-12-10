package com.project.goartisan.services;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.project.goartisan.BuildConfig;
import com.project.goartisan.models.ApiError;
import com.squareup.picasso.Picasso;

import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiServiceGenerator {

    private ApiServiceGenerator() {
    }
    private static Picasso picasso;

    public static Picasso createPicasso(final Context context) {
        if(picasso == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            httpClient.readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS);

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(logging);


            picasso = new Picasso.Builder(context)
                    .downloader(new OkHttp3Downloader(httpClient.build()))
                    .build();
        }
        return picasso;
    }


    private static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass) {
        if(retrofit == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            httpClient.readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS);

            if(BuildConfig.DEBUG) {
                httpClient.addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY));
            }

            retrofit = new Retrofit.Builder().baseUrl(ApiService.API_BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // Configuracion adicional
                    .build();
        }

        return retrofit.create(serviceClass);
    }



    private static Retrofit retrofitWithAuth;
    public static <S> S createService(final Context context, Class<S> serviceClass) {
        if(retrofitWithAuth == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            httpClient.readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS);

            if(BuildConfig.DEBUG) {
                httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
            }
            // Retrofit Token: https://futurestud.io/tutorials/retrofit-token-authentication-on-android



            retrofitWithAuth = new Retrofit.Builder()
                    .baseUrl(ApiService.API_BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())// Implementar en
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()).build();
        }
        return retrofitWithAuth.create(serviceClass);
    }

    public static ApiError parseError(Response<?> response) {
        try {
            Converter<ResponseBody, ApiError> converter = retrofit.responseBodyConverter(ApiError.class, new Annotation[0]);
            return converter.convert(response.errorBody());
        } catch (Exception e) {
            return new ApiError("Error desconocido en el servicio");
        }
    }

}
