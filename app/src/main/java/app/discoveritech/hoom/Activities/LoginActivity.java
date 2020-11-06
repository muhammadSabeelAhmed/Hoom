package app.discoveritech.hoom.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import app.discoveritech.hoom.APIConfig.PostWebDataAPI;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.Presenter.LoginPresenter;
import app.discoveritech.hoom.R;
import app.discoveritech.hoom.View.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    LinearLayout btn_signup;
    CardView btn_signin;
    LoginPresenter loginPresenter;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        loginPresenter = new LoginPresenter(this);
        btn_signup = findViewById(R.id.Lbtn_signup);
        btn_signup.setOnClickListener(this::onClick);
        btn_signin = findViewById(R.id.Lbtn_signin);
        btn_signin.setOnClickListener(this::onClick);
        email = findViewById(R.id.Ledit_email);
        password = findViewById(R.id.Ledit_password);
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onLogin(String message) {
        if (message.equals("Login Success")) {
            FancyToast.makeText(LoginActivity.this, "" + message, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
            Global.changeActivity(LoginActivity.this, new MainActivity());
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        } else {
            FancyToast.makeText(LoginActivity.this, "" + message, FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Lbtn_signin:
                loginPresenter.onLogin(email.getText().toString(), password.getText().toString());
                break;
            case R.id.Lbtn_signup:
                Global.changeActivity(LoginActivity.this, new SignupActivity());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                break;
        }
    }
}