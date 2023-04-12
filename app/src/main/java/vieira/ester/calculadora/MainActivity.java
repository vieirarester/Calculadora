package vieira.ester.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculadora.R;
import com.example.calculadora.databinding.ActivityMainBinding;

import vieira.ester.calculadora.model.DatabaseSingleton;
import vieira.ester.calculadora.view.Botao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstance(this);

        setContentView(R.layout.activity_main);

    }
}