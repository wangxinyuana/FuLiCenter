package cn.ucai.fulicenter.model.net;

import android.content.Context;

import cn.ucai.fulicenter.model.bean.CategoryChildBean;
import cn.ucai.fulicenter.model.bean.CategoryGroupBean;
import cn.ucai.fulicenter.model.utils.OkHttpUtils;


/**
 * Created by Administrator on 2017/1/11 0011.
 */

public interface IModelUser {
    void login(Context context, String uesrName, String password, OkHttpUtils.OnCompleteListener<String> listener);
    void register(Context context, String uesrName, String userNick,String password,OkHttpUtils.OnCompleteListener<String> listener);
}
