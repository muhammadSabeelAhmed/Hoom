package app.discoveritech.hoom.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

import app.discoveritech.hoom.Activities.LoginActivity;
import app.discoveritech.hoom.Activities.MainActivity;
import app.discoveritech.hoom.Activities.SignupActivity;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.Presenter.SignupPresenter;
import app.discoveritech.hoom.R;
import app.discoveritech.hoom.View.ISignupView;

public class SignupFragment extends Fragment implements View.OnClickListener, ISignupView {
    View v;
    LinearLayout btn_signin, btn_address;
    EditText name, email, password, con_password;
    TextView address;
    CardView btn_signup;
    SignupPresenter signupPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_signup, container, false);
        init();
        return v;
    }

    private void init() {
        signupPresenter = new SignupPresenter(this);
        SignupActivity.toolbar.setVisibility(View.GONE);
        Global.device_back_tag = "SignupFragment";
        btn_signin = v.findViewById(R.id.Sbtn_signin);
        btn_address = v.findViewById(R.id.Sedit_address_layout);
        btn_signin.setOnClickListener(this);
        btn_address.setOnClickListener(this);
        name = v.findViewById(R.id.Sedit_name);
        email = v.findViewById(R.id.Sedit_email);
        password = v.findViewById(R.id.Sedit_password);
        con_password = v.findViewById(R.id.Sedit_con_password);
        address = v.findViewById(R.id.Sedit_address);
        btn_signup = v.findViewById(R.id.Sbtn_signup);
        btn_signup.setOnClickListener(this);
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
            case R.id.Sbtn_signup:
                if (password.length() >= 7) {
                    if (password.getText().toString().equals(con_password.getText().toString())) {
                        if (Global.addressArray.size() > 1) {
                            signupPresenter.onSignup(name.getText().toString(), password.getText().toString(), email.getText().toString(), Global.addressArray.get(0), Global.addressArray.get(2), Global.addressArray.get(3), Global.addressArray.get(1));
                        } else {
                            FancyToast.makeText(getActivity(), "Complete address required", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                        }
                    } else {
                        FancyToast.makeText(getActivity(), "The password must be at least 8 characters.", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                    }
                } else {
                    FancyToast.makeText(getActivity(), "Password should matched", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                }
                break;
        }
    }

    @Override
    public void onSignup(String message) {
        if (message.equals("Signup Success")) {
            FancyToast.makeText(getActivity(), "" + message, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
            Global.changeActivity(getActivity(), new MainActivity());
            getActivity().overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            getActivity().finish();
        } else {
            FancyToast.makeText(getActivity(), "" + message, FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
        }
    }
}