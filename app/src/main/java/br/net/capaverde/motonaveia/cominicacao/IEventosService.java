package br.net.capaverde.motonaveia.cominicacao;

import java.util.List;

import br.net.capaverde.motonaveia.modelo.Evento;
import br.net.capaverde.motonaveia.modelo.ListaEventos;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by thiag on 06/08/2017.
 * Será usado para comunicação com o WS utilizando Retrofit
 */

public interface IEventosService {
    public static final String URL_BASE = "https://www.capaverede.net.br/public-api/v2.1.2.3/";

    @GET("eventos")
    Call<ListaEventos> listaEventos();
}
