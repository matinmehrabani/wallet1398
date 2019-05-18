package com.example.wallet1398.ui.listcurrencies;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wallet1398.R;
import com.example.wallet1398.data.model.Currencies;
import com.example.wallet1398.datawallet.SqLite;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Activity activity;
    private List<Currencies> list;

    public MyAdapter(Activity activity, List<Currencies> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(activity).inflate(R.layout.model, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Currencies ma = list.get(position);
        myViewHolder.name.setText(ma.getName());
        myViewHolder.symbol.setText(ma.getSymbol());
        myViewHolder.type.setText(ma.getType());
        myViewHolder.code.setText(ma.getCode());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView name;
        TextView code;
        TextView type;
        TextView symbol;
        ImageButton imageButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            code = itemView.findViewById(R.id.code);
            type = itemView.findViewById(R.id.type);
            symbol = itemView.findViewById(R.id.symbol);
            imageButton = itemView.findViewById(R.id.add);
            cardView = itemView.findViewById(R.id.cardview);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SqLite DB;
                    DB = new SqLite(activity);
                    com.example.wallet1398.data.model.SqLite modelSQLite = new com.example.wallet1398.data.model.SqLite();
                    modelSQLite.wName = list.get(getAdapterPosition()).getName();
                    modelSQLite.wCode = list.get(getAdapterPosition()).getCode();
                    DB.insertPerson(modelSQLite);
                    Toast.makeText(activity, R.string.SaveData, Toast.LENGTH_SHORT).show();
                    Log.i("database", "onClick: " + DB.toString());

                }
            });


        }


    }
}
