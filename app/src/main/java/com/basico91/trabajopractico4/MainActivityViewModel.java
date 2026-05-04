package com.basico91.trabajopractico4;

import android.app.Application;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;

public class MainActivityViewModel extends AndroidViewModel {

    public MutableLiveData eventoMostrarSalir = new MutableLiveData();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData getEventoMostrarSalir(){
        return eventoMostrarSalir;
    }

    public void manejarSeleccionMenu(MenuItem item, NavController navController) {
        if (item.getItemId() == R.id.nav_salir) {
            // Disparamos un evento para que la Activity muestre el diálogo
            eventoMostrarSalir.setValue(true);
        } else {
            // Si es cualquier otra cosa, navegamos normalmente
            NavigationUI.onNavDestinationSelected(item, navController);
        }
    }
}
