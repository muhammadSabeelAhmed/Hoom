package app.discoveritech.hoom.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements IUser {
    private String token;
    private String name;
    private String email;
    private String password;
    private String address;
    private String message;
    private String town_id;
    private String postcode;

    public User(String name, String password, String email, String town_id, String address, String postcode) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.town_id = town_id;
        this.postcode = postcode;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setTown_id(String town_id) {
        this.town_id = town_id;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getTown_id() {
        return town_id;
    }

    @Override
    public String getPostcode() {
        return postcode;
    }

    @Override
    public boolean validateSignin() {
        return !(TextUtils.isEmpty(getEmail()) && TextUtils.isEmpty(getPassword())) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }

    @Override
    public boolean validateSignup() {
        return !(TextUtils.isEmpty(getName()) && TextUtils.isEmpty(getEmail()) && TextUtils.isEmpty(getPassword()) && TextUtils.isEmpty(getAddress()) && TextUtils.isEmpty(getTown_id()) && TextUtils.isEmpty(getPostcode())) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }
}
