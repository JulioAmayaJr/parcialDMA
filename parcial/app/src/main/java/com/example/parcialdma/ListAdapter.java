package com.example.parcialdma;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements View.OnClickListener {
    private List<ListElementSong> lista;
    private LayoutInflater mInflater;
    private Context context;
    private View.OnClickListener listener;

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public ListAdapter(List<ListElementSong> lista, Context context) {
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.lista=lista;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.list_songs,null);
        view.setOnClickListener(this);
        return  new ListAdapter.ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
     this.listener=listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(lista.get(position));



    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setItems(List<ListElementSong> datos){
        lista=datos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView songTitle,album;
        Button buttonPlay;


        public ViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.iconImage);
            songTitle=itemView.findViewById(R.id.songTitle);
            album=itemView.findViewById(R.id.album);
            buttonPlay=itemView.findViewById(R.id.buttonPlay);

        }

        void bindData(final ListElementSong item){
            int resourceId = context.getResources().getIdentifier(item.getImage(), "drawable", context.getPackageName());
            image.setImageResource(resourceId);
            songTitle.setText(item.getSongTitle());
            album.setText(item.getAlbum());
        }


    }
}
