package cn.ucai.fulicenter.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.FuLiCenterApplication;
import cn.ucai.fulicenter.application.I;

import cn.ucai.fulicenter.model.bean.User;
import cn.ucai.fulicenter.model.net.SharePrefrenceUtils;
import cn.ucai.fulicenter.model.utils.CommonUtils;
import cn.ucai.fulicenter.model.utils.ImageLoader;

import cn.ucai.fulicenter.model.utils.L;
import cn.ucai.fulicenter.model.utils.OnSetAvatarListener;
import cn.ucai.fulicenter.view.DisplayUtils;
import cn.ucai.fulicenter.view.MFGT;

/**
 * Created by Administrator on 2017/1/19.
 */

public class SetitingsActivity extends AppCompatActivity {
    private static final String TAG = SetitingsActivity.class.getSimpleName();
    @BindView(R.id.iv_user_profile_avatar)
    ImageView mIvUserProfileAvatar;
    @BindView(R.id.iv_user_profile_name)
    TextView mIvUserProfileName;
    @BindView(R.id.tv_user_profile_nick)
    TextView mTvUserProfileNick;
    OnSetAvatarListener mOnsSetAvatarListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        DisplayUtils.initBackWithTitle(this, "设置");
        initData();
    }

    private void initData() {
        User user = FuLiCenterApplication.getUser();
        if (user != null) {
            loadUserInfo(user);
        } else {
            MFGT.gotoLogin(this);
        }
    }

    private void loadUserInfo(User user) {
        ImageLoader.setAvatar(ImageLoader.getAvatarUrl(user), this, mIvUserProfileAvatar);
        mIvUserProfileName.setText(user.getMuserName());
        mTvUserProfileNick.setText(user.getMuserNick());
    }


    @OnClick(R.id.btn_logout)
    public void logout() {
        FuLiCenterApplication.setUser(null);
        SharePrefrenceUtils.getInstance(this).removeUser();
        MFGT.gotoLogin(this);
        finish();
    }

    @OnClick(R.id.layout_user_profile_nickname)
    public void updateNick() {
        MFGT.gotoUpDataNick(this);
    }
    @OnClick
    protected void onClickUserName(){
        CommonUtils.showLongToast(R.string.username_connot_be_modify);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        L.e(TAG,"onActivityResult,resultCode="+resultCode+",RESULT_OK="+RESULT_OK+",requestCode="+requestCode+
                "user="+FuLiCenterApplication.getUser());
        if (resultCode==RESULT_OK && requestCode==I.REQUEST_CODE_NICK){
            mTvUserProfileNick.setText(FuLiCenterApplication.getUser().getMuserNick());
        }
    }

    @OnClick(R.id.layout_user_profile_avatar)
    public void onClickAvatar() {
        mOnsSetAvatarListener=new OnSetAvatarListener(this,
                R.id.layout_user_profile_avatar,
               FuLiCenterApplication.getUser().getMuserName(),
                I.AVATAR_TYPE_USER_PATH);
    }

    }

