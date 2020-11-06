package app.discoveritech.hoom.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import app.discoveritech.hoom.Activities.LoginActivity;
import app.discoveritech.hoom.Activities.SignupActivity;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.R;

public class SignupFragment extends Fragment implements View.OnClickListener {
    View v;
    LinearLayout btn_signin, btn_address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_signup, container, false);
        init();
        return v;
    }

    private void init() {
        SignupActivity.toolbar.setVisibility(View.GONE);
        Global.device_back_tag = "SignupFragment";
        btn_signin = v.findViewById(R.id.Sbtn_signin);
        btn_address = v.findViewById(R.id.Sedit_address_layout);
        btn_signin.setOnClickListener(this::onClick);
        btn_address.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Sbtn_signin:
                SignupActivity.toolbar.setVisibility(View.GONE);
                Global.changeActivity(getActivity(), new LoginActivity());
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                getActivity().finish();
                break;
            case R.id.Sedit_address_layout:
                Global.changeFragment(getActivity(), new AddressFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}