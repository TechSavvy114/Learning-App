package com.example.codingstuff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.codingstuff.JAVA.SignInFrag;
import com.example.codingstuff.JAVA.SignUpFrag;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SignInFrag.SignInFragListener, SignUpFrag.SignUpFragListener {

    FrameLayout frameLayout;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<Videos> arrayList;
    DatabaseReference myRef;
    CustomAdapterMain adapterMain;
    Videos videos;
    FirebaseAuth mAuth;
    ViewFlipper flipper;

    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        arrayList=new ArrayList<>();

        flipper = findViewById(R.id.flipper);

        int images[] = {R.drawable.download, R.drawable.codelogo, R.drawable.codelogo1, R.drawable.codelogo2, R.drawable.codelogo3,R.drawable.codelogo4};
        for (int image : images) {
            flipperImages(image);
        }


        recyclerView=findViewById(R.id.recycler_main);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        adapterMain =new CustomAdapterMain(arrayList,this);

        recyclerView.setAdapter(adapterMain);

        myRef= FirebaseDatabase.getInstance().getReference().child("User");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChildren()){
                    for(DataSnapshot cData:snapshot.getChildren()){
                        String name=cData.child("a").getValue(String.class);
                        String video=cData.child("vid").getValue(String.class);
                        Log.d("image",name);
                        Log.d("video",video);
                        videos=new Videos();
                        videos.setName(name);
                        videos.setVideo(video);
                        arrayList.add(videos);
                        adapterMain.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mAuth=FirebaseAuth.getInstance();

        drawerLayout=findViewById(R.id.drawer);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.open,R.string.close);
        drawerToggle.syncState();

        navigationView=findViewById(R.id.navig);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.javaItem:
                        Intent intent=new Intent(MainActivity.this,JavaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.c_sharp_item:
                        Intent intent1=new Intent(MainActivity.this,C_sharpActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.kotlin_item:
                        Intent intent2=new Intent(MainActivity.this,Kotlin_Activity.class);
                        startActivity(intent2);
                        break;
                    case R.id.c_plus_item:
                        Intent intent3=new Intent(MainActivity.this,C_Plus.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });


    }

    private void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        flipper.addView(imageView);
        flipper.setFlipInterval(2500);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.signUp:
                signUp();
                break;
            case R.id.signIn:
                signIn();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void signUp() {
        new SignUpFrag().show(getSupportFragmentManager(),null);

    }
    private void signIn(){
        new SignInFrag().show(getSupportFragmentManager(),null);
    }

    @Override
    public void doSignUp() {
        signUp();
    }

    @Override
    public void doLogIn() {
        signIn();
    }
}