package app.discoveritech.hoom.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;

import app.discoveritech.hoom.Activities.LoginActivity;
import app.discoveritech.hoom.Activities.SignupActivity;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.R;

public class AddressFragment extends Fragment implements View.OnClickListener {
    View v;
    Spinner dropdown;
    ArrayList<String> townArray = new ArrayList<String>();
    CardView btn_save;
    EditText street, house, zip;
    String txt_town, txt_street, txt_house, txt_zip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_address, container, false);
        init();
        return v;
    }

    private void init() {
        addItems();
        Global.device_back_tag = "AddressFragment";
        dropdown = v.findViewById(R.id.A_dropdown);
        dropdown.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);

        btn_save = v.findViewById(R.id.Abtn_save);
        btn_save.setOnClickListener(this);

        street = v.findViewById(R.id.Aedit_street);
        house = v.findViewById(R.id.Aedit_house);
        zip = v.findViewById(R.id.Aedit_zip);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.simple_list_item, townArray) {
            @Override
            public int getCount() {
                // to show hint "Select Gender" and don't able to select
                return townArray.size() - 1;
            }
        };
        dropdown.setAdapter(adapter);
        dropdown.setSelection(townArray.size() - 1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SignupActivity.toolbar.setVisibility(View.VISIBLE);
            }
        }, 200);
    }

    private void addItems() {
        for (int i = 0; i < Global.townsList.size(); i++) {
            townArray.add(Global.townsList.get(i).getName());
        }
        townArray.add("Town");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Abtn_save:
                if (validateAddress()) {
                    Global.addressArray.clear();
                    for (int i = 0; i < Global.townsList.size(); i++) {
                        if (Global.townsList.get(i).getName().equals(txt_town)) {
                            Global.addressArray.add(0, Global.townsList.get(i).getId());
                        }
                    }
                    Global.addressArray.add(1, txt_street);
                    Global.addressArray.add(2, txt_house);
                    Global.addressArray.add(3, txt_zip);
                }
                break;
        }
    }

    private boolean validateAddress() {
        boolean validate = true;
        txt_town = dropdown.getSelectedItem().toString();
        txt_street = street.getText().toString();
        txt_house = house.getText().toString();
        txt_zip = zip.getText().toString();

        if (txt_town.isEmpty() || txt_town.equals("Town")) {
            FancyToast.makeText(getActivity(), "Please select Town", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
            validate = false;
        } /*else if (txt_street.isEmpty() || txt_street.equals("Street")) {
            FancyToast.makeText(getActivity(), "Please enter Street or Block No.", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
            validate = false;
        }*/ else if (txt_house.isEmpty() || txt_house.equals("House")) {
            FancyToast.makeText(getActivity(), "Please enter House No.", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
            validate = false;
        } else if (txt_zip.isEmpty()) {
            FancyToast.makeText(getActivity(), "Please enter Postal code", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
            validate = false;
        }
        return validate;
    }
}