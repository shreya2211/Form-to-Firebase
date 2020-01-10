package com.example.formtofirebase;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameTXT,userTXT,passTXT,roleTXT,phoneTXT;
    Button submit_btn;
   DatabaseReference reff;
   Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTXT=(EditText)findViewById(R.id.name);
        userTXT=(EditText)findViewById(R.id.username);
        passTXT=(EditText)findViewById(R.id.pass);
        phoneTXT=(EditText)findViewById(R.id.phone);
        roleTXT=(EditText)findViewById(R.id.role);
        submit_btn=(Button) findViewById(R.id.submit);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long fphone= Long.parseLong(phoneTXT.getText().toString().trim());
                member.setName(nameTXT.getText().toString().trim());
                member.setUsername(userTXT.getText().toString().trim());
                member.setPassword(passTXT.getText().toString().trim());
                member.setPhone(fphone);
                member.setRole(roleTXT.getText().toString().trim());
                reff.push().setValue(member);
                Toast.makeText(MainActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                passTXT.setText("");
                nameTXT.setText("");
                phoneTXT.setText("");
                userTXT.setText("");
                roleTXT.setText("");

            }
        });
        nameTXT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    nameTXT.setHint("");
                else
                    nameTXT.setHint("Full Name");
            }
        });
        userTXT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    userTXT.setHint("");
                else
                    userTXT.setHint("User Name");
            }
        });
        passTXT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    passTXT.setHint("");
                else
                    passTXT.setHint("Password");
            }
        });
        phoneTXT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    phoneTXT.setHint("");
                else
                    phoneTXT.setHint("Phone Number");
            }
        });
        roleTXT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    roleTXT.setHint("");
                else
                    roleTXT.setHint("Role");
            }
        });
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
