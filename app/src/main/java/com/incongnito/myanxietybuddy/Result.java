package com.incongnito.myanxietybuddy;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endresult);
        TextView tv = findViewById(R.id.EndIndex);
        String maintext = "";
        int med_count = 0;
        int never_count = 0;
        for(String s:Questions.score.get(0)){
            if(s == "A"){
                maintext += "High Social Anxiety\n";
                break;
            }
            if (s == "S") {
                med_count++;
            }
            if(med_count == 2){
                maintext += "Moderate Social Anxiety\n";
                break;
            }
            if (s == "N") {
                never_count++;
            }
            if(never_count == 3){
                maintext += "Low Social Anxiety\n";
            }
        }
        String q1 = Questions.score.get(1).get(0);
        String q2 = Questions.score.get(1).get(1);
        if(q1 == "A" && q2 == "A"){
            maintext += "Low Emotional Support\n";
        }else if(q1 == "S" || q2 == "S"){
            maintext += "Moderate Emotional Support\n";
        }else if(q1 == "N" && q2 == "N"){
            maintext += "Low Emotional Support\n";
        }
        med_count = 0;
        never_count = 0;

        tv.setText(maintext);
    }
}
