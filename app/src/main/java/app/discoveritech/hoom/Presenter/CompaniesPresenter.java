package app.discoveritech.hoom.Presenter;

import app.discoveritech.hoom.APIConfig.PostWebDataAPI;
import app.discoveritech.hoom.View.ICompaniesView;

public class CompaniesPresenter implements ICompaniesPresenter {
    ICompaniesView iCompaniesView;
    PostWebDataAPI postWebDataAPI;

    public CompaniesPresenter(ICompaniesView iCompaniesView) {
        this.iCompaniesView = iCompaniesView;
        postWebDataAPI = new PostWebDataAPI(iCompaniesView);
    }

    @Override
    public void onCompanies(String token, String service_id) {
        postWebDataAPI.getCompanies(token, service_id);
    }
}
