package com.example.amit_equations_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import java.lang.Math;


public class MainActivity extends AppCompatActivity {
    protected int leftNum;
    protected  int rightNum;
    protected int biggerBound = 9;
    protected int lowerBound = -9;
    Button nextNumB;
    ImageButton less_thanB , equals_toB , greater_thanB;
    TextView left_num , right_num , answer;
    ImageView users_choice;
    CheckBox bold , colors;
    RadioButton smallest_range , medium_range , largest_range;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initElements();
    }

    private void initElements()
    {
        nextNumB = findViewById(R.id.next_nums);
        less_thanB = findViewById(R.id.less_than);
        equals_toB = findViewById(R.id.equals_to);
        greater_thanB = findViewById(R.id.greater_than);
        left_num = findViewById(R.id.left_num);
        right_num = findViewById(R.id.right_num);
        users_choice = findViewById(R.id.users_choice);
        answer = findViewById(R.id.answer);
        bold = findViewById(R.id.bold);
        colors = findViewById(R.id.colors);
        smallest_range = findViewById(R.id.smallest_range);
        smallest_range.setChecked(true);
        medium_range = findViewById(R.id.medium_range);
        largest_range = findViewById(R.id.largest_range);
    }
    public void makeNumbers(View view)
    {
        users_choice.setBackground(null);
        answer.setText("Solve the equation:");
        users_choice.setImageDrawable(null);
        users_choice.setImageDrawable(getDrawable(R.drawable.question_solid));
        this.leftNum = (this.lowerBound + (int)(Math.random()*(this.biggerBound - this.lowerBound + 1))); //chooses random number.
        this.rightNum = (this.lowerBound + (int)(Math.random()*(this.biggerBound - this.lowerBound + 1))); //chooses random number.
        right_num.setText("" + this.rightNum);
        left_num.setText("" + this.leftNum);
    }
    public void userChoose(View view)
    {
        users_choice.setImageDrawable(null);
        if(view.getId() == less_thanB.getId())
        {
            users_choice.setBackgroundResource(R.drawable.less_than_solid);
            isCorrect(this.leftNum , this.rightNum , '<');
        }
        else if(view.getId() == equals_toB.getId())
        {
            users_choice.setBackgroundResource(R.drawable.equals_solid);
            isCorrect(this.leftNum , this.rightNum , '=');
        }
        else //if the id is equals to "greater_than"
        {
            users_choice.setBackgroundResource(R.drawable.greater_than_solid);
            isCorrect(this.leftNum , this.rightNum , '>');
        }
    }
    public void isCorrect(int leftNum , int rightNum , char sign)
    {
        if(leftNum < rightNum)
        {
            if(sign == '<')
                answer.setText("correct!");
            else
                answer.setText("wrong!");
        }
        else if(leftNum > rightNum)
        {
            if(sign == '>')
                answer.setText("correct!");
            else
                answer.setText("wrong!");
        }
        else //leftNum is equals to rightNum
        {
            if(sign == '=')
                answer.setText("correct!");
            else
                answer.setText("wrong!");
        }
    }
    public void toggleBold(View view)
    {
        if(bold.isChecked())
        {
            left_num.setTypeface(left_num.getTypeface(), Typeface.BOLD);
            right_num.setTypeface(right_num.getTypeface() , Typeface.BOLD);
        }
        else
        {
            left_num.setTypeface(null);
            right_num.setTypeface(null);
        }
    }
    public void toggleColors(View view)
    {
        if(colors.isChecked())
        {
            int[] colorArr = {R.color.fuchsia , R.color.red , R.color.silver , R.color.gray , R.color.olive
            , R.color.purple , R.color.maroon , R.color.aqua , R.color.lime , R.color.teal , R.color.green , R.color.blue
            , R.color.navy};
            int randomNum = (int)(Math.random()*(colorArr.length + 1)); //chooses random number.
            left_num.setTextColor(getResources().getColor(colorArr[randomNum]));
            right_num.setTextColor(getResources().getColor(colorArr[randomNum]));
        }
        else
        {
            left_num.setTextColor(getResources().getColor(R.color.black));
            right_num.setTextColor(getResources().getColor(R.color.black));
        }
    }
    public void makeRange(View view)
    {
        if(smallest_range.isChecked())
        {
            medium_range.setChecked(false);
            largest_range.setChecked(false);
            lowerBound = -9;
            biggerBound = 9;
        }
        else if(medium_range.isChecked())
        {
            smallest_range.setChecked(false);
            largest_range.setChecked(false);
            lowerBound = -99;
            biggerBound = 99;
        }
        else if(largest_range.isChecked())
        {
            smallest_range.setChecked(false);
            medium_range.setChecked(false);
            lowerBound = -999;
            biggerBound = 999;
        }
    }
}