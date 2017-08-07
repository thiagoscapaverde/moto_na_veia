package br.net.capaverde.motonaveia.modelo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by thiag on 06/08/2017.
 * Implementação particular de Bitmap serializavel
 */

public class SerialBitmap implements Serializable {

    public Bitmap bitmap;

    public SerialBitmap(Bitmap _bitmap) {
        bitmap = _bitmap;
    }

    // Serializa o bitmap
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        byte bitmapBytes[] = byteArrayOutputStream.toByteArray();
        out.write(bitmapBytes, 0, bitmapBytes.length);
    }

    // Deserializa o bitmap
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int b;
        while((b = in.read()) != -1)
            byteArrayOutputStream.write(b);
        byte bitmapBytes[] = byteArrayOutputStream.toByteArray();
        bitmap = BitmapFactory.decodeByteArray(bitmapBytes, 0, bitmapBytes.length);
    }
}