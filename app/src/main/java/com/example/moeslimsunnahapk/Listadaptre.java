package com.example.moeslimsunnahapk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class Listadaptre extends RecyclerView.Adapter<Listadaptre.MyViewHolder> {

    private HashMap<Integer, Boolean> isChecked = new HashMap<>();
    private Context mContext;
    private LayoutInflater inflater;
    private List<String> sunahList;

    public Listadaptre(Context context, List<String> sunnahList){
        this.mContext = context;
        this.sunahList = sunnahList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public Listadaptre.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.list2, parent,  false);

        MyViewHolder holder = new MyViewHolder(rootView);
        return holder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.sunah.setText(sunahList.get(position));
        if (isChecked.containsKey(position)){
            holder.sunah.setChecked(isChecked.get(position));
        } else {
            holder.sunah.setChecked(false);
        }
    }




    @Override
    public int getItemCount() {
        return sunahList.size();


    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox sunah;

        public MyViewHolder(View itemView) {
            super(itemView);

            sunah = (CheckBox) itemView.findViewById(R.id.sunah);

            sunah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        Toast.makeText(mContext, "checklist", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, "unchecklist", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
