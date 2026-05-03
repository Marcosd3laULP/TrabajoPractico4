package com.basico91.trabajopractico4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.basico91.trabajopractico4.databinding.ItemProductosBinding;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {
    public List<Producto> listaProductos;

    public ProductoAdapter(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductosBinding binding = ItemProductosBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductoViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);

        holder.binding.tvDesc.setText((producto.getDescripcion()));
        holder.binding.tvCodigo.setText("Cod: " + producto.getCodigo());
        holder.binding.tvPrecio.setText("Precio: $" + producto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder{
        ItemProductosBinding binding;


        public ProductoViewHolder(@NonNull ItemProductosBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
