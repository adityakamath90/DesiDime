package service.desidimeservice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import service.desidimeservice.R;
import service.desidimeservice.dto.Deal;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    private List<Deal> mDealList;
    private LayoutInflater mInflater;

    public OfferAdapter(List<Deal> dealList, Context context) {
        mDealList = dealList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public OfferAdapter.OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.offer_item, parent, false);
        OfferViewHolder viewHolder = new OfferViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OfferAdapter.OfferViewHolder holder, int position) {

        Context context = mInflater.getContext();
        Deal deal = mDealList.get(position);

        if (!TextUtils.isEmpty(deal.getTitle())) {
            holder.mDealName.setText(context.getString(R.string.title, deal.getTitle()));
        }

        if (deal.getImage() != null && !deal.getImage().isEmpty()) {
            Picasso.with(mInflater.getContext()).load(deal.getImage())
                    .resize(75, 75).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                    .into(holder.mThumbnail);
        }
    }

    @Override
    public int getItemCount() {
        return ((mDealList != null) ? mDealList.size() : 0);
    }

    static class OfferViewHolder extends RecyclerView.ViewHolder {

        private ImageView mThumbnail;
        private TextView mDealName;

        public OfferViewHolder(View itemView) {
            super(itemView);
            mThumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            mDealName = (TextView) itemView.findViewById(R.id.deal_name);
        }
    }
}
