package com.basico91.trabajopractico4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.basico91.trabajopractico4.databinding.FragmentProductosBinding;

public class ProductosFragment extends Fragment {
    private FragmentProductosBinding binding;
    private ProductoViewModel viewmodel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProductosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerviewTransform.setLayoutManager(new LinearLayoutManager(getContext()));

        viewmodel = new ViewModelProvider(this).get(ProductoViewModel.class);

        viewmodel.getListaProductosM().observe(getViewLifecycleOwner(), productos -> {
            ProductoAdapter adapter = new ProductoAdapter(productos);
            binding.recyclerviewTransform.setAdapter(adapter);
        });
        viewmodel.ordenarProductos();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
