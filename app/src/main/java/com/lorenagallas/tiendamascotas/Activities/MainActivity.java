package com.lorenagallas.tiendamascotas.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.tabs.TabLayout;
import com.lorenagallas.tiendamascotas.Fragments.PerfilFragment;
import com.lorenagallas.tiendamascotas.Fragments.RecyclerViewFragment;
import com.lorenagallas.tiendamascotas.POJO.Mascota;
import com.lorenagallas.tiendamascotas.R;
import com.lorenagallas.tiendamascotas.Adaptador.PaginaAdaptador;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //crear array para guardar coleccion mascotas
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private  void  setUpViewPager(){
        viewPager.setAdapter(new PaginaAdaptador(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.camara);
        tabLayout.getTabAt(1).setIcon(R.drawable.colibri);
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