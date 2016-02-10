package service.desidimeservice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import service.desidimeservice.R;
import service.desidimeservice.adapter.OfferAdapter;
import service.desidimeservice.dto.Deal;
import service.desidimeservice.dto.DesiDimeData;
import service.desidimeservice.manager.RecyclerItemClickListener;
import service.desidimeservice.network.RestClient;
import service.desidimeservice.service.IconService;
import service.desidimeservice.service.PackageSnifferService;
import service.desidimeservice.utility.Constants;
import service.desidimeservice.utility.NetworkUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar mProgressBar;
    private ImageView mImageView;
    private RecyclerView mOfferList;
    private List<Deal> mDealList;
    private String mOfferId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        if (getIntent() != null)
            mOfferId = getOfferID(getIntent());

        if (NetworkUtils.isAvailable(MainActivity.this)) {
            initiateOffers(mOfferId);
        } else {
            NetworkUtils.displayNetworkDialog(MainActivity.this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter(Constants.PACKAGE_NAME_BROADCAST));
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            mOfferId = getOfferID(intent);

            if (NetworkUtils.isAvailable(MainActivity.this)) {
                initiateOffers(mOfferId);
            } else {
                NetworkUtils.displayNetworkDialog(MainActivity.this);
            }
        }
    };

    private String getOfferID(Intent intent) {
        String offerId = null;
        if (intent != null && intent.hasExtra(Constants.PACKAGE_NAME)) {
            String message = intent.getStringExtra(Constants.PACKAGE_NAME);
            if (message == null) {
                return Constants.FLIPKART;
            }
            switch (message) {
                case Constants.Package.AMAZON_PACKAGE_NAME: {
                    offerId = Constants.AMAZON;
                }
                break;

                case Constants.Package.FLIPKART_PACKAGE_NAME: {
                    offerId = Constants.FLIPKART;
                }
                break;

                case Constants.Package.CALCULATOR_PACKAGE_NAME: {
                    offerId = Constants.AMAZON;
                }
                break;

                default: {
                    offerId = Constants.FLIPKART;
                }
                break;

            }
        }
        return offerId;
    }

    private void initiateOffers(String id) {

        showProgress();
        RestClient.getDesiDimeService().getOffers(id, Constants.TOKEN)
                .enqueue(new Callback<DesiDimeData>() {

                    @Override
                    public void
                    onResponse(Response<DesiDimeData> response) {
                        hideProgress();
                        if (response != null) {
                            DesiDimeData data = response.body();
                            setOfferAdapter(data);
                        }

                    }

                    @Override
                    public void
                    onFailure(Throwable t) {
                        //TODO : Handle error cases
                        hideProgress();
                    }
                });
    }

    private void setOfferAdapter(DesiDimeData data) {
        if (data != null) {
            mDealList = data.getDeals();
            mOfferList.setAdapter(new OfferAdapter(mDealList, MainActivity.this));
        }
    }

    private void initViews() {
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mImageView = (ImageView) findViewById(R.id.close_icon);
        mOfferList = (RecyclerView) findViewById(R.id.offer_list);
        mOfferList.setLayoutManager(new LinearLayoutManager(this));
        mOfferList.addOnItemTouchListener(
                new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener
                        .OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        if (mDealList != null && !mDealList.isEmpty()) {
                            Deal deal = mDealList.get(position);
                            if (NetworkUtils.isAvailable(MainActivity.this)) {
                                startDealDetailActivity(deal);
                            } else {
                                NetworkUtils.displayNetworkDialog(MainActivity.this);
                            }
                        }

                    }
                })
        );
        mImageView.setOnClickListener(this);
    }

    private void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        stopService(new Intent(MainActivity.this, IconService.class));
        stopService(new Intent(MainActivity.this, PackageSnifferService.class));
        finish();
    }

    private void startDealDetailActivity(Deal deal) {

        if (deal != null) {
            Intent movieDetailIntent = new Intent(this, DealDetailActivity.class);
            movieDetailIntent.putExtra(Constants.DEAL, deal);
            startActivity(movieDetailIntent);
        }

    }

}
