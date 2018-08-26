//This class is used to store the questions, choices, correct answers in the form of array
//This lets the other activities to access the arrays and validate if the answer is correct or not
//2D array is used to store the choices.
package edu.niu.z1829451.quizfinal;

import android.util.Log;

public class Questions {

    private Integer score = 0, week = 0, incorrect = 0, correct = 0;

    public void setScore(Integer sc) {
        score = sc;
    }

    public Integer getScore() {
        return score;
    }

    public void setCorrect(Integer cor){
        correct = cor;
    }

    public Integer getCorrect(){
        return  correct;
    }

    public void setInCorrect(Integer inCor){
        incorrect = inCor;
    }

    public Integer getInCorrect(){
        return  incorrect;
    }

    public void setWeek(Integer wk) {
        week = wk;
        Log.d("here", week.toString());
    }

    public Integer getWeek() {
        Log.d("here", week.toString());
        return week;
    }

    public  String questions1[] = {
            "Most lines in a C++ program end with a",
            "main() marks the beginning of a C++ program. What C++ reserved word precedes it?",
            "What is the correct way to declare an integer variable named \"score\"?",
            "When you write an illegal C++ statement and try to compile and run the program, you will get a",
            "Which data type has the largest range?",
            "About how many decimal places of accuracy does a float have?",
            "double x; What is the value of x?",
            "What is the value (in C++) of the expression 4 / 2 * 2?",
            "What is the value (in C++) of the expression 3/2?",
            "Which data type has a range of plus or minus 10 to the 38th?"
    };

    public String questions2[] = {
            "What instruction will display data on the screen from a C++ program?",
            "About how many decimal places of accuracy does a float have?",
            "What is the value of the expression 25 % 3?",
            "Suppose you have two integer variables with valid values. Which statement do you use to display the integer values?",
            "which two libraries should be #include'd at the top of a C++ program ?",
            "Which statement is used to get input from the user?"
    };

    public String questions3[] = {
            "Which of the following increments x by 1?",
            "The while loop can be described as a",
            "When is the 3rd subexpression in for (--; --; --) statement executed?",
            "If a read-loop is written to process an unknown number of values using the while construct, and if there is one read before the while instruction there will also be one",
            "Why is a while loop described as \"top-driven\" ?",
            "Select the 3 C++ statements used to create a loop.",
            "Select one command that is used to implement the decision statement control structure that will be studied in this course.",
            "the do while loop can be described as a "
    };

    public String questions4[] = {
            "The three basic loop statements in C++ are while,",
            "The three basic flow-of-control patterns are sequence,",
            "Which of the following is a legal way to create a C-style symbolic constant?",
            "Create a symbolic constant named PI to represent the value of pi (3.14) in two different ways.",
            "What are the two ways to define constants",
            "What do we call the 1st subexpression in for (--; --; --) ?"
    };

    public String questions5[] = {
            "main() is a function.",
            "A function knows _______ about the calling code.",
            " Every function must return a value.",
            "It is legal and acceptable to have two local variables in two different functions with the same name and the same data type.",
            "With what we have learned so far about C++ functions, a function can directly (i.e. by itself, not as a consequence of an assignment statement in the calling function) alter _____________ in the calling function",
            " If a function takes two integer arguments it"
    };

    public String choices5[][] = {
            {"true", "false", "I dont know", "Maybe"},
            {"something", "nothing", "everything", "I dont know"},
            {"true", "false", "I dont know", "Maybe"},
            {"true", "false","only if they always have different values", "only if they always have the same value"},
            {"no values","at most 1 value", "1 or more values", "I dont know"},
            {"must return an int", "must return a numeric value of some kind", "can return any valid data type", "I dont know"}
    };

    public String correctAnswers5[] = {"true", "everything", "false", "true", "1 or more values", "must return an int"};

    public String questions6[] = {
            "The data type char and the data type __________ are often interchageable in C++.",
            "What will happen if a char is cout'd as an int?",
            "What is the ASCII value of the character 1 ?",
            "What is the ASCII value of the character c ?",
            "What is the ASCII value of the character b ?",
            "What is the ASCII value of the character a ?"
    };

    public String choices6[][] = {
            {"double", "float", "int", "string"},
            {"the character will be displayed", "the ASCII value of the character will be displayed", "it will not compile", "it will produce a run-time error"},
            {"49", "50", "51", "52"},
            {"99", "100", "101", "102"},
            {"98", "99", "100", "101"},
            {"97", "98", "99", "100"}
    };

    public String correctAnswers6[] = {"string", "the ASCII value of the character will be displayed", "49", "99", "98", "97"};

    public String choices4[][] = {
            {"do while and for","if else","int","float"},
            {"if and else","for","while", "do while"},
            {"#define MAX_VAL = 30;","#define MAX_VAL 30","#define MAX_VAL = 30","#define MAX_VAL"},
            {"#define PI 3.14; , const int PI = 3.14;","int pi = 3.14", "string PI = 3.14", "char PI = 3.14"},
            {"c and c++ style", "string and float", "for and while","functions and constants"},
            {"Initialization","increment","condition","loop"}
    };

