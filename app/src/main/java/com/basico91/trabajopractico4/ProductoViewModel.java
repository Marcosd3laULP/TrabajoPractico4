package com.basico91.trabajopractico4;

import android.app.Application;
import android.renderscript.ScriptGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class ProductoViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Producto>> productoMutable = new MutableLiveData<>();
    public ProductoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Producto>> getProductoMutable(){
        return productoMutable;
    }

    public String guardarProductos(String code, String desc, String prec){
        if(code == null && code.isEmpty()) {
            return "complete todos los campos";
        }
        int codigo = Integer.parseInt(code);
        double precio = Double.parseDouble(prec);

        return code;
    }
}
