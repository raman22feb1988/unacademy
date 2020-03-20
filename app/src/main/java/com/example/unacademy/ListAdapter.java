package com.example.unacademy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    Context con;
    int _resource;
    List<String> lival;

    List<View> vi;

    public ListAdapter(Context context, int resource, List<String> li) {
        // TODO Auto-generated constructor stub
        con = context;
        _resource = resource;
        lival = li;

        vi = new ArrayList<>();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(_resource, parent, false);
        vi.add(listItem);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String url = lival.get(position);

        final View listItem = vi.get(position);

        ImageView i1 = listItem.findViewById(R.id.numberimage);

        switch(position) {
            case 0:
                i1.setImageResource(R.drawable.number_1_1);
                break;
            case 1:
                i1.setImageResource(R.drawable.number_2_1);
                break;
            case 2:
                i1.setImageResource(R.drawable.number_3_1);
                break;
            case 3:
                i1.setImageResource(R.drawable.number_4_1);
                break;
            case 4:
                i1.setImageResource(R.drawable.number_5_1);
                break;
            case 5:
                i1.setImageResource(R.drawable.number_6_1);
                break;
            case 6:
                i1.setImageResource(R.drawable.number_7_0);
                break;
            case 7:
                i1.setImageResource(R.drawable.number_8_1);
                break;
            case 8:
                i1.setImageResource(R.drawable.number_9_1);
        }
    }

    @Override
    public int getItemCount() {
        return lival.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}