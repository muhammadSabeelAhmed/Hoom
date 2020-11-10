package app.discoveritech.hoom.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.discoveritech.hoom.Adapter.ComapniesAdapter;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.Model.Companies;
import app.discoveritech.hoom.R;
import app.discoveritech.hoom.View.ICompaniesView;

import static app.discoveritech.hoom.Activities.MainActivity.txt_mainToolbar;

public class CompaniesFragment extends Fragment implements ICompaniesView {

    View v;
    RecyclerView comp_recycler;
    ComapniesAdapter comapniesAdapter;
    ArrayList<Companies> companies = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_companies, container, false);
        init();
        return v;
    }

    private void init() {
        txt_mainToolbar.setText(this.getArguments().getString("service_id"));
        companies.addAll(Global.companiesList);
        Log.d("CompaniesArray", "" + companies.size());
        Global.device_back_tag = "CompaniesFragment";
        Global.mKProgressHUD.dismiss();

        comp_recycler = v.findViewById(R.id.companies_recycler);
        comapniesAdapter = new ComapniesAdapter(companies);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        comp_recycler.setLayoutManager(mLayoutManager);
        comp_recycler.setItemAnimator(new DefaultItemAnimator());
        comp_recycler.setAdapter(comapniesAdapter);
        comapniesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onComapnies(String message) {

    }
}