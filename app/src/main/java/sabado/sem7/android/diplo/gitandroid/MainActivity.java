package sabado.sem7.android.diplo.gitandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
{
    private Button miBoton1;
    private Button miBoton2;
    private Button miBoton3;
    private TextView txtVista;
    private Bitmap imagenWeb;
    private ImageView miImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miBoton1 = findViewById(R.id.boton1);
        miBoton2 = findViewById(R.id.boton2);
        miBoton3 = findViewById(R.id.boton3);
        txtVista = findViewById(R.id.txtSaludo);
        miImagen = findViewById(R.id.imageView);

        miBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVista.setText("Kalimera Git");
                Toast.makeText(MainActivity.this, "Se camnbió" +
                        "el mensaje del textView", Toast.LENGTH_SHORT).show();
            }
        });

        miBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVista.setText("antío Git");
                Toast.makeText(MainActivity.this, "Se camnbió" +
                        "el mensaje del textView", Toast.LENGTH_SHORT).show();
            }
        });

        miBoton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new DescargarImagen().execute(new URL("https://vignette.wikia.nocookie.net/toontown/images/d/da/Rocco_BigHeadSatDec12012.jpg"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
        class DescargarImagen extends AsyncTask<URL,Integer,Bitmap>
        {
            @Override
            protected Bitmap doInBackground(URL... urls)
            {
                try
                {
                    imagenWeb= BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());
                }
                catch (Exception e)
                {
                    Log.e("diplo","Error"+e.toString());
                }
                return imagenWeb;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap)
            {
                //Establecer el ImageView sobre el layout
                miImagen.setImageBitmap(bitmap);
                super.onPostExecute(bitmap);
            }
        }
}
