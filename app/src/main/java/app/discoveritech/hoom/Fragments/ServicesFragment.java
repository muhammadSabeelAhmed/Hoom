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
import app.discoveritech.hoom.Adapter.ServicesAdapter;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.Model.Companies;
import app.discoveritech.hoom.Model.Services;
import app.discoveritech.hoom.R;

import static app.discoveritech.hoom.Activities.MainActivity.txt_mainToolbar;

public class ServicesFragment extends Fragment {

    View v;
    RecyclerView service_recycler;
    ServicesAdapter servicesAdapter;
    ArrayList<Services> services = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_services, container, false);
        init();
        return v;
    }

    private void init() {
        txt_mainToolbar.setText("Request your Quotation");
        services.clear();
        services.addAll(Global.servicesList);
        Log.d("ServicesArray", "" + services.size());
        Global.device_back_tag = "ServicesFragment";
        Global.mKProgressHUD.dismiss();
        service_recycler = v.findViewById(R.id.services_recycler);
        servicesAdapter = new ServicesAdapter(services,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        service_recycler.setLayoutManager(mLayoutManager);
        service_recycler.setItemAnimator(new DefaultItemAnimator());
        service_recycler.setAdapter(servicesAdapter);
        servicesAdapter.notifyDataSetChanged();
    }
}