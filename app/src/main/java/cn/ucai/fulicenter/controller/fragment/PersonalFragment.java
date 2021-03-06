package cn.ucai.fulicenter.controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.FuLiCenterApplication;
import cn.ucai.fulicenter.model.bean.User;
import cn.ucai.fulicenter.model.utils.ImageLoader;
import cn.ucai.fulicenter.model.utils.L;
import cn.ucai.fulicenter.view.MFGT;


/**
 * Created by Administrator on 2017/1/13.
 */

public class PersonalFragment extends Fragment {
    private static final String TAG = PersonalFragment.class.getSimpleName();
    @BindView(R.id.iv_user_avatar)
    ImageView mIvUserAvatar;
    @BindView(R.id.tv_user_name)
    TextView mTvUserName;
    @BindView(R.id.tv_center_settings)
    TextView mTvCenterSettings;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_personal, container, false);
        ButterKnife.bind(this, layout);
        initData();
        return layout;
    }

    private void initData() {
        User user = FuLiCenterApplication.getUser();
        L.e(TAG, "user" + user);
        if (user != null) {
            loadUserInfo(user);
        } else {
            MFGT.gotoLogin(getActivity());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void loadUserInfo(User user) {
        ImageLoader.downloadImg(getContext(), mIvUserAvatar, user.getAvatarPath());
        mTvUserName.setText(user.getMuserNick());
    }


    @OnClick({R.id.tv_center_settings,R.id.center_user_info})
    public void  onClick(View v){
        Toast.makeText(getActivity(),"跳转到设置",Toast.LENGTH_SHORT).show();
       MFGT.gotoSettings(getActivity());
    }
}
