package vieira.ester.calculadora.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculadora.R;
import com.example.calculadora.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {

    FragmentMenuBinding menuBinding;

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        menuBinding = FragmentMenuBinding.inflate(inflater, container, false);
        return menuBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menuBinding.entrar.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.principalFragment, null));
        menuBinding.historico.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.historicoFragment, null));
    }
}