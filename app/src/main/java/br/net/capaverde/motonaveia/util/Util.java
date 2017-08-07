package br.net.capaverde.motonaveia.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import br.net.capaverde.motonaveia.R;
import static android.content.Context.TELEPHONY_SERVICE;

public class Util {

    //Verifica se está na horizontal ou vertical
    public static boolean estaNoModoPaisagem(Context context) {
        return context.getResources().getBoolean(R.bool.horizontal);
    }

    //Busca o numero do telefone. Será usado para validar se o numero já foi confirmado via SMS
    private String buscarNumeroTelefone(Context context) {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(TELEPHONY_SERVICE);
        return tm.getLine1Number();
    }
}
