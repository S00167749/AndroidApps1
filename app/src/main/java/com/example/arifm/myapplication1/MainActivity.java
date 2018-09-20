package com.example.arifm.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    protected int number = 0;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mDatabase.child("condition");

    Button tapMe;
    Button add;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tapMe = (Button) findViewById(R.id.button);
        add = (Button) findViewById(R.id.button2);
        text1 = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onStart(){
        super.onStart();

        mConditionRef.addValueEventListener(new ValueEventListener(){
           @Override
           public  void onDataChange(DataSnapshot dataSnapshot){
             String text = dataSnapshot.getValue(String.class);
             text1.setText(text);
           }
           @Override
           public void onCancelled(DatabaseError databaseError){

           }
        });


    }

    public void onButtonTap(View v)
    {
        Toast myToast = Toast.makeText(getApplicationContext(),"Ouch",Toast.LENGTH_LONG);
        myToast.show();
    }

    public void addNumbers(View v)
    {
        EditText et;
        et = (EditText) findViewById(R.id.editText);
        int inputNumber = Integer.parseInt(et.getText().toString());
        number += inputNumber;

        final EditText editText = (EditText) this.findViewById(R.id.editText2);
        editText.setFocusable(false);
        //editText.setEnabled(false);     // sets background grey
        //String value = editText.getText().toString();
        editText.setText("" + number);

    }

 //tests comments
}
