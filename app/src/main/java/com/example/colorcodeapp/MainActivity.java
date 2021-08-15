package com.example.colorcodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
View view;TextView t1,t2;SeekBar s1,s2,s3;
int red=0,green=0,blue=0;@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(View)findViewById(R.id.view);
        t1=(TextView)findViewById(R.id.text);t2=(TextView)findViewById(R.id.text2);
        s1=(SeekBar)findViewById(R.id.see);s2=(SeekBar)findViewById(R.id.see2);
        s3=(SeekBar)findViewById(R.id.see3);s1.setOnSeekBarChangeListener( this);
        s2.setOnSeekBarChangeListener( this);s3.setOnSeekBarChangeListener( this); }@Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { switch (seekBar.getId()){
            case R.id.see:
                red=progress;break;
            case R.id.see2:
                green=progress;break;
            case R.id.see3:
                blue=progress;break; }
        view.setBackgroundColor(Color.rgb(red,green,blue));
        String code=HexCode(red,green,blue);
        t2.setText(code.toUpperCase());
        t1.setText(String.format("RGB (%d, %d, %d)",red,green,blue)); }
    private String HexCode(int red, int green, int blue) { String code;
        code="#";code+=Integer.toHexString(red);
        code+=Integer.toHexString(green);code+=Integer.toHexString(blue);
        return code; }@Override
    public void onStartTrackingTouch(SeekBar seekBar) { }
@Override
    public void onStopTrackingTouch(SeekBar seekBar) { }}