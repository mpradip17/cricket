package cricket.circket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class BeginActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    AppCompatButton mLogin,mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beign);
        mContext=BeginActivity.this;

        mLogin =  findViewById(R.id.login);
        mRegister =  findViewById(R.id.register);
        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                Intent login=new Intent(mContext,LoginActivity.class);
                startActivity(login);

                break;
            case R.id.register:
                Intent i=new Intent(mContext,RegisterActivity.class);
                startActivity(i);
                break;
        }
    }
}
