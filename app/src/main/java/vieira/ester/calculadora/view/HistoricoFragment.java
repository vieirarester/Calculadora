package vieira.ester.calculadora.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.calculadora.R;
import com.example.calculadora.databinding.FragmentHistoricoBinding;

import java.util.ArrayList;

import vieira.ester.calculadora.model.Calculo;
import vieira.ester.calculadora.model.CalculoDao;
import vieira.ester.calculadora.model.DatabaseSingleton;

public class HistoricoFragment extends Fragment {

    FragmentHistoricoBinding historicoBinding;
    CalculoDao calculoDao;
    ArrayList<Calculo> calculos;
    ArrayList<String> calculosString;
    ArrayAdapter<String> adapter;

    public HistoricoFragment() {
        super(R.layout.fragment_historico);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        historicoBinding = FragmentHistoricoBinding.inflate(inflater, container, false);
        return historicoBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        calculoDao = DatabaseSingleton.getInstance(this.getContext()).appDatabase.calculoDao();
        calculos = (ArrayList<Calculo>) calculoDao.listarTodos();
        calculosString = new ArrayList<>();

        for(Calculo calculo: calculos){
            calculosString.add(calculo.toString());
        }

        adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, calculosString);
        historicoBinding.listViewHistorico.setAdapter(adapter);

        historicoBinding.listViewHistorico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                calculoDao.deletar(calculos.get(i));
                calculos = (ArrayList<Calculo>) calculoDao.listarTodos();

                calculosString = new ArrayList<>();
                for (Calculo calculo: calculos) {
                    calculosString.add(calculo.toString());
                }

                adapter.clear();
                adapter.addAll(calculosString);
                adapter.notifyDataSetChanged();

                historicoBinding.listViewHistorico.setAdapter(adapter);;

            }
        });

    }
}