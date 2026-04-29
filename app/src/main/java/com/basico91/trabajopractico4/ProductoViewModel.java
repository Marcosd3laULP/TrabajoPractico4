package com.basico91.trabajopractico4;

import android.app.Application;
import android.renderscript.ScriptGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ProductoViewModel extends AndroidViewModel {

    private MutableLiveData<Producto> productoMutable = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Producto>> listaProductosM = new MutableLiveData<>();
    public ProductoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Producto> getProductoMutable(){
        return productoMutable;
    }

    public LiveData<ArrayList<Producto>> getListaProductosM(){
        return listaProductosM;
    }

    public String guardarProducto(String code, String descri, String price){
        if(code == null && code.isEmpty()){
        return "Debe completar todos los campos";
        }
            int codigo = Integer.parseInt(code);
            double precio = Double.parseDouble(price);

        for(Producto p : MainActivity.listaProductos){
            if(p.getCodigo() == codigo){
                return "El codigo ya existe";
            }
        }
        MainActivity.listaProductos.add(new Producto(codigo, descri, precio));
        return "ok";
    }

    public void ordenarProductos(){
        ArrayList<Producto> listaActual = new ArrayList<>(MainActivity.listaProductos);

        Collections.sort(listaActual, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getDescripcion().compareToIgnoreCase(o2.getDescripcion());
            }
        });
        listaProductosM.setValue(listaActual);
    }
}
