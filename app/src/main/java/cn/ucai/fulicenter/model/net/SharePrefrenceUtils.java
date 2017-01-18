package cn.ucai.fulicenter.model.net;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/1/17.
 */

public class SharePrefrenceUtils {
    private static final String SHARE_PREFERENCE_NAME="cn.user.fulicenter_user";
    private static final String SHARE_PREFERENCE_NAME_USERNAME="cn.user.fulicenter_user_username";
    private static SharePrefrenceUtils instance;
    private SharedPreferences prefrences;

    public SharePrefrenceUtils(Context context) {
        prefrences= context.getSharedPreferences(SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static  SharePrefrenceUtils getInstance(Context context){
        if (instance==null){
           instance =new SharePrefrenceUtils(context);

        }
        return instance;
    }
    public void saveUser(String username){
        prefrences.edit().putString(SHARE_PREFERENCE_NAME_USERNAME,username).commit();
    }
    public String getUser(){
        return  prefrences.getString(SHARE_PREFERENCE_NAME_USERNAME,null);
    }
}
