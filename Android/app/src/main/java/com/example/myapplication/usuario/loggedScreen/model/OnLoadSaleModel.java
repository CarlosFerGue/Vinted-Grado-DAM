package com.example.myapplication.usuario.loggedScreen.model;

import android.util.Log;

import com.example.myapplication.usuario.loggedScreen.ContractLoggedScreen;
import com.example.myapplication.usuario.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.usuario.loggedScreen.presenter.OnLoadSalePresenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnLoadSaleModel implements ContractLoggedScreen.Model {
    private OnLoadSalePresenter presenter;

    public OnLoadSaleModel(OnLoadSalePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadOnSaleAPI(int userId, loadOnSaleListener loadOnSaleListener) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call desde productos filter_usuario");
        Call<ArrayList<OnLoadSaleData>> call = apiService.getMySales("PRODUCTOS.FILTER_USUARIO", userId);
        System.out.println(userId);

        call.enqueue(new Callback<ArrayList<OnLoadSaleData>>() {
            @Override
            public void onResponse(Call<ArrayList<OnLoadSaleData>> call, Response<ArrayList<OnLoadSaleData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del filter es esto: " + response.body());
                    ArrayList<OnLoadSaleData> lstSales = response.body();
                    System.out.println(response.body());

                    for (OnLoadSaleData sale : lstSales) {
                        System.out.println(sale.toString());
                    }

                    if (lstSales.isEmpty()) {
                        loadOnSaleListener.onFailure("No tienes productos a la venta");
                    } else {
                        System.out.println("Has entrado en el onFinish de FILTER_USUARIO");
                        loadOnSaleListener.onFinished(lstSales);

                    }

                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<OnLoadSaleData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
