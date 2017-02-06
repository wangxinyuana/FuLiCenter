package cn.ucai.fulicenter.view;

import android.app.Activity;
import android.widget.TextView;

import cn.ucai.fulicenter.R;

/**
 * Created by Administrator on 2017/1/20.
 */

public class DisplayUtils {
    public static void initBack(Activity activity){
        activity.finish();
    }
    public static void initBackWithTitle(Activity activity,String title){
       // TextView textView=(TextView) activity.findViewById(R.id.layout_title);
        //textView.setText(title);
        initBack(activity);
    }


}
