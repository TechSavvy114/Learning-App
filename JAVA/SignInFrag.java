package com.example.codingstuff.JAVA;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.codingstuff.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInFrag extends DialogFragment {
    EditText mail,pass;
    Button signIn,signUp,cancel;
    FirebaseAuth mAuth;
    SignInFragListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,android.R.style.Theme_Light_NoTitleBar_Fullscreen);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_in, container, false);

        mail=view.findViewById(R.id.signIn_email);
        pass=view.findViewById(R.id.signIn_password);
        signIn=view.findViewById(R.id.signIn_Button);
        signUp=view.findViewById(R.id.signIn_signUp_Button);
        cancel=view.findViewById(R.id.not_now);

        mAuth=FirebaseAuth.getInstance();
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mail.getText().toString()!=null||pass.getText().toString()!=null){
                    mAuth.signInWithEmailAndPassword(mail.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    Toast.makeText(getContext(),"successful",Toast.LENGTH_SHORT).show();
                    dismiss(); }
                    })      .addOnFailureListener(new OnFailureListener() {
                              @Override
                                public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getContext(),""+e.getMessage(),Toast.LENGTH_SHORT).show();
                              }
                 });}
                else {
                    Toast.makeText(getContext(),"Please fill all required field",Toast.LENGTH_SHORT).show();
                }
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener=(SignInFragListener)getActivity();
                listener.doSignUp();
                dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }
    public interface SignInFragListener{
        public void doSignUp();
    }
}