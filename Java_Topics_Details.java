package com.example.codingstuff;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class Java_Topics_Details extends AppCompatActivity {

    PDFView pdfView;
    int i;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java__topics__details);
        pdfView=findViewById(R.id.pdf);
        i=getIntent().getExtras().getInt("position");
        s=getIntent().getExtras().getString("file");
        if(s.equals("java_basic")){
            Toast.makeText(getApplicationContext(),""+s+"\n"+i,Toast.LENGTH_SHORT).show();
            switch (i)
            {
                case 0:
                    pdfView.fromAsset("identifiers.pdf").load();
                    break;
                case 1:
                    pdfView.fromAsset("data_type.pdf").load();
                    break;
                case 2:
                    pdfView.fromAsset("arrays.pdf").load();
                    break;
                case 3:
                    pdfView.fromAsset("variable_types.pdf").load();
                    break;
                case 4:
                    pdfView.fromAsset("main_methods.pdf").load();
                    break;
                case 5:
                    pdfView.fromAsset("increment-decrement.pdf").load();
                    break;
                case 6:
                    pdfView.fromAsset("arithmetic-relation-operators.pdf").load();
                    break;
                case 7:
                    pdfView.fromAsset("equality-operators.pdf").load();
                    break;
                case 8:
                    pdfView.fromAsset("genericTypes_casting.pdf").load();
                    break;
                case 9:
                    pdfView.fromAsset("java_conditional.pdf").load();
                    break;
                case 10:
                    pdfView.fromAsset("if_else.pdf").load();
                    break;
                case 11:
                    pdfView.fromAsset("switch_statement.pdf").load();
                    break;
                case 12:
                    pdfView.fromAsset("while_Loops.pdf").load();
                    break;
                case 13:
                    pdfView.fromAsset("do_while_loop.pdf").load();
                    break;
                case 14:
                    pdfView.fromAsset("for_and_For_Each.pdf").load();
                    break;
                case 15:
                    pdfView.fromAsset("break-continue-statements.pdf").load();
                    break;
                case 16:
                    pdfView.fromAsset("java_modifiers_types.pdf").load();
                    break;
                case 17:
                    pdfView.fromAsset("member_modifiers.pdf").load();
                    break;
                case 18:
                    pdfView.fromAsset("constructors.pdf").load();
                    break;
                case 19:
                    pdfView.fromAsset("coupling.pdf").load();
                    break;
                case 20:
                    pdfView.fromAsset("cohesion.pdf").load();
                    break;
                case 21:
                    pdfView.fromAsset("singleton.pdf").load();
                    break;
                case 22:
                    pdfView.fromAsset("abstraction.pdf").load();
                    break;
                case 23:
                    pdfView.fromAsset("encapsulation.pdf").load();
                    break;
                case 24:
                    pdfView.fromAsset("polymorphism.pdf").load();
                    break;
                case 25:
                    pdfView.fromAsset("inheritance.pdf").load();
                    break;
                case 26:
                    pdfView.fromAsset("is-a.pdf").load();
                    break;
                case 27:
                    pdfView.fromAsset("throw.pdf").load();
                    break;
                case 28:
                    pdfView.fromAsset("throws.pdf").load();
                    break;
                case 29:
                    pdfView.fromAsset("finally.pdf").load();
                    break;
                case 30:
                    pdfView.fromAsset("try.pdf").load();
                    break;
                case 31:
                    pdfView.fromAsset("difference.pdf").load();
                    break;
            }
        }
        else if(s.equals("java_adv")){
            Toast.makeText(getApplicationContext(),""+s+"\n"+i,Toast.LENGTH_SHORT).show();
            switch (i)
            {
                case 0:
                    pdfView.fromAsset("jSP.pdf").load();
                    break;
                case 1:
                    pdfView.fromAsset("servlet.pdf").load();
                    break;
                case 2:
                    pdfView.fromAsset("hibernate.pdf").load();
                    break;
                case 3:
                    pdfView.fromAsset("spring.pdf").load();
                    break;
                case 4:
                    pdfView.fromAsset("struts.pdf").load();
                    break;
                case 5:
                    pdfView.fromAsset("web services.pdf").load();
                    break;
                case 6:
                    pdfView.fromAsset("sequential.pdf").load();
                    break;


            }
        }
        else if(s.equals("c_plus-adv")){
            Toast.makeText(getApplicationContext(),""+s+"\n"+i,Toast.LENGTH_SHORT).show();
            switch (i){
                case 0:
                    pdfView.fromAsset("Identifier.pdf").load();
                    break;
                case 1:
                    pdfView.fromAsset("main_methods.pdf").load();
                    break;

            }
        }
        else if(s.equals("c_plus-basic")){
            Toast.makeText(getApplicationContext(),""+s+"\n"+i,Toast.LENGTH_SHORT).show();
            switch (i){
                case 0:
                    pdfView.fromAsset("Identifier.pdf").load();
                    break;
                case 1:
                    pdfView.fromAsset("main_methods.pdf").load();
                    break;

            }
        }
        else if(s.equals("Kotlin_basic")){
            Toast.makeText(getApplicationContext(),""+s+"\n"+i,Toast.LENGTH_SHORT).show();
            switch (i){
                case 0:
                    pdfView.fromAsset("Identifier.pdf").load();
                    break;
                case 1:
                    pdfView.fromAsset("main_methods.pdf").load();
                    break;

            }
        }
        else if(s.equals("Kotlin_adv")){
            Toast.makeText(getApplicationContext(),""+s+"\n"+i,Toast.LENGTH_SHORT).show();
            switch (i){
                case 0:
                    pdfView.fromAsset("Identifier.pdf").load();
                    break;
                case 1:
                    pdfView.fromAsset("main_methods.pdf").load();
                    break;

            }
        }
        else if(s.equals("c_sharp_basic")){
            Toast.makeText(getApplicationContext(),""+s+"\n"+i,Toast.LENGTH_SHORT).show();
            switch (i){
                case 0:
                    pdfView.fromAsset("Identifier.pdf").load();
                    break;
                case 1:
                    pdfView.fromAsset("main_methods.pdf").load();
                    break;

            }
        }
        else if(s.equals("c_sharp_adv")){
            Toast.makeText(getApplicationContext(),""+s+"\n"+i,Toast.LENGTH_SHORT).show();
            switch (i){
                case 0:
                    pdfView.fromAsset("Identifier.pdf").load();
                    break;
                case 1:
                    pdfView.fromAsset("main_methods.pdf").load();
                    break;

            }
        }
    }
}