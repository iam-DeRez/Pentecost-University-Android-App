package com.example.pu;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    //creating variables for available attributes
    private EditText EmailSI, PasswordSI;
    private Button SignInBtn;
    private android.app.ProgressDialog ProgressDialog;
    private FirebaseAuth fireAuth;
    private ImageView googlebtn;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        //Creating Google SignIn method using google Image
        googlebtn = findViewById(R.id.googleButton);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

       GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            navigateToSecondActivity();
        }

        googlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });



        //getting variables IDs for Email and Password
        fireAuth = FirebaseAuth.getInstance();
        EmailSI = findViewById(R.id.login_emailAddress_box);
        PasswordSI = findViewById(R.id.login_userPassword_box);
        SignInBtn = findViewById(R.id.loginButton);
        ProgressDialog = new ProgressDialog(this);

        //OnClick Function
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SignIn();
            }
        });
    }


    //Function for Google Login
    void Login(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent, 1000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }

        }
    }

    void navigateToSecondActivity(){
    Intent intent = new Intent(login.this,main_screen.class);
    startActivity(intent);
    finish();
    Toast.makeText(login.this, "Login successful", Toast.LENGTH_SHORT).show();
    }


    //Function Login using Email and Function
    private void SignIn()
    {
        String Email = EmailSI.getText().toString();
        String Password1 = PasswordSI.getText().toString();


        if (TextUtils.isEmpty(Email)) {
            EmailSI.setError("Enter Email");
            return;
        } else if (TextUtils.isEmpty(Password1)) {
            PasswordSI.setError("Enter Password");
            return;

        } else if (!isValidEmail(Email)) {
            EmailSI.setError("Invalid Email");
            return;
        }

        ProgressDialog.setMessage("Please Wait ...");
        ProgressDialog.show();
        ProgressDialog.setCanceledOnTouchOutside(false);
        fireAuth.signInWithEmailAndPassword (Email, Password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(login.this,"Login successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this,main_screen.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(login.this,"Wrong email or password",Toast.LENGTH_SHORT).show();
                    ProgressDialog.dismiss();
                }
            }
        });

    }




    //function for checking validity of Email
    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }






    public void signupS(View view) {
        Intent signupS = new Intent(this, signup.class);
        startActivity(signupS);
    }




}