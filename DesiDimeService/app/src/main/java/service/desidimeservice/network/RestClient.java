package service.desidimeservice.network;

import android.content.Context;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import service.desidimeservice.utility.Config;
import service.desidimeservice.utility.NetworkUtils;

public class RestClient {

    private Context mContext;

    public DesiDimeService getDesiDimeService(Context context) {
        mContext = context;
        DesiDimeService api = getRetrofit().create(DesiDimeService.class);
        return api;
    }


    private Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.URL_END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();
        return retrofit;
    }

    private OkHttpClient getOkHttpClient() {
        //setup cache
        File httpCacheDirectory = new File(mContext.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        // OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache)build();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache).addInterceptor(
                new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();
                        String cacheHeaderValue = NetworkUtils.isAvailable(mContext)
                                ? "public, max-age=2419200"
                                : "public, only-if-cached, max-stale=2419200";
                        Request request = originalRequest.newBuilder().build();
                        Response response = chain.proceed(request);
                        return response.newBuilder()
                                .removeHeader("Pragma")
                                .removeHeader("Cache-Control")
                                .header("Cache-Control", cacheHeaderValue)
                                .build();
                    }
                }
        ).addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                String cacheHeaderValue = NetworkUtils.isAvailable(mContext)
                        ? "public, max-age=2419200"
                        : "public, only-if-cached, max-stale=2419200";
                Request request = originalRequest.newBuilder().build();
                Response response = chain.proceed(request);
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", cacheHeaderValue)
                        .build();
            }
        }).build();
        return okHttpClient;
    }
}
