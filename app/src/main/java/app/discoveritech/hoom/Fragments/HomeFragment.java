package app.discoveritech.hoom.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.shashank.sony.fancytoastlib.FancyToast;

import app.discoveritech.hoom.APIConfig.PostWebDataAPI;
import app.discoveritech.hoom.Activities.SignupActivity;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.LocalDatabase.PreferencesHandler;
import app.discoveritech.hoom.Presenter.CompaniesPresenter;
import app.discoveritech.hoom.R;
import app.discoveritech.hoom.View.ICompaniesView;

public class HomeFragment extends Fragment implements View.OnClickListener, ICompaniesView {
    View v;
    CardView btn_lawn, btn_plumbing, btn_ac;
    PostWebDataAPI postWebDataAPI;
    PreferencesHandler preferencesHandler;
    CompaniesPresenter companiesPresenter;
    private String service_id = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        return v;
    }

    private void init() {
        companiesPresenter = new CompaniesPresenter(this);
        preferencesHandler = new PreferencesHandler();
        postWebDataAPI = new PostWebDataAPI();
        btn_plumbing = v.findViewById(R.id.btn_plumbing);
        btn_lawn = v.findViewById(R.id.btn_lawnmoving);
        btn_ac = v.findViewById(R.id.btn_ac);

        btn_plumbing.setOnClickListener(this);
        btn_lawn.setOnClickListener(this);
        btn_ac.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Global.mKProgressHUD.show();
        switch (v.getId()) {
            case R.id.btn_lawnmoving:
                service_id = "1";
                companiesPresenter.onCompanies(preferencesHandler.getBearerToken(), service_id);
                break;
            case R.id.btn_plumbing:
                service_id = "2";
                companiesPresenter.onCompanies(preferencesHandler.getBearerToken(), service_id);
                break;
            case R.id.btn_ac:
                service_id = "3";
                companiesPresenter.onCompanies(preferencesHandler.getBearerToken(), service_id);
                break;
        }
    }

    private void openCompany() {
        Global.changeMainFragment(getActivity(), new CompaniesFragment(), "service_id", service_id);
    }

    @Override
    public void onComapnies(String message) {
        if (message.equals("Looking for Lawnmoving")) {
            FancyToast.makeText(getActivity(), "" + message, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
            openCompany();
        } else {
            FancyToast.makeText(getActivity(), "" + message, FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
        }
    }
}