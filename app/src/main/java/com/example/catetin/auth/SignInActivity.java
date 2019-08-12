package com.example.catetin.auth;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.catetin.MainActivity;
import com.example.catetin.R;
import com.example.catetin.model.UserModel;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import io.isfaaghyth.rak.Rak;

public class SignInActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 7117; //
    List<AuthUI.IdpConfig> providers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        Rak.initialize(getApplicationContext());


        //ini providers
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );

        showSignInOption();


    }

    private void showSignInOption() {

        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.MyTheme)
                        .build(), MY_REQUEST_CODE
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == MY_REQUEST_CODE){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK){
                //Get User
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                String id = user.getUid();
                Uri image = user.getPhotoUrl();
                Log.d("alamat", image.toString());
                String nama = user.getDisplayName();
                String email = user.getEmail();

                UserModel userModel = new UserModel(
                        id,
                        image,
                        nama,
                        email
                );


                Rak.entry("dataAccount", userModel);

                startActivity(new Intent(SignInActivity.this, MainActivity.class));


            }else {
                Toast.makeText(this, "Result Error", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Request Code Error", Toast.LENGTH_SHORT).show();
        }

    }
}
