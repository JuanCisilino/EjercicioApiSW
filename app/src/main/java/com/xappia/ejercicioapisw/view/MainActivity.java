package com.xappia.ejercicioapisw.view;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.xappia.ejercicioapisw.R;
import com.xappia.ejercicioapisw.controller.ControllerFilms;
import com.xappia.ejercicioapisw.model.Personaje;
import com.xappia.ejercicioapisw.utils.ResultListener;

public class MainActivity extends AppCompatActivity {

    private Toolbar myToolbar;
    private RecyclerView contenedorLista;
    private ControllerFilms controllerFilms;
    private Integer consulta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myToolbar = findViewById(R.id.ToolbarDeLaApp_Toolbar_ContenedorItems);
        controllerFilms = new ControllerFilms();
        creoElAppBar();
    }

    private void creoElAppBar() {
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem myMenuItemSearch = menu.findItem(R.id.ToolBarMenu_Item_action_search);
        MenuItem myMenuItemList = menu.findItem(R.id.ToolBarMenu_Item_lista);

        SearchView mySearchView = (SearchView) myMenuItemSearch.getActionView();
        mySearchView.setQueryHint("May the 4 Be With U!!");

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                try {
                    consulta = Integer.valueOf(query);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Ese Personaje no Existir en Esta Historia!!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                    return false;
                }
                controllerFilms.traePersonaje(consulta, new ResultListener<Personaje>() {
                    @Override
                    public void finish(Personaje result) {
                        if (result != null) {
                            Toast.makeText(getBaseContext(), result.getName(), Toast.LENGTH_LONG).show();
                            FragmentDetallePersonaje fragmentDetallePersonaje = new FragmentDetallePersonaje();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(fragmentDetallePersonaje.PERSONAJEELEGIDO, result);
                            fragmentDetallePersonaje.setArguments(bundle);
                            pegarFragment(fragmentDetallePersonaje);
                        } else {
                            Toast.makeText(getBaseContext(), "Ese Personaje no Existir en Esta Historia!!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void pegarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.MainActivity_FrameLayout_ContenedorDeFragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
