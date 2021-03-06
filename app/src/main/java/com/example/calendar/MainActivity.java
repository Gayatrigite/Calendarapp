package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int currentYear = 0;
    private int currentMonth = 0;
    private int currentDay = 0;
    private int daysIndex = 0;
    private int monthIndex = 0;
    private int yearIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CalendarView calendarView = findViewById(R.id.calendarView);


        final List<String> calendarStrings = new ArrayList<>();
        final int[] days = new int[30];
        final int[] months = new int[12];
        final int[] years = new int[10];

        final EditText textInput = findViewById(R.id.textInput);

        final View dayContent = findViewById(R.id.dayContent);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {

                currentYear = year;
                currentMonth = month;
                currentDay = dayOfMonth;
                if(dayContent.getVisibility()==View.GONE){
                    dayContent.setVisibility(View.VISIBLE);
                }

                for(int i = 0; i<30; i++);{
                    if(days[1] == currentDay){
                        for (int j = 0; j < 12; j++) {
                            if (months[j] == currentMonth) {
                                textInput.setText(calendarStrings.get(1));
                                return;
                            }
                        }
                    }
                }
                textInput.setText("");
            }
        });
        final Button saveTextButton = findViewById(R.id.saveTextButton);
        saveTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                days[daysIndex] = currentDay;
                months[monthIndex] = currentMonth;
                years[yearIndex] = currentYear;
                calendarStrings.add(daysIndex,textInput.getText().toString());
                daysIndex++;
                monthIndex++;
                yearIndex++;
                textInput.setText("");
            }
        });
    }
}
