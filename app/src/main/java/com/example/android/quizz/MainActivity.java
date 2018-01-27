package com.example.android.quizz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    int score;
    boolean ch1;
    boolean ch2;
    boolean ch3;
    boolean ch4;
    boolean isShown;
    double rate=4.5;
    boolean ans1; //1st question correct answer
    boolean ans2; //2nd question correct answer
    boolean ans5; //5th question correct answer
    boolean ans6; //6th question correct answer
    boolean ans7; //7th question correct answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiate rating bar and a button
        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        Button submitButton = (Button) findViewById(R.id.ratingButton);
        // perform click event on button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values and then displayed in a toast
                String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
                String rating = String.format("%.2f",simpleRatingBar.getRating());
                rate=(rate+simpleRatingBar.getRating())/2;
                String s= String.format("%.2f", rate);
                Toast.makeText(getApplicationContext(), "Rating::" + rating+"\n"+"Total rating::"+s, Toast.LENGTH_SHORT).show();
            }
        });

        // Capture our button from layout for question1
        Button button1 = (Button)findViewById(R.id.q11);
        Button button2 = (Button)findViewById(R.id.q12);
        Button button3 = (Button)findViewById(R.id.q13);
        // Register the onClick listener with the implementation above
        button1.setOnClickListener(q1OnClickListener);
        button2.setOnClickListener(q1OnClickListener);
        button3.setOnClickListener(q1OnClickListener);

        // Capture our button from layout for question2
        Button button4 = (Button)findViewById(R.id.q21);
        Button button5 = (Button)findViewById(R.id.q22);

        // Register the onClick listener with the implementation above
        button4.setOnClickListener(q2OnClickListener);
        button5.setOnClickListener(q2OnClickListener);

        // Capture our button from layout for question5
        Button button6 = (Button)findViewById(R.id.q51);
        Button button7 = (Button)findViewById(R.id.q52);

        // Register the onClick listener with the implementation above
        button6.setOnClickListener(q5OnClickListener);
        button7.setOnClickListener(q5OnClickListener);

        // Capture our button from layout for question6
        Button button8 = (Button)findViewById(R.id.q61);
        Button button9 = (Button)findViewById(R.id.q62);

        // Register the onClick listener with the implementation above
        button8.setOnClickListener(q6OnClickListener);
        button9.setOnClickListener(q6OnClickListener);

        // Capture our button from layout for question7
        Button button10 = (Button)findViewById(R.id.q71);
        Button button11 = (Button)findViewById(R.id.q72);
        Button button12 = (Button)findViewById(R.id.q73);


        // Register the onClick listener with the implementation above
        button10.setOnClickListener(q7OnClickListener);
        button11.setOnClickListener(q7OnClickListener);
        button12.setOnClickListener(q7OnClickListener);
    }

    // Create an anonymous implementation of OnClickListener for question1
    private View.OnClickListener q1OnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            //We will handle click here but which button clicked??? We don't know, so we will make

            switch (v.getId() /*to get clicked view id**/) {
                case R.id.q11:
                    ans1=true;
                    break;
                case R.id.q12:
                    ans1=false;
                    break;
                case R.id.q13:
                    ans1=false;
                    break;
                default:
                    break;
            }
        }
    };

    // Create an anonymous implementation of OnClickListener for question2
    private View.OnClickListener q2OnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // find which button is clicked

            switch (v.getId() /*to get clicked view id**/) {
                case R.id.q21:
                    ans2=true;
                    break;
                case R.id.q22:
                    ans2=false;
                    break;
                default:
                    break;
            }
        }
    };
        // Create an anonymous implementation of OnClickListener for question5
        private View.OnClickListener q5OnClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                // find which button is clicked
                switch (v.getId() /*to get clicked view id**/) {
                    case R.id.q51:
                        ans5=false;
                        break;
                    case R.id.q52:
                        ans5=true;
                        break;
                    default:
                        break;
                }
            }

    };

    // Create an anonymous implementation of OnClickListener for question6
    private View.OnClickListener q6OnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // find which button is clicked
            switch (v.getId() /*to get clicked view id**/) {
                case R.id.q61:
                    ans6=false;
                    break;
                case R.id.q62:
                    ans6=true;
                    break;
                default:
                    break;
            }
        }

    };

    // Create an anonymous implementation of OnClickListener for question7
    private View.OnClickListener q7OnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            //We will handle click here but which button clicked??? We don't know

            switch (v.getId() /*to get clicked view id**/) {
                case R.id.q71:
                    ans7=false;
                    break;
                case R.id.q72:
                    ans7=false;
                    break;
                case R.id.q73:
                    ans7=true;
                    break;
                default:
                    break;
            }
        }

    };


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.q31:
                if (checked)
                   ch1=true;
                else
                    ch1=false;
                    break;
            case R.id.q32:
                if (checked)
                    ch2=true;
                else
                    ch2=false;
                    break;
            case R.id.q33:
                if (checked)
                    ch3=true;
                else
                    ch3=false;
                    break;
            case R.id.q34:
                if (checked)
                  ;
                else
                    break;
        }
    }

    public void checkAnswers (View view){
        if(isShown) {
            Toast.makeText(this, getString(R.string.noanswer), Toast.LENGTH_LONG).show();
            clearAll();
        }
        else if (score==0){
            if (ans1) {
                score += 1;

            }
            if (ans2)
                score+=1;
            if (ans5)
                score+=1;
            if (ans6)
                score+=1;
            if (ans7)
                score+=1;
            if (ch1)
                score += 1;
            if (ch2)
                score += 1;
            if (ch3)
                score += 1;
            EditText et=(EditText)findViewById(R.id.q4edit);
            String text=et.getText().toString().toUpperCase();
            String string1 = getString(R.string.river);
            if (text.equals(string1))
                score+=1;
            if (score>0) {
                Toast.makeText(this, getString(R.string.yourscore) + score+getString(R.string.of9), Toast.LENGTH_SHORT).show();
                isShown = true;
                showAnswers();
            }else {
                Toast.makeText(this, getString(R.string.nothingcorrect), Toast.LENGTH_SHORT).show();
                clearAll();
            }
        }


        }

    public void showAnswers() {
          RadioButton b=findViewById(R.id.q11);
          b.setTextColor(Color.parseColor("#4CAF50"));
          b=findViewById(R.id.q21);
          b.setTextColor(Color.parseColor("#4CAF50"));
          b=findViewById(R.id.q52);
          b.setTextColor(Color.parseColor("#4CAF50"));
          b=findViewById(R.id.q62);
          b.setTextColor(Color.parseColor("#4CAF50"));
          b=findViewById(R.id.q73);
          b.setTextColor(Color.parseColor("#4CAF50"));
          CheckBox c=findViewById(R.id.q31);
          c.setTextColor(Color.parseColor("#4CAF50"));
          c=findViewById(R.id.q32);
          c.setTextColor(Color.parseColor("#4CAF50"));
          c=findViewById(R.id.q33);
          c.setTextColor(Color.parseColor("#4CAF50"));
          EditText ed=(EditText) findViewById(R.id.q4edit);
          String st=ed.getText().toString().toUpperCase();
          if(st.equals(getString(R.string.river)))
              ed.setTextColor(Color.parseColor("#4CAF50"));
          else {
              st=st.toLowerCase();
              st += getString(R.string.correctanswer);
              st += getString(R.string.river);
              ed.setText(st);
          }
    }


    public void clearAnswers(View view){
        clearAll();
    }

    public void clearAll(){
        RadioGroup gr1=(RadioGroup) findViewById(R.id.gr1);
        gr1.clearCheck();
        RadioButton b=findViewById(R.id.q11);
        b.setTextColor(Color.parseColor("#757575"));
        RadioGroup gr2=(RadioGroup) findViewById(R.id.gr2);
        gr2.clearCheck();
        b=findViewById(R.id.q21);
        b.setTextColor(Color.parseColor("#757575"));
        RadioGroup gr5=(RadioGroup) findViewById(R.id.gr5);
        gr5.clearCheck();
        b=findViewById(R.id.q52);
        b.setTextColor(Color.parseColor("#757575"));
        RadioGroup gr6=(RadioGroup) findViewById(R.id.gr6);
        gr6.clearCheck();
        b=findViewById(R.id.q62);
        b.setTextColor(Color.parseColor("#757575"));
        RadioGroup gr7=(RadioGroup) findViewById(R.id.gr7);
        gr7.clearCheck();
        b=findViewById(R.id.q73);
        b.setTextColor(Color.parseColor("#757575"));
        CheckBox ch31=(CheckBox) findViewById(R.id.q31);
        ch31.setChecked(false);
        CheckBox ch32=(CheckBox) findViewById(R.id.q32);
        ch32.setChecked(false);
        CheckBox ch33=(CheckBox) findViewById(R.id.q33);
        ch33.setChecked(false);
        CheckBox ch34=(CheckBox) findViewById(R.id.q34);
        ch34.setChecked(false);
        EditText ed=(EditText) findViewById(R.id.q4edit);
        ed.setText("");
        ed.setTextColor(Color.parseColor("#757575"));
        score = 0;
        ch1 = false;
        ch2 = false;
        ch3 = false;
        ch4 = false;
        isShown=false;
        CheckBox c=findViewById(R.id.q31);
        c.setTextColor(Color.parseColor("#757575"));
        c=findViewById(R.id.q32);
        c.setTextColor(Color.parseColor("#757575"));
        c=findViewById(R.id.q33);
        c.setTextColor(Color.parseColor("#757575"));
        ans1=false;ans2=false;ans5=false;ans6=false;ans7=false;
    }
}
