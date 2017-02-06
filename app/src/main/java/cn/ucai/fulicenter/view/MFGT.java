package cn.ucai.fulicenter.view;

import android.app.Activity;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.support.v4.app.FragmentActivity;

import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.I;
import cn.ucai.fulicenter.controller.activity.LoginActivity;
import cn.ucai.fulicenter.controller.activity.MainActivity;
import cn.ucai.fulicenter.controller.activity.RegisterActivity;
import cn.ucai.fulicenter.controller.activity.SetitingsActivity;
import cn.ucai.fulicenter.controller.activity.UpdataNickActivity;

/**
 * Created by Administrator on 2017/1/10 0010.
 */
public class MFGT {
    public static void finish(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);

    }
    public static void startActivity(Activity context, Class<?> clz) {
        context.startActivity(new Intent(context,clz));
        context.overridePendingTransition(R.anim.push_right_in, R.anim.push_bottom_out);

    }


    public static void startActivity(Activity context,Intent intent){
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);

    }


    public static void gotoLogin(Activity context) {
       context.startActivityForResult(new Intent(context,LoginActivity.class), I.REQUEST_CODE_LOGIN);
    }

    public static void gotoRegister(LoginActivity loginActivity) {
        startActivity(loginActivity, RegisterActivity.class);
    }

    public static void gotoSettings(Activity activity) {
        startActivity(activity, SetitingsActivity.class);
    }


    public static void gotoUpDataNick(Activity activity) {
        activity.startActivityForResult(new Intent(activity,UpdataNickActivity.class),I.REQUEST_CODE_NICK);
    }
}
