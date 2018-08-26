//This activity is used to display the questions from the Questions class
//Here we use a random generator to randomly generate questions from the array inside Questions class
package edu.niu.z1829451.quizfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    TextView tv;
    Button nxt, b1, b2, b3, b4;
    FirebaseAuth mauth;

    private Questions questions = new Questions();

    private String manswer;
    private Integer max = 1, sc = 0, c =0, in = 0;
    ArrayList<Integer> rand = new ArrayList<>(); //Arraylist which is used to store the randomly generated numbers
    Random ran;

    //Get the length of the question array
    private int questionLength1 = questions.questions1.length;
    private int questionLength2 = questions.questions2.length;
    private int questionLength3 = questions.questions3.length;
    private int questionLength4 = questions.questions4.length;
    private int questionLength5 = questions.questions5.length;
    private int questionLength6 = questions.questions6.length;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tv  = findViewById(R.id.tvId);

        b1  = findViewById(R.id.button1Id);
        b2  = findViewById(R.id.button2Id);
        b3  = findViewById(R.id.button3Id);
        b4  = findViewById(R.id.button4Id);
        nxt = findViewById(R.id.nextBtnId);

        mauth = FirebaseAuth.getInstance();

        Integer wk= getIntent().getExtras().getInt("week");
        questions.setWeek(wk);

        ran = new Random();

        if(questions.getWeek() == 1){
            Integer a = ran.nextInt(questionLength1);
            Log.d("here", a.toString());
            rand.add(a);
            //updateQuestion(ran.nextInt(questionLength1));
            updateQuestion(a);
        }else if(questions.getWeek() == 2){
            Integer a = ran.nextInt(questionLength2);
            rand.add(a);
            updateQuestion(a);
        }else if(questions.getWeek() == 3){
            Integer a = ran.nextInt(questionLength3);
            rand.add(a);
            updateQuestion(a);
        }else if(questions.getWeek() == 4){
            Integer a = ran.nextInt(questionLength4);
            rand.add(a);
            updateQuestion(a);
        }else if(questions.getWeek() == 5){
            Integer a = ran.nextInt(questionLength5);
            rand.add(a);
            updateQuestion(a);
        }else if(questions.getWeek() == 6){
            Integer a = ran.nextInt(questionLength6);
            rand.add(a);
            updateQuestion(a);
        }

        //Validate the user click and update the score, number of correct and incorrect questions
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.getText() == manswer){
                    sc++;
                    //c++;
                    questions.setScore(sc);
                    //questions.setCorrect(c);
                    Toast.makeText(QuizActivity.this,"Press next", Toast.LENGTH_SHORT).show();
                    String ans = questions.getScore().toString();
                    Log.d("answer",ans);
                }else{
                    in++;
                    Log.d("incorrect", "here");
                    questions.setInCorrect(in);
                    Toast.makeText(QuizActivity.this,"Press next", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b2.getText() == manswer){
                    sc++;
                    //c++;
                    questions.setScore(sc);
                    //questions.setCorrect(c);
                    Toast.makeText(QuizActivity.this,"Press next", Toast.LENGTH_SHORT).show();
                    String ans = questions.getScore().toString();
                    Log.d("answer",ans);

                }else{
                    in++;
                    Log.d("incorrect", "here");
                    questions.setInCorrect(in);
                    Toast.makeText(QuizActivity.this,"Press next", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b3.getText() == manswer){
                    sc++;
                    //c++;
                    questions.setScore(sc);
                    //questions.setCorrect(c);
                    Toast.makeText(QuizActivity.this,"Press next", Toast.LENGTH_SHORT).show();
                    String ans = questions.getScore().toString();
                    Log.d("answer",ans);
                }else{
                    in++;
                    Log.d("incorrect", "here");
                    questions.setInCorrect(in);
                    Toast.makeText(QuizActivity.this,"Press next", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b4.getText() == manswer){
                    sc++;
                    //c++;
                    questions.setScore(sc);
                    //questions.setCorrect(c);
                    Toast.makeText(QuizActivity.this,"Press next", Toast.LENGTH_SHORT).show();
                    String ans = questions.getScore().toString();
                    Log.d("answer",ans);
                }else{
                    in++;
                    Log.d("incorrect", "here");
                    questions.setInCorrect(in);
                    Toast.makeText(QuizActivity.this,"Press next", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //After 5 questions have been displayed this will take the user to the result activity
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(max == 5){
                    max = 1;
                    rand.clear();
                    Integer sc = questions.getScore();

                    Intent intent = new Intent(QuizActivity.this, resultActivity.class);
                    intent.putExtra("score", questions.getScore());
                    //intent.putExtra("correct", questions.getCorrect());
                    intent.putExtra("incorrect", questions.getInCorrect());
                    Log.d("inc", "" + questions.getInCorrect());
                    startActivity(intent);
                    /*Integer scr = questions.getScore();
                    Intent intent;
                    intent = getIntent();

                    intent.putExtra("score",scr);

                    ((Activity)v.getContext()).setResult(RESULT_OK,intent);

// int a = ran.
// if(arr.find[a])
//a = ran.
//arr.add(a)


                    //Intent intent = new Intent(quizActivity.this, resultActivity.class);
                    //startActivity(intent);*/
                }else{
                    if(questions.getWeek() == 1){
                        Integer b = ran.nextInt(questionLength1);
                        Integer c = checkRan(b,questionLength1);
                        rand.add(c);
                        updateQuestion(c);
                        max++;
                    }else if(questions.getWeek() == 2){
                        Integer b = ran.nextInt(questionLength2);
                        Integer c = checkRan(b,questionLength2);
                        rand.add(c);
                        updateQuestion(c);
                        max++;
                    }else if(questions.getWeek() == 3){
                        Integer b = ran.nextInt(questionLength3);
                        Integer c = checkRan(b,questionLength3);
                        rand.add(c);
                        updateQuestion(c);
                        max++;
                    }else if(questions.getWeek() == 4){
                        Integer b = ran.nextInt(questionLength4);
                        Integer c = checkRan(b,questionLength4);
                        rand.add(c);
                        updateQuestion(c);
                        max++;
                    }else if(questions.getWeek() == 5){
                        Integer b = ran.nextInt(questionLength5);
                        Integer c = checkRan(b,questionLength5);
                        rand.add(c);
                        updateQuestion(c);
                        max++;
                    }else if(questions.getWeek() == 6){
                        Integer b = ran.nextInt(questionLength6);
                        Integer c = checkRan(b,questionLength6);
                        rand.add(c);
                        updateQuestion(c);
                        max++;
                    }
                }
            }
        });
    }

    //This function is used to display the questions and the options on to the screen
    private void updateQuestion(int num){
        if(questions.getWeek() == 1){
            tv.setText(questions.getQuestion(num));
            b1.setText(questions.getChoice1(num));
            b2.setText(questions.getChoice2(num));
            b3.setText(questions.getChoice3(num));
            b4.setText(questions.getChoice4(num));

            manswer = questions.correctAnswer(num);
        }else if(questions.getWeek() == 2){
            tv.setText(questions.getQuestion(num));
            b1.setText(questions.getChoice1(num));
            b2.setText(questions.getChoice2(num));
            b3.setText(questions.getChoice3(num));
            b4.setText(questions.getChoice4(num));

            manswer = questions.correctAnswer(num);
        }else if(questions.getWeek() == 3){
            tv.setText(questions.getQuestion(num));
            b1.setText(questions.getChoice1(num));
            b2.setText(questions.getChoice2(num));
            b3.setText(questions.getChoice3(num));
            b4.setText(questions.getChoice4(num));

            manswer = questions.correctAnswer(num);
        }else if(questions.getWeek() == 4){
            tv.setText(questions.getQuestion(num));
            b1.setText(questions.getChoice1(num));
            b2.setText(questions.getChoice2(num));
            b3.setText(questions.getChoice3(num));
            b4.setText(questions.getChoice4(num));

            manswer = questions.correctAnswer(num);
        }else if(questions.getWeek() == 5){
            tv.setText(questions.getQuestion(num));
            b1.setText(questions.getChoice1(num));
            b2.setText(questions.getChoice2(num));
            b3.setText(questions.getChoice3(num));
            b4.setText(questions.getChoice4(num));

            manswer = questions.correctAnswer(num);
        }else if(questions.getWeek() == 6){
            tv.setText(questions.getQuestion(num));
            b1.setText(questions.getChoice1(num));
            b2.setText(questions.getChoice2(num));
            b3.setText(questions.getChoice3(num));
            b4.setText(questions.getChoice4(num));

            manswer = questions.correctAnswer(num);
        }
    }

    //This method is used to check if the randomly generated number is same as the one which was previously generated
    //If the number is same that number is popped off the arraylist and new number is inserted into the arraylist
    private Integer checkRan(int rando, int index){
        //my code - start

        if(rand.contains(rando)){
            Integer a = rando;
            while(rand.contains(a)){
                a = ran.nextInt(index);
                if(!rand.contains(a)){
                    rand.add(a);
                    return a;
                }
            }
        }else{
            rand.add(rando);
            return rando;
        }


        //my code = end




        /*if(rand.contains(rando)) {
            Integer a = ran.nextInt(questionLength1);
            Integer d = checkRan(a);
            //while()
            rand.add(d);
            return d;
        }else{
            rand.add(rando);
            return rando;
        }*/
        return 0;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(mauth.getCurrentUser() != null) {
            finish();

            Intent intent = new Intent(QuizActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
