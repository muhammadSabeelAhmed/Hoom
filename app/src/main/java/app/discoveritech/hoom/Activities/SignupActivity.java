package app.discoveritech.hoom.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.shashank.sony.fancytoastlib.FancyToast;

import app.discoveritech.hoom.Fragments.AddressFragment;
import app.discoveritech.hoom.Fragments.SignupFragment;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.Presenter.SignupPresenter;
import app.discoveritech.hoom.R;
import app.discoveritech.hoom.View.ISignupView;

public class SignupActivity extends AppCompatActivity {
    FragmentManager fm;
    public static RelativeLayout toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
    }

    private void init() {
        fm = getSupportFragmentManager();
        toolbar = findViewById(R.id.signup_toolbar);

        Global.changeFragment(SignupActivity.this, new SignupFragment(), "", "");
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        if (Global.device_back_tag.equals("SignupFragment")) {
            SignupActivity.toolbar.setVisibility(View.GONE);
            Global.changeActivity(SignupActivity.this, new LoginActivity());
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        } else {
            toolbar.setVisibility(View.GONE);
            fm.popBackStack();

        }
    }

}