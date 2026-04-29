package com.basico91.trabajopractico4;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basico91.trabajopractico4.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private ProductoViewModel productovm;
    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

    binding = FragmentCargarBinding.inflate(inflater, container, false);
    return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstancesState) {
        super.onViewCreated(view, saveInstancesState);

        productovm = new ViewModelProvider(this).get(ProductoViewModel.class);

        binding.btGuardar.setOnClickListener(v -> {
            String codStr = binding.etCodigo.getText().toString();
            String desc = binding.etDesc.getText().toString();
            String preStr = binding.etPrecio.getText().toString();

            String resultado = productovm.guardarProducto(codStr, desc, preStr);

            if(resultado.equals("ok")) {
                Toast.makeText(getContext(), "Producto guardado con exito", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            } else {
                Toast.makeText(getContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
    private void limpiarCampos(){
        binding.etCodigo.setText("");
        binding.etDesc.setText("");
        binding.etPrecio.setText("");
        binding.etCodigo.requestFocus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}