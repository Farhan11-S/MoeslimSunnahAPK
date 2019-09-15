package com.example.moeslimsunnahapk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Next extends AppCompatActivity {
    private static final String TAG = Next.class.getSimpleName();


    private List<String> sunahList;
    private RecyclerView rvListsurah;
    Button submit;

    public static final String GOOGLE_ACCOUNT = "google_account";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);
        sunahList = new ArrayList<>();
        Sunnah();
        Intent intent = getIntent();
        submit = findViewById( R.id.submit );
        submit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Next.this, MainActivity.class );
                startActivity( intent );
            }
        } );
        rvListsurah = (RecyclerView) findViewById(R.id.rvListsunah);
        rvListsurah.setLayoutManager(new LinearLayoutManager(this));
        rvListsurah.setAdapter(new Listadaptre(this, sunahList));

    }
    public void Sunnah(){

        sunahList.add("Sholat Dhuha");
        sunahList.add("Sholat Witir");
        sunahList.add("Sholat Fajar");
        sunahList.add("Sholat Tahajud");
        sunahList.add("Puasa Senin dan Kamis");
        sunahList.add("Puasa Yaumulbit");
    }
}
