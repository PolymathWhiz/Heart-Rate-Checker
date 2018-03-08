package co.maplerad.targetheartrate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final double NUMBER = 220,
            EIGHTY_FIVE = 85,
            FIFTY = 50;

    EditText userEditText;
    Button calculate;
    TextView maxRate, target;

    double enteredAge = 0,
            targetResult1 = 0,
            targetResult2 = 0,
            maxResult = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEditText = findViewById(R.id.editText);
        calculate = findViewById(R.id.btnCalculate);
        maxRate = findViewById(R.id.txtMaxHeartRate);
        target = findViewById(R.id.txtTarget);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enteredAge = Double.parseDouble(userEditText.getText().toString());

                maxResult = maximum_heart_rate(NUMBER, enteredAge);
                targetResult1 = target_heart_rate(maxResult, FIFTY);
                targetResult2 = target_heart_rate(maxResult, EIGHTY_FIVE);

                maxRate.setText(String.valueOf(maxResult) + "b/m");
                target.setText("Between " + String.valueOf(targetResult1) +
                        " to " + String.valueOf(targetResult2));

            }
        });
    }

    public double maximum_heart_rate(double heartRate, double age) {
        return heartRate - age;
    }

    public double target_heart_rate(double max_hr, double percentage) { return (percentage / 100) * max_hr; }
}