    public String correctAnswers4[] = {"do while and for","if and else","#define MAX_VAL 30","#define PI 3.14; , const int PI = 3.14;","c and c++ style","Initialization"};
    public String choices3[][] = {
            {"1++", "x=1", "x+=", "x++"},
            {"top driven loop", "bottom driven loop", "decision statement", "variable"},
            {"at the top", "at the bottom", "after termination of loop", "It is never executed"},
            {"at the top of the body of the loop", "at the bottom of the body of the loop","in the middle of the body of the loop", "there are no other reads"},
            {"The condition is checked at the top", "The increment is done at the top", "The initialization is done at the top", "None of the above"},
            {"for while do while", "if and else", "cin and cout", "setprecision fixed iomanip" },
            {"if else", "while", "for", "do while"},
            {"bottom driven loop", "top driven loop","Decision statement","integer"}
    };

    public String correctAnswers3[] = {"x++", "top driven loop","at the bottom","at the bottom of the body of the loop","The condition is checked at the top","for while do while","if else","bottom driven loop"};


    private String choices1[][] = {
            {": (colon)", "; (semi-colon)", "} (closing brace)", ") (closing paranthesis)"},
            {"#include", "using", "void", "int"},
            {"int score", "int score;", "score: integer;", "integer score;"},
            {"compile error", "run-time error", "logic error", "machine crash"},
            {"int", "float", "double", "it depends on the input value"},
            {"31", "12", "6", "4"},
            {"0", "22", "1", "Garbage value"},
            {"2", "4", "8", "32"},
            {"1", "1.5", "5", "32"},
            {"int", "double", "string", "float"}
    };

    private String choices2[][] = {
            {"int", "cin", "cout", "display"},
            {"31", "12", "6","4"},
            {"8", "1",  "0", "Undefined"},
            {"int", "cin", "cout", "display"},
            {"cout and cin", "iostream and iomanip", "printf and scanf", "getch and putch"},
            {"function", "cin", "cout", "static"}
    };

    private String correctAnswers1[] = {"; (semi-colon)", "int", "int score;", "compile error", "double", "6", "Garbage value", "4", "1", "float"};

    private String correctAnswers2[] = {"cout", "6", "8", "cout", "iostream and iomanip", "cin"};



    public String getQuestion(int a){
        String question = null;
        if(week == 1){
            question = questions1[a];
        }else if(week == 2){
            question = questions2[a];
        }else if(week == 3){
            question = questions3[a];
        }else if(week == 4){
            question = questions4[a];
        } else if(week == 5){
            question = questions5[a];
        } else if(week == 6){
            question = questions6[a];
        }
        return question;
    }

    public String getChoice1(int a){
        String choice = null;
        if(week == 1){
            choice = choices1[a][0];
        }else if(week == 2){
            choice = choices2[a][0];
        }else if(week == 3){
            choice = choices3[a][0];
        }else if(week == 4){
            choice = choices4[a][0];
        }else if(week == 5){
            choice = choices5[a][0];
        }else if(week == 6){
            choice = choices6[a][0];
        }
        return choice;
    }

    public String getChoice2(int a){
        String choice = null;
        if(week == 1){
            choice = choices1[a][1];
        }else if(week == 2){
            choice = choices2[a][1];
        }else if(week == 3){
            choice = choices3[a][1];
        }else if(week == 4){
            choice = choices4[a][1];
        }else if(week == 5){
            choice = choices5[a][1];
        }else if(week == 6){
            choice = choices6[a][1];
        }
        return choice;
    }

    public String getChoice3(int a){
        String choice = null;
        if(week == 1){
            choice = choices1[a][2];
        }else if(week == 2){
            choice = choices2[a][2];
        }else if(week == 3){
            choice = choices3[a][2];
        }else if(week == 4){
            choice = choices4[a][2];
        }else if(week == 5){
            choice = choices5[a][2];
        }else if(week == 6){
            choice = choices6[a][2];
        }
        return choice;
    }

    public String getChoice4(int a){
        String choice = null;
        if(week == 1){
            choice = choices1[a][3];
        }else if(week == 2){
            choice = choices2[a][3];
        }else if(week == 3){
            choice = choices3[a][3];
        }else if(week == 4){
            choice = choices4[a][3];
        }else if(week == 5){
            choice = choices5[a][3];
        }else if(week == 6){
            choice = choices6[a][3];
        }
        return choice;
    }

    public String correctAnswer(int a){
        String answer = null;
        if(week == 1){
            answer = correctAnswers1[a];
        }else if(week == 2){
            answer = correctAnswers2[a];
        }else if(week == 3){
            answer = correctAnswers3[a];
        }else if(week == 4){
            answer = correctAnswers4[a];
        }else if(week == 5){
            answer = correctAnswers5[a];
        }else if(week == 6){
            answer = correctAnswers6[a];
        }
        return answer;
    }
}
