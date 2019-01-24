package com.example.gebruiker.mobileapplicationdevelopment_lvl7.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.gebruiker.mobileapplicationdevelopment_lvl7.R;
import com.example.gebruiker.mobileapplicationdevelopment_lvl7.utils.BucketListItemOnClickListener;


public class BucketListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public CheckBox checkBoxItem;
    public TextView itemName;
    public TextView itemDescription;
    private BucketListItemOnClickListener mBucketListItemOnClickListener;

    public BucketListItemViewHolder(View itemView, BucketListItemOnClickListener listerner) {
        super(itemView);
        checkBoxItem = itemView.findViewById(R.id.checkBox);
        itemName = itemView.findViewById(R.id.item_name);
        itemDescription = itemView.findViewById(R.id.item_description);
        mBucketListItemOnClickListener = listerner;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int clickedPosition = getAdapterPosition();
        mBucketListItemOnClickListener.itemOnClick(view,clickedPosition);
    }

}
