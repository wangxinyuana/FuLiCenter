package cn.ucai.fulicenter.model.utils;

import android.app.Activity;
import android.content.Intent;

import cn.ucai.fulicenter.R;


/**
 * Created by clawpo on 2016/12/27.
 */

public class MFGT {
    public static void finish(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }


    public static void startActivity(Activity context, Class<?> clz) {
        context.overridePendingTransition(R.anim.push_right_in, R.anim.push_bottom_out);
        context.startActivity(new Intent(context,clz));
    }

}