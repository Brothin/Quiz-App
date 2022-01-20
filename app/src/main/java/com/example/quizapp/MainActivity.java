package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView question,questionNumber;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModal> arrayList;
    Random random;
    int currentScore=0,questionAttempted=0,currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question=findViewById(R.id.Question);
        questionNumber=findViewById(R.id.QuestionAttempted);
        option1Btn=findViewById(R.id.Btn_Option1);
        option2Btn=findViewById(R.id.Btn_Option2);
        option3Btn=findViewById(R.id.Btn_Option3);
        option4Btn=findViewById(R.id.Btn_Option4);
        arrayList=new ArrayList<>();
        random=new Random();
        getQuizQuestion(arrayList);
        currentPos=random.nextInt(arrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase()))
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(arrayList.size());
                setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase()))
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(arrayList.size());
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase()))
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(arrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase()))
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(arrayList.size());
                setDataToViews(currentPos);
            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
        View bottomSheetView=LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(ConstraintLayout)findViewById(R.id.idLLScore));
        TextView score=bottomSheetView.findViewById(R.id.score);
        Button restartQuiz=bottomSheetView.findViewById(R.id.restart);
        score.setText("Your Score is \n"+currentScore+"/5");
        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=random.nextInt(arrayList.size());
                setDataToViews(currentPos);
                questionAttempted=0;
                currentScore=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPos){
        questionNumber.setText("Questions Attempted : "+questionAttempted+"/5");

        if(questionAttempted==5){
            showBottomSheet();
        } else{
            question.setText(arrayList.get(currentPos).getQuestion());
            option1Btn.setText(arrayList.get(currentPos).getOption1());
            option2Btn.setText(arrayList.get(currentPos).getOption2());
            option3Btn.setText(arrayList.get(currentPos).getOption3());
            option4Btn.setText(arrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModal> arrayList) {
        arrayList.add(new QuizModal("Energy management is a key component of?","Environmental Management","Nitrogen Management","Carbon Management","Water Management","Carbon Management"));
        arrayList.add(new QuizModal("IFMA stands for?","Indian Facility Management Association","International Facility Management Association","International Facility Management Academy","Indian Facility Management Academy","International Facility Management Association"));
        arrayList.add(new QuizModal("Which country has highest energy usage per capita?","Qatar","Kuwait","Iceland","United Arab emirates","Iceland"));
        arrayList.add(new QuizModal("LNG stands for?","Liquid natural gas","Liquefied natural gas","Low nitrogen content gas","Liquid nitrogen gas","Liquefied natural gas"));
        arrayList.add(new QuizModal("The main objective of energy management is to?","Minimize energy cost","Minimize environmental effects","Maintain optimum energy procurement and utilization","All of these","All of these"));
    }
}