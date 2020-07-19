package com.example.codingstuff.JAVA;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.codingstuff.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpFrag extends DialogFragment {
    private TextInputEditText edtSignUpName, edtSignUpEmail, edtSignUpPassword, edtSignUpConfirmPassword;
    private Button btnSignUp;
    private TextView txtLogIn;
    private FirebaseAuth mAuth;
    SignUpFragListener listener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,android.R.style.Theme_Light_NoTitleBar_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);

        mAuth = FirebaseAuth.getInstance();
        edtSignUpName = view.findViewById(R.id.SignUpName);
        edtSignUpEmail = view.findViewById(R.id.SignUpEmail);
        edtSignUpPassword = view.findViewById(R.id.SignUpPassword);
        edtSignUpConfirmPassword = view.findViewById(R.id.SignUpConfirmPassword);
        btnSignUp = view.findViewById(R.id.btnSignUp);
        txtLogIn = view.findViewById(R.id.textLogIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
        txtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener= (SignUpFragListener) getActivity();
                listener.doLogIn();
            }
        });


        return view;
    }
    private void signUp() {
        final String name = edtSignUpName.getText().toString();
        final String email = edtSignUpEmail.getText().toString();
        String password = edtSignUpPassword.getText().toString();
        String confirmPassword = edtSignUpConfirmPassword.getText().toString();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all the details", Toast.LENGTH_SHORT).show();
        } else {
            if (password.equals(confirmPassword)) {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), name + " signed Up successfully", Toast.LENGTH_SHORT).show();
                            dismiss();
                        }
                    }
                });
            } else {
                Toast.makeText(getContext(), "Password and confirm password do not match", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public interface SignUpFragListener{
        public  void doLogIn();

    }
}