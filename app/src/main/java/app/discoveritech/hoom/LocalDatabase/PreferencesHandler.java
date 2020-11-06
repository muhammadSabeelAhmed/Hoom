package app.discoveritech.hoom.LocalDatabase;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHandler {

    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;
    private static final String ACHIEVEMENTS = "noachievements";
    private static final String APP_FIRST_TIME = "app_first_time";
    private static final String UEMAIL = "uemail";
    private static final String UNAME = "uname";
    private static final String UCONTACT = "ucontact";
    private static final String UPWD = "upwd";
    private static final String ISAUTOCHECK = "isautocheck";
    private static final String CHECK_DATE = "01-01-2020";
    private static final String CURRENT_DATE = "current_date";
    public static final String ACCOUNT_EXPIRE = "account_expire";
    public static final String RATE_THIS_APP_COUNT = "0";
    public static final String RATE_THIS_APP_VALUE_SET = "3";
    public static final String BASEURL = "baseurl";
    public static final String ISSKIP = "isskip";
    public static final String ISFTV = "isftv";
    public static final String DISCOUNT_OFFERED = "";
    public static final String USER_NAME = "";
    public static final String USER_PASSWORD = "";
    public static final String TOKEN = "token";

    public PreferencesHandler() {

    }

    public PreferencesHandler(Context context) {
        pref = context.getSharedPreferences("hoom_app", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public String getDiscountOffered() {
        return pref.getString(DISCOUNT_OFFERED, "0");
    }

    public void setDiscountOffered(String discountOffered) {
        editor.putString(DISCOUNT_OFFERED, discountOffered);
        editor.apply();
        editor.commit();
    }

    public String getAppFirstTime() {
        return pref.getString(APP_FIRST_TIME, "true");
    }

    public void setAppFirstTime(String appFirstTime) {
        editor.putString(APP_FIRST_TIME, appFirstTime);
        editor.apply();
        editor.commit();
    }

    public String getUemail() {
        return pref.getString(UEMAIL, "");
    }

    public void setUemail(String uemail) {
        editor.putString(UEMAIL, uemail);
        editor.apply();
        editor.commit();
    }

    public String getUcontact() {
        return pref.getString(UCONTACT, "");
    }

    public void setUcontact(String ucontact) {
        editor.putString(UCONTACT, ucontact);
        editor.apply();
        editor.commit();
    }

    public String getUname() {
        return pref.getString(UNAME, "CLIENT");
    }

    public void setUname(String uname) {
        editor.putString(UNAME, uname);
        editor.apply();
        editor.commit();
    }

    public String getUpwd() {
        return pref.getString(UPWD, "");
    }

    public void setUpwd(String upwd) {
        editor.putString(UPWD, upwd);
        editor.apply();
        editor.commit();
    }

    public String getIsautocheck() {
        return pref.getString(ISAUTOCHECK, "false");
    }

    public void setIsautocheck(String isautocheck) {
        editor.putString(ISAUTOCHECK, isautocheck);
        editor.apply();
        editor.commit();
    }

    public String getDate() {
        return pref.getString(CHECK_DATE, "false");
    }

    public void setDate(String date) {
        editor.putString(CHECK_DATE, date);
        editor.apply();
        editor.commit();
    }

    public String getRateThisAppCount() {
        return pref.getString(RATE_THIS_APP_COUNT, "0");
    }

    public void setRateThisAppCount(String count) {
        editor.putString(RATE_THIS_APP_COUNT, count);
        editor.apply();
        editor.commit();
    }

    public String getAchievements() {
        return pref.getString(ACHIEVEMENTS, "no");
    }

    public void setAchievements(String achievements) {
        editor.putString(ACHIEVEMENTS, achievements);
        editor.apply();
        editor.commit();
    }


    public String getRateThisAppValueSet() {
        return pref.getString(RATE_THIS_APP_VALUE_SET, "4");
    }

    public void setRateThisAppValueSet(String value) {
        editor.putString(RATE_THIS_APP_VALUE_SET, value);
        editor.apply();
        editor.commit();
    }


    public String getCurrentDate() {
        return pref.getString(CURRENT_DATE, "");
    }

    public void setCurrentDate(String currentDate) {
        editor.putString(CURRENT_DATE, currentDate);
        editor.apply();
        editor.commit();
    }

    public String getAccountExpire() {
        return pref.getString(ACCOUNT_EXPIRE, "false");
    }

    public void setAccountExpire(String accountExpire) {
        editor.putString(ACCOUNT_EXPIRE, accountExpire);
        editor.apply();
        editor.commit();
    }

    public String getBaseUrl() {
        return pref.getString(BASEURL, "");
    }

    public void setBaseurl(String baseurl) {
        editor.putString(BASEURL, baseurl);
        editor.apply();
        editor.commit();
    }

    public String getIsskip() {
        return pref.getString(ISSKIP, "no");
    }

    public void setIsskip(String isskip) {
        editor.putString(ISSKIP, isskip);
        editor.apply();
        editor.commit();
    }

    public String getIsftv() {
        return pref.getString(ISFTV, "no");
    }

    public void setIsftv(String isftv) {
        editor.putString(ISFTV, isftv);
        editor.apply();
        editor.commit();
    }

    public String getBearerToken() {
        return pref.getString(TOKEN, "");
    }

    public void setBearerToken(String bearerToken) {
        editor.putString(TOKEN, bearerToken);
        editor.apply();
        editor.commit();
    }
}


