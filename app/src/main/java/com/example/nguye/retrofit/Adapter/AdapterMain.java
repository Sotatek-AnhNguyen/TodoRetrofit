package com.example.nguye.retrofit.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nguye.retrofit.Activity.UpdateActivity;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguye on 28/05/2018.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.viewHolder>{
    public static final int RECODEADAP = 2;
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Datum> arrData;
    private String acToken;

    public AdapterMain(Context context, ArrayList<Datum> arrData, String acToken) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.arrData = arrData;
        this.acToken = acToken;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.activity_item, parent, false);
        viewHolder viewHolder = new viewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.mTvTitle.setText(arrData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView mTvTitle;

        public viewHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.mTvItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, UpdateActivity.class);
                    intent.putExtra("dat", arrData.get(getAdapterPosition()));
                    intent.putExtra("tok", acToken);
                    intent.putExtra("position", getAdapterPosition());
                    ((Activity)context).startActivityForResult(intent, RECODEADAP);
                }
            });
        }
    }
}
