package br.net.capaverde.motonaveia.view;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import br.net.capaverde.motonaveia.R;
import br.net.capaverde.motonaveia.modelo.Evento;

//Mostra os detalhes de um evento
public class EventoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        this.setTitle("Moto na Veia - Evento");
       populaActivity((Evento) getIntent().getSerializableExtra("evento"));
    }

    private void populaActivity( Evento evento)
    {
        if(evento != null) {
            TextView nome = (TextView) findViewById(R.id.lblEventoNome);
            TextView descricao = (TextView) findViewById(R.id.lblEventoDescricao);
            TextView endereco = (TextView) findViewById(R.id.lblEventoEndereco);
            ImageView imagem = (ImageView) findViewById(R.id.imgEvento);

            nome.setText(evento.getNome());
            imagem.setImageBitmap(Bitmap.createScaledBitmap(evento.getImagem(), 1200, 640, true));
            descricao.setText(evento.getDescricao());
            endereco.setText("Rua:" + evento.getRua() + ", " + evento.getRua() + " " +
                    evento.getBairro() + " " + evento.getCidade() + "-" + evento.getUf());
        }
    }
}
