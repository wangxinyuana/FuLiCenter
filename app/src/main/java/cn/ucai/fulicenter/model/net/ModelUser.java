package cn.ucai.fulicenter.model.net;

import android.content.Context;

import cn.ucai.fulicenter.application.I;
import cn.ucai.fulicenter.model.utils.MD5;
import cn.ucai.fulicenter.model.utils.OkHttpUtils;

/**
 * Created by Administrator on 2017/1/16.
 */

public class ModelUser implements IModelUser {
    @Override
    public void login(Context context, String uesrName, String password, OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_LOGIN)
                .addParam(I.User.USER_NAME,uesrName)
                .addParam(I.User.PASSWORD, MD5.getMessageDigest(password))
                .targetClass(String.class)
                .execute(listener);

    }
    //注册用post，登陆用gst

    @Override
    public void register(Context context, String uesrName, String userNick, String password, OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_REGISTER)
                .addParam(I.User.USER_NAME,uesrName)
                .addParam(I.User.NICK, userNick)
                .addParam(I.User.PASSWORD, MD5.getMessageDigest(password))
                .post()
                .targetClass(String.class)
                .execute(listener);
    }
}
