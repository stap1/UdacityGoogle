package pl.com.przybylek.littlecatquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CatQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_quiz);
    }

    /**
     * This method is called when a button Next in name_enter.xml is pressed
     */
    public void namesubmit(View view) {
        /** This part recovers editable value from player name edit text and converts it to string */
        EditText playernameinput = (EditText) findViewById(R.id.playername);
        String playername = playernameinput.getText().toString();
        /** This part challenges player name string length and if empty default name is set*/
        if (playername.length() == 0) {
            playername = getString(R.string.playerdefaultname);
        }
        playernameinput.setVisibility(View.GONE);
        String playerwelcome = playerwelcome(playername);
        TextView welcomeText = (TextView) findViewById(R.id.textfieldname);
        welcomeText.setText(playerwelcome);
        Button submitname = (Button) findViewById(R.id.buttonnext);
        submitname.setVisibility(View.GONE);
    }

    private String playerwelcome(String playername) {
        String welcometext = (getString(R.string.playernameinput));
        welcometext += (" " + playername);
        welcometext += ("!");
        return welcometext;
    }

    /**
     * This method is called when Submit score button is pressed
     *
     * @param score counts correct answers
     */
    public void calculateScore(View view) {
        int score = 0;
        /** Part 1 - Question 1 - True */
        RadioButton question1_1 = findViewById(R.id.question1);
        boolean correct1_1 = question1_1.isChecked();
        /** Part 1 - Question 2 - True */
        RadioButton question1_2 = findViewById(R.id.question2);
        boolean correct1_2 = question1_2.isChecked();
        /** Part 1 - Question 3 - True */
        RadioButton question3 = findViewById(R.id.question3);
        boolean correct1_3 = question3.isChecked();
        /** Part 1 - Question 3 - False */
        RadioButton question1_4 = findViewById(R.id.question4);
        boolean correct1_4 = question1_4.isChecked();
        /** Part2 - Checkbox cardboard true */
        CheckBox checkBoxCardboard = findViewById(R.id.CheckBoxCardboard);
        boolean checkbox1 = checkBoxCardboard.isChecked();
        /** Part2 - Checkbox scratch pole true */
        CheckBox checkBoxScratch = findViewById(R.id.CheckBoxScratchPole);
        boolean checkbox2 = checkBoxScratch.isChecked();
        /** Part2 - Checkbox cosmetic stick true */
        CheckBox checkBoxCosmetic = findViewById(R.id.CheckBoxCosmeticStick);
        boolean checkbox3 = checkBoxCosmetic.isChecked();
        /** Part2 - Checkbox toy mouse true */
        CheckBox checkBoxToy = findViewById(R.id.CheckBoxToyMouse);
        boolean checkbox4 = checkBoxToy.isChecked();
        /** Part2 - Checkbox cucumber false */
        CheckBox checkBoxCucumber = findViewById(R.id.CheckBoxCucumber);
        boolean checkbox5 = checkBoxCucumber.isChecked();
        /** Part2 - Checkbox old boots false */
        CheckBox checkBoxBoots = findViewById(R.id.CheckBoxBoots);
        boolean checkbox6 = checkBoxBoots.isChecked();
        /** Part 3 - Question 1 - Bastet */
        RadioButton question3_1 = findViewById(R.id.question3_1);
        boolean correct3_1 = question3_1.isChecked();
        /** Part 3 - Question 2 - Maneki-Neko */
        RadioButton question3_2 = findViewById(R.id.question3_2);
        boolean correct3_2 = question3_2.isChecked();
        /** Part 3 - Question 3 - Carnivore */
        RadioButton question3_3 = findViewById(R.id.question3_3);
        boolean correct3_3 = question3_3.isChecked();
        if (correct1_1) {
            score++;
        }
        if (correct1_2) {
            score++;
        }
        if (correct1_3) {
            score++;
        }
        if (correct1_4) {
            score++;
        }
        if (checkbox1) {
            score++;
        }
        if (checkbox2) {
            score++;
        }
        if (checkbox3) {
            score++;
        }
        if (checkbox4) {
            score++;
        }
        if (!checkbox5) {
            score++;
        }
        if (!checkbox6) {
            score++;
        }
        if (correct3_1) {
            score++;
        }
        if (correct3_2) {
            score++;
        }
        if (correct3_3) {
            score++;
        }
        createToast(score);
    }

    private void createToast(int score) {
        String scoreMessage = getString(R.string.textscore1);
        scoreMessage += Integer.toString(score);
        scoreMessage += getString(R.string.textscore2);

        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context, scoreMessage, 15);
        toast.show();
    }

}
