package br.net.capaverde.motonaveia.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.net.capaverde.motonaveia.modelo.Evento;
import br.net.capaverde.motonaveia.R;

/**
 * Realiza a adaptação dos dados a estrutura fisica de exibição
 */
public class ListaEventosAdapter extends ArrayAdapter<Evento> { private List<Evento> items;

    boolean estaNaHorizontal;  //Vai servir para marcar sua orientação
    public ListaEventosAdapter(Context context, int textViewResourceId, List<Evento> items, boolean naHorizontal) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.estaNaHorizontal = naHorizontal;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            Context ctx = getContext();
            LayoutInflater vi = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item_lista_evento_modelo, null);
        }
        Evento evento = items.get(position);
        if (evento != null) {
            if(!estaNaHorizontal) {
                ((ImageView) v.findViewById(R.id.imgListEvento)).setImageBitmap(Bitmap.createScaledBitmap(evento.getImagem(), 300, 160, true));
            }
            ((TextView) v.findViewById(R.id.lblListNome)).setText(evento.getNome());
            ((TextView) v.findViewById(R.id.lblListUF)).setText(evento.getUf());
            ((TextView) v.findViewById(R.id.lblListCidade)).setText(evento.getCidade());

        }
        return v;
    }

}