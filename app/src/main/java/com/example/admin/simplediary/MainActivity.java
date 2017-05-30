package com.example.admin.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatePicker date;
    EditText edit;
    Button but; //날짜가 동일하면 수정하기라고 버튼이 뜨게

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (DatePicker) findViewById (R.id.date_pick);
        edit = (EditText) findViewById (R.id.edit);
        but = (Button) findViewById (R.id.but);
    }
}
