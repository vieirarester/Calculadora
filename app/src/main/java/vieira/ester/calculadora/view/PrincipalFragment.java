package vieira.ester.calculadora.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.calculadora.R;
import com.example.calculadora.databinding.FragmentPrincipalBinding;

public class PrincipalFragment extends Fragment {

    FragmentPrincipalBinding principalBinding;

    public PrincipalFragment() {
        super(R.layout.fragment_principal);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        principalBinding = FragmentPrincipalBinding.inflate(inflater, container, false);
        return principalBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView expressao = principalBinding.expressao;
        TextView resultado = principalBinding.resultado;

        Botao b0 = new Botao("0", expressao, resultado, this.getContext());
        principalBinding.zero.setOnClickListener(b0);

        Botao b1 = new Botao("1", expressao, resultado, this.getContext());
        principalBinding.um.setOnClickListener(b1);

        Botao b2 = new Botao("2", expressao, resultado, this.getContext());
        principalBinding.dois.setOnClickListener(b2);

        Botao b3 = new Botao("3", expressao, resultado, this.getContext());
        principalBinding.tres.setOnClickListener(b3);

        Botao b4 = new Botao("4", expressao, resultado, this.getContext());
        principalBinding.quatro.setOnClickListener(b4);

        Botao b5 = new Botao("5", expressao, resultado, this.getContext());
        principalBinding.cinco.setOnClickListener(b5);

        Botao b6 = new Botao("6", expressao, resultado, this.getContext());
        principalBinding.seis.setOnClickListener(b6);

        Botao b7 = new Botao("7", expressao, resultado, this.getContext());
        principalBinding.sete.setOnClickListener(b7);

        Botao b8 = new Botao("8", expressao, resultado, this.getContext());
        principalBinding.oito.setOnClickListener(b8);

        Botao b9 = new Botao("9", expressao, resultado, this.getContext());
        principalBinding.nove.setOnClickListener(b9);

        Botao bSubtrair = new Botao("-", expressao, resultado, this.getContext());
        principalBinding.subtrair.setOnClickListener(bSubtrair);

        Botao bSomar = new Botao("+", expressao, resultado, this.getContext());
        principalBinding.somar.setOnClickListener(bSomar);

        Botao bMultiplicar = new Botao("*", expressao, resultado, this.getContext());
        principalBinding.multiplicar.setOnClickListener(bMultiplicar);

        Botao bDividir = new Botao("/", expressao, resultado, this.getContext());
        principalBinding.dividir.setOnClickListener(bDividir);

        Botao bLimpar = new Botao("C", expressao, resultado, this.getContext());
        principalBinding.limpar.setOnClickListener(bLimpar);

        Botao bIgual = new Botao("=", expressao, resultado, this.getContext());
        principalBinding.igual.setOnClickListener(bIgual);

    }
}