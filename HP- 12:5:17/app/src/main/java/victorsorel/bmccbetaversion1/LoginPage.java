package victorsorel.bmccbetaversion1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button Login;
    private Button ForgotPassword;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Username = (EditText) findViewById(R.id.UserField);
        Password = (EditText) findViewById(R.id.PasswordField);
        Login = (Button) findViewById(R.id.LoginButton);
        ForgotPassword = (Button) findViewById(R.id.ForgotPassButton);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(),Password.getText().toString());
            }
        });
    }
    private void validate (String userName, String userPassword){
        if ((userName == "Admin") && (userPassword == "bmcc123")){
            Intent intent = new Intent (LoginPage.this, HomePage.class)
                    startActivity(intent);
        }else{
            counter--;
            if (counter == 0){
                Login.setEnabled(false);
            }
        }

    }
}
