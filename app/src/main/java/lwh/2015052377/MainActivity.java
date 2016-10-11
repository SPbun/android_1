package lsj239.a2014050239lsj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import lsj239.a2014050239lsj.DayItem;
import lsj239.a2014050239lsj.R;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {

    private static boolean initFlag = false; 

    private ArrayList<Object> daylist = new ArrayList<Object>();
    private ArrayList<Object> pointlist = new ArrayList<Object>();
    private ArrayList<Object> data = new ArrayList<Object>();
    private String clickYear,clickMouth,tempYearMonth;
    private int sumOfMonth;
    private String fileName,tempFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        Spinner spinnermouth = (Spinner) findViewById(R.id.choseMouth);
        spinnermouth.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[]  mouth = getResources().getStringArray(R.array.mouthList);
                Toast.makeText(MainActivity.this,"选择："+mouth[position],Toast.LENGTH_SHORT).show();
                clickMouth=mouth[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               
            }
        });

        Spinner spinneryear = (Spinner) findViewById(R.id.choseYear);
        spinneryear.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] year = getResources().getStringArray(R.array.yearList);
                Toast.makeText(MainActivity.this,"选择："+year[position],Toast.LENGTH_SHORT).show();
                clickYear=year[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

       
        ImageView addPint = (ImageView) findViewById(R.id.addPuls);
        addPint.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DayItem d = new DayItem();
                Intent intent = new Intent(MainActivity.this, ClickAddItemPoint.class);
                
                intent.putExtra("week", d.getWeek());
                intent.putExtra("day", d.getDay());
                intent.putExtra("year", clickYear);
                intent.putExtra("month", clickMouth);
                startActivity(intent);
            }
        });


        initDays();
        ListViewApater adapter = new ListViewApater(MainActivity.this,data);
        ListView listView = (ListView)findViewById(R.id.main_list_view);
        listView.setAdapter(adapter);

    }

    private void initDays()
    {
        DayItem day3 = new DayItem("SAT","1","dhhh.");
        data.add(day3);
        DayItem day4 = new DayItem("SUN","2","喀喀喀");
        data.add(day4);
        AddItemPoint point = new AddItemPoint(R.drawable.add_dot_btn,"WED","4");
        data.add(point);
        for(int i=0;i<22;i++){
            AddItemPoint point2 = new AddItemPoint(R.drawable.add_dot_btn,"FRI","5");
            data.add(point2);
        }
        AddItemPoint point1 = new AddItemPoint(R.drawable.add_dot_btn,"THR","5");
        data.add(point);
    }
}
