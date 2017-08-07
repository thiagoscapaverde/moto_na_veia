package br.net.capaverde.motonaveia.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import br.net.capaverde.motonaveia.R;
import br.net.capaverde.motonaveia.adapter.ListaEventosAdapter;
import br.net.capaverde.motonaveia.cominicacao.Comunicacao;
import br.net.capaverde.motonaveia.modelo.Evento;
import br.net.capaverde.motonaveia.util.Util;

public class PrincipalFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_principal, container, false);
        preparaMenu();
        popularListaDeEventos();

        return view;
    }

    private void popularListaDeEventos() {
        ArrayList<Evento> listaDeEventos = Comunicacao.BuscarEventos(getContext());
        ListView lstEventos = (ListView) view.findViewById(R.id.listaEventos);
        ListaEventosAdapter adapter = new ListaEventosAdapter(getContext(), R.layout.item_lista_evento_modelo, listaDeEventos, Util.estaNoModoPaisagem(getContext()));
        lstEventos.setAdapter(adapter);

        //Preparar o para escutar um click na lista
        lstEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Evento evento = ((Evento) parent.getItemAtPosition(position));
                    Intent intent = new Intent(getContext(), EventoActivity.class);
                    intent.putExtra("evento", evento);
                    startActivity(intent);
                }catch (Exception ex){}
            }
        });
    }

    private void preparaMenu(){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("Moto na Veia - Eventos");
        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_classificados_add) {
            Toast.makeText(getContext(), "Não implementado",Toast.LENGTH_LONG);
        } else if (id == R.id.menu_classificados_visualizar) {
            Toast.makeText(getContext(), "Não implementado",Toast.LENGTH_LONG);
        } else if (id == R.id.menu_evento_add) {
            Toast.makeText(getContext(), "Não implementado",Toast.LENGTH_LONG);
        } else if (id == R.id.menu_evento_visualizar) {
            Toast.makeText(getContext(), "Não implementado",Toast.LENGTH_LONG);
        } else if (id == R.id.menu_grupos_add) {
            Toast.makeText(getContext(), "Não implementado",Toast.LENGTH_LONG);
        } else if (id == R.id.menu_grupos_visualizar) {
            Toast.makeText(getContext(), "Não implementado",Toast.LENGTH_LONG);
        }
        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
