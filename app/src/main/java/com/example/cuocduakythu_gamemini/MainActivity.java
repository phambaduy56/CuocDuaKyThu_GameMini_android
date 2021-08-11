package com.example.cuocduakythu_gamemini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2, sb3;
    ImageButton imgbutton;
    int diem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anh_Xa();

        falseSeekBar();

        txtDiem.setText(diem + "");

        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                // getProgress lấy giá trị hiện tại của Seekbar
                // setProgress thiết lập giá trị cho Seekbar

                int number = 5;
                Random ramdom = new Random();

                int One = ramdom.nextInt(number);
                int Two = ramdom.nextInt(number);
                int Three = ramdom.nextInt(number);



                if(sb1.getProgress() >= sb1.getMax()){
                    // SET CÁC THUỘC TÍNH
                    this.cancel();
                    imgbutton.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "CON SỐ 1 VỀ NHẤT", Toast.LENGTH_SHORT).show();
                    // KIỂM TRA ĐẶT CƯỢC
                    if(cb1.isChecked()){
                        diem += 10;
                        Toast.makeText(MainActivity.this, "BẠN ĐOÁN CHÍNH XÁC", Toast.LENGTH_SHORT).show();
                    }else {
                        diem -= 10;
                        Toast.makeText(MainActivity.this, "CHÚC BẠN MAY MẮN LẦN SAU", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(diem + "");
                    TrueCheckBox();
                }
                if(sb2.getProgress() >= sb2.getMax()){
                    // SET CÁC THUỘC TÍNH
                    this.cancel();
                    imgbutton.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "CON SỐ 2 VỀ NHẤT", Toast.LENGTH_SHORT).show();
                    // KIỂM TRA ĐẶT CƯỢC
                    if(cb2.isChecked()){
                        diem += 10;
                        Toast.makeText(MainActivity.this, "BẠN ĐOÁN CHÍNH XÁC", Toast.LENGTH_SHORT).show();
                    }else {
                        diem -= 10;
                        Toast.makeText(MainActivity.this, "CHÚC BẠN MAY MẮN LẦN SAU", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(diem + "");
                    TrueCheckBox();
                }
                if(sb3.getProgress() >= sb3.getMax()){
                    //SET CAC THUỘC TÍNH
                    this.cancel();
                    imgbutton.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "CON SỐ 3 VỀ NHẤT", Toast.LENGTH_SHORT).show();
                    // KIỂM TRA ĐẶT CƯỢC
                    if(cb3.isChecked()){
                        diem += 10;
                        Toast.makeText(MainActivity.this, "BẠN ĐOÁN CHÍNH XÁC", Toast.LENGTH_SHORT).show();
                    }else {
                        diem -= 10;
                        Toast.makeText(MainActivity.this, "CHÚC BẠN MAY MẮN LẦN SAU", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(diem + "");
                    TrueCheckBox();

                }

                sb1.setProgress(sb1.getProgress() + One);
                sb2.setProgress(sb2.getProgress() + Two);
                sb3.setProgress(sb3.getProgress() + Three);

            }
            @Override
            public void onFinish() {

            }
        };

        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked() || cb2.isChecked() || cb3.isChecked()){
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    imgbutton.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    FalseCheckBox();

                }
                else {
                    Toast.makeText(MainActivity.this, "BẠN PHẢI ĐẶT CƯỢC MỚI ĐƯỢC CHƠI", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb2.setChecked(false);
                    cb1.setChecked(false);
                }
            }
        });

    }

    private void Anh_Xa() {
        txtDiem = (TextView) findViewById(R.id.textviewDiemSo);

        cb1 = (CheckBox) findViewById(R.id.checkboxOne);
        cb2 = (CheckBox) findViewById(R.id.checkboxTwo);
        cb3 = (CheckBox) findViewById(R.id.checkboxThree);

        sb1 = (SeekBar) findViewById(R.id.seekbarOne);
        sb2 = (SeekBar) findViewById(R.id.seekbarTwo);
        sb3 = (SeekBar) findViewById(R.id.seekbarThree);

        imgbutton = (ImageButton) findViewById(R.id.buttonPlay);

    }

    private void TrueCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    private void FalseCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }

    private void falseSeekBar(){

        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
    }
}