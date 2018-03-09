package cricket.circket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    AppCompatButton mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext=RegisterActivity.this;

       // mLogin =  findViewById(R.id.login);
        mRegister =  findViewById(R.id.register);
        //mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                Intent play=new Intent(mContext,LoginActivity.class);
                startActivity(play);
                break;
        }
    }
}
