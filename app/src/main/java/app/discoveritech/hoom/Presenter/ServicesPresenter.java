package app.discoveritech.hoom.Presenter;

import android.content.Context;

import app.discoveritech.hoom.APIConfig.PostWebDataAPI;
import app.discoveritech.hoom.Model.Services;
import app.discoveritech.hoom.View.IServiceView;

public class ServicesPresenter implements IServicesPresenter {
    IServiceView serviceView;
    PostWebDataAPI postWebDataAPI;

    public ServicesPresenter(IServiceView serviceView) {
        postWebDataAPI = new PostWebDataAPI(serviceView);
        this.serviceView = serviceView;
    }

    @Override
    public void onGetServices(String token, String company_id) {
        postWebDataAPI.getServices(token, company_id);
    }
}
