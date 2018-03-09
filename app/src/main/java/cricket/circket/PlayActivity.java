package cricket.circket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mContext=PlayActivity.this;

       // mLogin =  findViewById(R.id.login);
        mRegister =  findViewById(R.id.loginbut);
        //mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginbut:
startActivity(new Intent(mContext,WelcomeActivity.class));
                break;
        }
    }
}
