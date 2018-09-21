package giancarlosgarza.com.intents_a7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText telefonoEditText;
    EditText mapaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telefonoEditText = (EditText)findViewById(R.id.phoneText);
        mapaEditText = (EditText)findViewById(R.id.mapText);
    }

    public void intentTelefono(View view) {
        String numero = telefonoEditText.getText().toString();
        if (TextUtils.isDigitsOnly(numero) && numero.length()==10){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel: " + numero));
            startActivity(intent);
        }
        else {
            telefonoEditText.setError("El teléfono tiene que ser de 10 digitos");
        }
    }

    public void intentWeb(View view){
        String url = mapaEditText.getText().toString();
        if (URLUtil.isValidUrl(url)){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        else {
            mapaEditText.setError("Debe ser una página valida");
        }
    }

    public void intentMaps(View view){
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
