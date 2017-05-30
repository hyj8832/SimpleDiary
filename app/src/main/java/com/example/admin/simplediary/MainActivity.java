package com.example.admin.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

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

        Calendar cal=Calendar.getInstance();//캘린더 객체를 사용할 수 있는 참조값을 반환
        int year=cal.get(Calendar.YEAR);
        final int month=cal.get(Calendar.MONTH); //0부터 시작하지 않음 그 날짜 그대로 써야함.
        int day=cal.get(Calendar.DATE);

        date.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthr, int day) {
                fileName=year+"_"+(month+1)+"_"+day+".txt";
                String readData= readDiary(fileName);
                edit.setText(readData);
                but.setEnabled(true);
            }
        });//마지막 ,다음은 핸들러



    }
    public String readDiary(String fileName){
        return null;




    }



}


