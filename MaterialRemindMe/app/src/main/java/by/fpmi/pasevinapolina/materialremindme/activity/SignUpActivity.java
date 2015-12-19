package by.fpmi.pasevinapolina.materialremindme.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import by.fpmi.pasevinapolina.materialremindme.R;
import by.fpmi.pasevinapolina.materialremindme.adapter.LoginDatabaseAdapter;

/**
 * Created by user on 18.12.2015.
 */
public class SignUpActivity extends AppCompatActivity {
    EditText emailText;
    EditText nameText;
    EditText passwordText;
    EditText confirmPasswordText;
    Button registerButton;

    LoginDatabaseAdapter loginDataBaseAdapter;

    void initComponents() {
        emailText = (EditText)findViewById(R.id.input_email);
        nameText = (EditText)findViewById(R.id.input_name);
        passwordText = (EditText) findViewById(R.id.input_password);
        confirmPasswordText = (EditText) findViewById(R.id.input_corfirm_password);
        registerButton = (Button) findViewById(R.id.btn_register);
    }

    void setOnClickListeners() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initComponents();
        setOnClickListeners();

        loginDataBaseAdapter=new LoginDatabaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();


    }


    void signup(){

        if (!validate()) {
            onSignupFailed();
            return;
        }
        registerButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        progressDialog.dismiss();
                    }
                }, 2000);

    }

    public void onSignupSuccess() {
        registerButton.setEnabled(true);
        setResult(RESULT_OK, null);
        loginDataBaseAdapter.insertEntry(emailText.getText().toString(), passwordText.getText().toString(), nameText.getText().toString());
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Sign up failed", Toast.LENGTH_LONG).show();
        registerButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;
        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String confirmPassword = confirmPasswordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            nameText.setError("Please, enter at least 3 characters");
            valid = false;
        } else {
            nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("Please, enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4) {
            passwordText.setError("Please, enter valid password (at least 4 alphanumeric characters)");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        if (!password.equals(confirmPassword)) {
            confirmPasswordText.setError("Password does not match");
            valid = false;
        } else {
            confirmPasswordText.setError(null);
        }
        return valid;
    }
}
