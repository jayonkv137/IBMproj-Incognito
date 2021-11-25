package com.incongnito.myanxietybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Questions extends AppCompatActivity {
    private String Questions[] = {
            "I was very afraid of being judged by others.",
            "I was extremely afraid of social situations.",
            "I was worried about being criticized by other people.",
            "I was worried other people may not like me.",
            "I have someone who will listen to me when i need to talk",
            "I have someone who makes me feel appreciated",
            "I felt worthless",
            "I felt helpless",
            "I felt depressed"
    };
    private int bgs[] = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9
    };
    private TextView Questions_text,cate,op1,op2,op3;
    private RelativeLayout layout;
    private int current_question = 0,scoreindex = 0;
    public static ArrayList<ArrayList<String>> score;
    ArrayList<String> tmp = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_layout);
        Questions_text = findViewById(R.id.Question);
        layout = findViewById(R.id.question_layout_RL);
        cate = findViewById(R.id.Top_cate);
        op1 = findViewById(R.id.opt1);
        op2 = findViewById(R.id.opt2);
        op3 = findViewById(R.id.opt3);
        score = new ArrayList<>();
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_question < Questions.length) {
                    changeQuestion();
                    tmp.add("A");
                }
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_question < Questions.length) {
                    changeQuestion();
                    tmp.add("S");
                }
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_question < Questions.length) {
                    changeQuestion();
                    tmp.add("N");
                }
            }
        });
    }
    void changeQuestion(){
        current_question++;
        if(current_question < Questions.length){
            Questions_text.setText(Questions[current_question]);
            layout.setBackgroundResource(bgs[current_question]);
        }else{
            startActivity(new Intent(com.incongnito.myanxietybuddy.Questions.this,Result.class));
            finish();
        }
        if(current_question == 4) {
            cate.setText("Emotional Support");
            score.add(new ArrayList<>(tmp));
            tmp.clear();
        }else if(current_question == 6){
            cate.setText("Depression");
            score.add(new ArrayList<>(tmp));
        }
    }
}
