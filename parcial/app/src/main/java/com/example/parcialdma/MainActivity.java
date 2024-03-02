package com.example.parcialdma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ListElementSong> lista;
    MediaPlayer media;
    ImageView imageAlbum;
    ImageView btnPlaying,btnStop;
    TextView songTitle,singer,playing,song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageAlbum=findViewById(R.id.imageView2);
        songTitle=findViewById(R.id.textView2);
        singer=findViewById(R.id.textView3);
        playing=findViewById(R.id.textView4);
        song=findViewById(R.id.textView5);
        btnPlaying=findViewById(R.id.buttonPlaying);
        btnStop=findViewById(R.id.buttonStop);
        btnStop.setVisibility(View.INVISIBLE);

        init();
    }

    public void init(){
        lista=new ArrayList<>();
        lista.add(new ListElementSong("sweetchildomine","Sweet Child O' Mine","Appetite for Destruction","Guns N' Roses"));
        lista.add(new ListElementSong("amorlibre","Amor libre","Poesia Difusa","Nach"));
        lista.add(new ListElementSong("hf","Salvadoreñas","18 Exitos de LHF","Los Hermanos Flores"));
        lista.add(new ListElementSong("cochinae","Cochinae","Querian Perreo?","Julianno Sosa"));
        lista.add(new ListElementSong("rebota","Rebota","BRB Be Right Back","Guaynaa"));

        RecyclerView recyclerView=findViewById(R.id.listRecyclerView);

        ListAdapter listAdapter=new ListAdapter(lista,this);

        listAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Seleccion:"+lista.get(recyclerView.getChildAdapterPosition(v)).getArtist(),Toast.LENGTH_SHORT).show();
                if(media!=null){
                    if(media.isPlaying()){
                        media.release();
                        media = null;

                    }
                }
                playing.setText("Reproduciendo");
                btnPlaying.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.VISIBLE);
                if(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle()=="Sweet Child O' Mine"){
                    media=MediaPlayer.create(MainActivity.this,R.raw.sweetchildomine);
                    media.start();
                    songTitle.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    singer.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getArtist());
                    song.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    imageAlbum.setImageResource(R.drawable.sweetchildomine);



                }else if(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle()=="Amor libre"){
                    songTitle.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    singer.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getArtist());
                    song.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    imageAlbum.setImageResource(R.drawable.amorlibre);
                    media=MediaPlayer.create(MainActivity.this,R.raw.amorlibre);
                    media.start();
                }else if(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle().equals("Cochinae")){
                    songTitle.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    singer.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getArtist());
                    song.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    imageAlbum.setImageResource(R.drawable.cochinae);
                    media=MediaPlayer.create(MainActivity.this,R.raw.cochinae);
                    media.start();
                }else if(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle().equals("Salvadoreñas")){
                    songTitle.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    singer.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getArtist());
                    song.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    imageAlbum.setImageResource(R.drawable.hf);
                    media=MediaPlayer.create(MainActivity.this,R.raw.salvadorean);
                    media.start();
                }else if(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle().equals("Rebota")){
                    songTitle.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    singer.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getArtist());
                    song.setText(lista.get(recyclerView.getChildAdapterPosition(v)).getSongTitle());
                    imageAlbum.setImageResource(R.drawable.rebota);
                    media=MediaPlayer.create(MainActivity.this,R.raw.rebota);
                    media.start();
                }



            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        btnPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(media!=null){
                    btnPlaying.setVisibility(View.INVISIBLE);
                    media.start();
                    btnStop.setVisibility(View.VISIBLE);
                    playing.setText("Reproduciendo");
                }else{
                    Toast.makeText(null,"Eliga una cancion por favor", Toast.LENGTH_LONG).show();

                }

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(media!=null){
                    btnStop.setVisibility(View.INVISIBLE);
                    media.pause();
                    btnPlaying.setVisibility(View.VISIBLE);
                    playing.setText("Pause");
                }else{
                    Toast.makeText(null,"Eliga una cancion por favor", Toast.LENGTH_LONG).show();

                }
            }
        });




    }



}