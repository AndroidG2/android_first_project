package com.intent.veyo.intentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Activity","call onCreate()");
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setText(R.string.helloworld);


        /*ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.android);*/

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setTextColor(getResources().getColor(R.color.color));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity","call onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter++;
        Log.d("Activity", "call onResume()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Veyo", counter);
        Log.d("Counter", counter+" was saved.");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("Veyo", counter);
        Log.d("Counter", counter+" was restore.");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity", "call onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity", "call onDestroy()");
    }

    public void newActivity(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        ArrayList<String> recipientArray = new ArrayList<>();
        recipientArray.add("nuonveyo.stu@gmail.com");
        intent.putExtra(Intent.EXTRA_EMAIL, recipientArray);
        startActivity(intent);


        /*Intent intent = new Intent();
        intent.setClassName("com.intent.veyo.intentapp", "com.intent.veyo.intentapp.ActivityB");
        startActivity(intent);*/
    }

    public void process(View v){
        Intent intent = null, chooser = null;
        if(v.getId() == R.id.launchMap){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.8777"));
            chooser = intent.createChooser(intent, "Launch Map");
            startActivity(chooser);
        }else if(v.getId() == R.id.launchMarket){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=dolphin.developers.com"));
            chooser = intent.createChooser(intent, "Launch Market");
            startActivity(chooser);
        }else if(v.getId() == R.id.sendEmail){
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"bosara008@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Test send mail from Android App");
            intent.putExtra(Intent.EXTRA_TEXT, "Hey guid, this is some text that i write to test about my android app....!");
            intent.setType("message/rfc822");
            chooser = intent.createChooser(intent, "Send Email");
            startActivity(chooser);
        }/*else if(v.getId() == R.id.sendImage){
            Uri imageUri = Uri.parse("android.resource://res/drawable/"+R.drawable.android);
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image*//*");
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent.putExtra(Intent.EXTRA_SUBJECT, "this is an image, sending for test with android app");
            chooser = intent.createChooser(intent, "Send Image");
            startActivity(chooser);
        }*/
    }
}
