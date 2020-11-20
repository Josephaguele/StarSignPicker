package com.example.starsignpicker;


import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StarSignPickerAdapter extends RecyclerView.Adapter<StarSignPickerAdapter.ViewHolder>
{
    private String[] mStarSigns = {
            "Aries", "Taurus", "Gemini", "Cancer",
            "Leo", "Virgo", "Libra", "Scorpio",
            "Sagittarius", "Capricorn", "Aquarius",
            "Pisces" };

    public StarSignPickerAdapter() {}

    @Override // if array of strings of starsigns is null, return zero, else return starsigns.length
    public int getItemCount()
    {
        return mStarSigns == null ? 0 : mStarSigns.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener
    {
        public TextView textView;
        public View.OnClickListener mListener;

        public ViewHolder (View v, View.OnClickListener listener)
        {
            super(v);
            mListener = listener;
            textView = v.findViewById(R.id.itemTextView);
            v.setOnClickListener(this);//setting a click listener on the textview
        }

        @Override
        public void onClick(View v) {
            if (mListener != null)
                mListener.onClick(v);
        }
    } // end class ViewHolder

    @NonNull
    @Override // this is called to get a RecyclerView.ViewHolder instance whenever the
    // layout manager does not have an unused view to use.
    public StarSignPickerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // create the new View
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);

        return new ViewHolder(v, null);
    }


    /*interface that takes a String argument; add a setOnAdapterItemClick method to the Adapter
     to store a reference to this event handler. This handler will be used to notify the parent
     activity which list item has been selected.*/
    public interface IAdapterItemClick
    {
        void onItemClicked(String selectedItem);
    } // end interface IAdapterItemClick

    IAdapterItemClick mAdapterItemClickListener;
    public void setOnAdapterItemClick( IAdapterItemClick adapterItemClickHandler)
    {
        mAdapterItemClickListener = adapterItemClickHandler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {
        holder.textView.setText(mStarSigns[position]);
        holder.mListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if ( mAdapterItemClickListener != null)
                    mAdapterItemClickListener.onItemClicked(mStarSigns[position]);
            }
        };
    } // end method onBindViewHolder

}
