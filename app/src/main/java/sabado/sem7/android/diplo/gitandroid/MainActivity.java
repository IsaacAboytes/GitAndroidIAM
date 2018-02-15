package sabado.sem7.android.diplo.gitandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button miBoton;
    private TextView txtVista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miBoton=findViewById(R.id.boton);
        txtVista=findViewById(R.id.txtSaludo);

        miBoton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtVista.setText("Kalimera Git");
                Toast.makeText(MainActivity.this, "Se camnbió" +
                        "el mensaje del textView", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
