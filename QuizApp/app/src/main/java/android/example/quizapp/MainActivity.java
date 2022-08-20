package android.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score;
    boolean startFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* submit button actionListener */
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
            /* grades the submitted answers */
            if(!startFlag) {
                checkAnswers();
                displayScore();
            } else {
                /* displays toast message and score */
                displayScore();
            }
        });
    }

    /* updates question set and progress track */
    public void checkAnswers() {

        /* I only need to check for the correct answer since all my RadioButton are in a
        * toggle group. If correct answer is selected, then the user scores a point. */
        RadioButton radioAnswer1 = findViewById(R.id.option3);
        RadioButton radioAnswer2 = findViewById(R.id.option9);

        if(radioAnswer1.isChecked())
            score++;

        if(radioAnswer2.isChecked())
            score++;

        /* For TextField, I need to check their string value and compare them. */
        TextView textAnswer1 = findViewById(R.id.textField1);
        TextView textAnswer2 = findViewById(R.id.textField2);

        /* Here I trim the spaces of the input answer. */
        if(textAnswer1.getText().toString().trim().equals("animal.charAt(2)"))
            score++;

        if(textAnswer2.getText().toString().equals("3"))
            score++;

        /* For CheckBox, I need to check all their options, whether true or false. */

        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        CheckBox checkBox4 = findViewById(R.id.checkBox4);
        CheckBox checkBox5 = findViewById(R.id.checkBox5);

        if(!checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked()
                && checkBox4.isChecked() && checkBox5.isChecked())
            score++;

        /* the flag ensures that the user's score is graded once only */
        startFlag=true;
    }

    public void displayScore() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Congrats on finishing! Your score is "+ score + "/5",
                Toast.LENGTH_LONG);
        toast.show();
    }
}