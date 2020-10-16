package com.lorenagallas.tiendamascotas.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lorenagallas.tiendamascotas.Mascota;
import com.lorenagallas.tiendamascotas.MascotaAdaptador;
import com.lorenagallas.tiendamascotas.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //crear array para guardar coleccion mascotas
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        inicializarListaMascotas();
        //instanciamos
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarAdaptador();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Subir una foto", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Manola", R.drawable.gato, 125));
        mascotas.add(new Mascota("Ibi", R.drawable.perro, 236));
        mascotas.add(new Mascota("Liam", R.drawable.pajaro, 23));
        mascotas.add(new Mascota("Nemo", R.drawable.pez, 198));
        mascotas.add(new Mascota("Anahi", R.drawable.paloma, 18));
        mascotas.add(new Mascota("Sabrina", R.drawable.mariposa, 112));
        mascotas.add(new Mascota("Karina", R.drawable.vaca, 98));
        mascotas.add(new Mascota("Ramiro", R.drawable.oveja, 9));
        mascotas.add(new Mascota("Mario", R.drawable.colibri, 325));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mFavoritos:
                Intent intent = new Intent(MainActivity.this, Favoritos.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                Intent intent1 = new Intent(MainActivity.this, AcercaDeNosotros.class);
                startActivity(intent1);
                break;
            case R.id.mContacto:
                Intent intent2 = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}