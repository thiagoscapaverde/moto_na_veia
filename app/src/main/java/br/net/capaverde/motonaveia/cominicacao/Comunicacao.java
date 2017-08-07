package br.net.capaverde.motonaveia.cominicacao;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.net.capaverde.motonaveia.R;
import br.net.capaverde.motonaveia.modelo.Evento;
import br.net.capaverde.motonaveia.modelo.ListaEventos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class  Comunicacao {

    //Vai busacar os dados que pode ser em arquivo, WS, banco ou qualquer outro lugar.
    //Não ficou bom ele receber um context pois não fará sentido para buscar de um WS por exemplo
    public static ArrayList<Evento> BuscarEventos(Context context)    {
        ArrayList<Evento> listaDeEventos = new ArrayList<>();
        listaDeEventos.add(new Evento("Moto Rock Solidario",
                "Entrada 1 kg de alimento não perecivel.",
                "Caxias do Sul",
                "RS",
                "Rua Matteo Gianella",
                "1444",
                "Santa Catarina",
                ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.evento1)).getBitmap()));


        listaDeEventos.add(new Evento("Gringos da Serra",
                "Aniversario do moto grupo",
                "Carlos Barbosa",
                "RS",
                "Parque Guido Pasqual Sganderla",
                "",
                "",
                ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.evento2)).getBitmap()));

        listaDeEventos.add(new Evento("Moto Delta",
                "Evento com show de bandas estaduaais",
                "Parobé",
                "RS",
                "Parque Festejando Parobé",
                "",
                "",
                ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.evento3)).getBitmap()));
        listaDeEventos.add(new Evento("Moto Rock Solidario",
                "Entrada 1 kg de alimento não perecivel.",
                "Caxias do Sul",
                "RS",
                "Rua Matteo Gianella",
                "1444",
                "Santa Catarina",
                ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.evento1)).getBitmap()));

        listaDeEventos.add(new Evento("Gringos da Serra",
                "Aniversario do moto grupo",
                "Carlos Barbosa",
                "RS",
                "Parque Guido Pasqual Sganderla",
                "",
                "",
                ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.evento2)).getBitmap()));

        listaDeEventos.add(new Evento("Moto Delta",
                "Evento com show de bandas estaduaais",
                "Parobé",
                "RS",
                "Parque Festejando Parobé",
                "",
                "",
                ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.evento3)).getBitmap()));
        listaDeEventos.add(new Evento("Moto Rock Solidario",
                "Entrada 1 kg de alimento não perecivel.",
                "Caxias do Sul",
                "RS",
                "Rua Matteo Gianella",
                "1444",
                "Santa Catarina",
                ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.evento1)).getBitmap()));

        listaDeEventos.add(new Evento("Gringos da Serra",
                "Aniversario do moto grupo",
                "Carlos Barbosa",
                "RS",
                "Parque Guido Pasqual Sganderla",
                "",
                "",
                ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.evento2)).getBitmap()));

        listaDeEventos.add(new Evento("Moto Delta",
                "Evento com show de bandas estaduaais",
                "Parobé",
                "RS",
                "Parque Festejando Parobé",
                "",
                "",
                ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.evento3)).getBitmap()));
        return listaDeEventos;
    }

    private static List<Evento> BuscarEventosWS(){

        final ListaEventos[] lista = new ListaEventos[1];
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IEventosService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IEventosService servico = retrofit.create(IEventosService.class);
        Call<ListaEventos> request = servico.listaEventos();
        //Realizar a chamada de forma assincrona
        request.enqueue(new Callback<ListaEventos>() {
            @Override
            public void onResponse(Call<ListaEventos> call, Response<ListaEventos> response) {
                if(response.isSuccessful()){
                    ListaEventos catalog = response.body();
                    lista[0] = catalog;
                }
            }

            @Override
            public void onFailure(Call<ListaEventos> call, Throwable t) {
                Log.e("ERROWS","Erro ao consumir o WS:" + t.getMessage());
            }
        });

        return lista[0].eventos;
    }

}
