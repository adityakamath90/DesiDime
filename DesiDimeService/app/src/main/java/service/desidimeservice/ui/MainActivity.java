package service.desidimeservice.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Callback;
import retrofit2.Response;
import service.desidimeservice.R;
import service.desidimeservice.dto.DesiDimeData;
import service.desidimeservice.network.RestClient;
import service.desidimeservice.utility.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String id = "1";
        RestClient.getDesiDimeService().getOffers(id, Constants.TOKEN)
                .enqueue(new Callback<DesiDimeData>() {

                    @Override
                    public void
                    onResponse(Response<DesiDimeData> response) {

                        if (response != null) {
                            DesiDimeData data = response.body();
                            data.getCoupons();
                        }

                    }

                    @Override
                    public void
                    onFailure(Throwable t) {
                    }
                });
    }
}
