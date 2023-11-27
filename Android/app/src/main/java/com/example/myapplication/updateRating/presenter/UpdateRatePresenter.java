package com.example.myapplication.updateRating.presenter;

import com.example.myapplication.beans.Producto;
import com.example.myapplication.updateRating.ContractUpdateRating;
import com.example.myapplication.updateRating.data.UpdateRateData;
import com.example.myapplication.updateRating.model.UpdateRateModel;

public class UpdateRatePresenter implements ContractUpdateRating.Presenter, ContractUpdateRating.Model.UpdateRatingListener {
    ContractUpdateRating.View view;
    ContractUpdateRating.Model model;

    public UpdateRatePresenter(ContractUpdateRating.View view) {
        this.view = view;
        model = new UpdateRateModel(this);
    }

    @Override
    public void onFinishedRating(UpdateRateData updateRategData) {

    }

    @Override
    public void onFailureRating(String error) {

    }

    @Override
    public void updateRating(Producto producto) {
        System.out.println("Love and sex");
        model.updateRatingAPI(producto, this);

    }
}
