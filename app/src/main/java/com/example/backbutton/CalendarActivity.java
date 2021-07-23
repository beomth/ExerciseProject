package com.example.backbutton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.content.ContentValues.TAG;

public class CalendarActivity extends AppCompatActivity {

    private Button back;
    private CalendarView mCalendarview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);

        mCalendarview = (CalendarView)findViewById(R.id.calendarView);

        //날짜 클릭시 값 넘겨주는 메쏘드
        mCalendarview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { //선택된 것의 날짜를 알려주는 메쏘드
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "/" + month + "/" + dayOfMonth;
                Log.d(TAG, "onSelectedDauChange : mm/dd/yyyy : " + date);

                Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }

    //뒤로가기 버튼
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
