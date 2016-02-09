package service.desidimeservice.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import service.desidimeservice.R;
import service.desidimeservice.dto.Deal;
import service.desidimeservice.utility.Constants;

public class DealDetailActivity extends AppCompatActivity {

    private ImageView mLargeImage;
    private Toolbar mToolbar;
    private TextView mDescription;
    private CollapsingToolbarLayout mCollapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_detail);
        Deal deal = getDealExtra();
        initViews();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setToolbarTitle(deal);
        downloadLargeDealImage(deal);
        setDealDescription(deal);
    }

    private void setDealDescription(Deal deal) {
        if (deal == null)
            return;

        mDescription.setText(getString(R.string.description, Html.fromHtml(deal.getDescription())));
    }

    private void downloadLargeDealImage(final Deal deal) {
        //Wait for image view to draw itself in the xml hierarchy
        mLargeImage.post(new Runnable() {
            @Override
            public void run() {
                if (deal != null && !deal.getImage().isEmpty())
                    Picasso.with(DealDetailActivity.this).load(deal.getImage()).resize(mLargeImage
                            .getWidth
                                    (), mLargeImage.getHeight()).centerCrop().placeholder(new
                            ColorDrawable
                            (ContextCompat.getColor(DealDetailActivity.this, R
                                    .color.colorAccent))).into(mLargeImage);
            }
        });

    }

    private void setToolbarTitle(final Deal deal) {
        if (deal == null)
            return;
        mCollapsingToolbar.setExpandedTitleTextAppearance(R.style.Toolbar_TitleText);
        mCollapsingToolbar.setCollapsedTitleTextAppearance(R.style.Toolbar_TitleText_Collpase);
        getSupportActionBar().setTitle(deal.getTitle());
    }

    private void initViews() {
        mLargeImage = (ImageView) findViewById(R.id.largeImage);
        mToolbar = (Toolbar) findViewById(R.id.toolBarView);
        mDescription = (TextView) findViewById(R.id.description);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.main_collapsing);
    }

    public Deal getDealExtra() {
        Deal deal = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(Constants.DEAL)) {
                deal = intent.getParcelableExtra(Constants.DEAL);
            }
        }
        return deal;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}