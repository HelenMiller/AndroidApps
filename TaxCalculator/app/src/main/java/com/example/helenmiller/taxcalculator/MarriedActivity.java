package com.example.helenmiller.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MarriedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_married);
        final EditText individualIncomeEntered = ((EditText) findViewById(R.id.txtEnterIncomeM));

        Button submitIncome = (Button) findViewById(R.id.btnSubmitM); // submit button
        submitIncome.setOnClickListener(new View.OnClickListener() {



            final TextView taxDue = ((TextView) findViewById(R.id.TaxDueM));  // TextView which will show user what taxes they owe


            public void onClick(View v) {

                if(individualIncomeEntered.length() == 0)
                {
                    Toast.makeText(MarriedActivity.this, "You must enter an income", Toast.LENGTH_LONG).show();

                }
                else
                {


                boolean takeDeductionM;
                final RadioButton isDeductionChecked = (RadioButton) findViewById(R.id.radioDedcutionM);
                if (isDeductionChecked.isChecked())
                {
                    takeDeductionM = true;
                }
                else
                {
                    takeDeductionM = false;
                }

                double incomeEntered = Double.parseDouble(individualIncomeEntered.getText().toString()); // parsing user input from String to int


                    DecimalFormat currency = new DecimalFormat("$###,###.00"); // creating currency object to format tax due

                    taxDue.setText(currency.format(TaxBrackets.getTaxBurden(incomeEntered, true, takeDeductionM)));

                }
            }

        });
    }
    }

