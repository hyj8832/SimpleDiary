package com.example.admin.simplediary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker date;
    EditText edit;
    Button but; //날짜가 동일하면 수정하기라고 버튼이 뜨게
   String fileName; //함수안에서 선언 안됨 (지역변수 되서 )  .필드로 선언해야 쓸 수 있다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (DatePicker) findViewById (R.id.date_pick);
        edit = (EditText) findViewById (R.id.edit);
        but = (Button) findViewById (R.id.but);
        but.setOnClickListener(new View.OnClickListener() { //버튼이 클릭되었을 때 일하는
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fOut=openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str=edit.getText().toString();
                    fOut.write(str.getBytes());
                    fOut.close();
                    Toast.makeText(MainActivity.this,"정상적으로 "+fileName+" 파일이 저장되었습니다.",Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }
        });


        Calendar cal=Calendar.getInstance();//캘린더 객체를 사용할 수 있는 참조값을 반환
        int year=cal.get(Calendar.YEAR);
        final int month=cal.get(Calendar.MONTH); //0부터 시작하지 않음 그 날짜 그대로 써야함.
        int day=cal.get(Calendar.DATE);

        date.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                fileName=year+"_"+(month+1)+"_"+day+".txt";
                String readData= readDiary(fileName);
                edit.setText(readData);
                but.setEnabled(true);
            }
        });//마지막 ,다음은 핸들러



    }
    public String readDiary(String fileName){
        String diaryStr=null;
        FileInputStream fIn=null;
        try {
             fIn=openFileInput(fileName);
            byte[] buf=new byte[500];
            fIn.read(buf);
            diaryStr=new String(buf).trim();
            but.setText("수정 하기");
            fIn.close();
        } catch (FileNotFoundException e) {
            edit.setText("일기가 존재하지 않습니다~~!"); //파일이 없을때
            but.setText("새로저장");
        } catch (IOException e) {

        }


        return diaryStr;
    }



}


