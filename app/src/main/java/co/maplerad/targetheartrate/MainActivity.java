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
    EditText eAge;
    Button calculate;
    TextView maxRate, target;
    double age, targetResult1, targetResult2, maxResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eAge = findViewById(R.id.edAge);
        calculate = findViewById(R.id.btnCalculate);
        maxRate = findViewById(R.id.txtMaxHeartRate);
        target = findViewById(R.id.txtTarget);

        try {
            age = Double.parseDouble(eAge.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maxResult = maximum_heart_rate(NUMBER, age);
                targetResult1 = target_heart_rate(maxResult, FIFTY);
                targetResult2 = target_heart_rate(maxResult, EIGHTY_FIVE);

                maxRate.setText(String.valueOf(maxResult) + "b/m");
                target.setText("The target heart rate is between " + String.valueOf(targetResult1) +
                                " and " + String.valueOf(targetResult2));

            }
        });
    }

    public double maximum_heart_rate(double heartRate, double age) {
        double maxHeartRate = heartRate - age;

        return maxHeartRate;
    }

    public double target_heart_rate(double max_hr, double percentage) {
        double result = (percentage / 100) * max_hr;
        return result;
    }
}
