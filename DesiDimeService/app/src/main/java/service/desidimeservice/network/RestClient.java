package service.desidimeservice.network;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import service.desidimeservice.utility.Config;

public class RestClient {


    public static DesiDimeService getDesiDimeService() {
        DesiDimeService api = getRetrofit().create(DesiDimeService.class);
        return api;
    }


    private static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.URL_END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}