package cn.ucai.fulicenter.controller.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.view.MFGT;

/**
 * Created by Administrator on 2017/1/17.
 */
public class RegisterActivity extends AppCompatActivity {

/*
    @BindView(R.id.backClickArea)
    ImageView mBackClickArea;
    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.nick)
    EditText mNick;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.confirm_password)
    EditText mConfirmPassword;*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

  /*  @OnClick({R.id.backClickArea, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backClickArea:
                MFGT.finish(this);
                break;
            case R.id.btn_register:
                checkInput();
                break;
        }
    }*/
   /* private void checkInput() {
        String username=mUsername.getText().toString().trim();
        String usernick=mNick.getText().toString().trim();
        String password=mPassword.getText().toString().trim();
        String confirm=mConfirmPassword.getText().toString().trim();

    }*/

}


