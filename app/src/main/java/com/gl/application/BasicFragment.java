package com.gl.application;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gl.application.Service.BasicService;
import com.gl.application.ServiceImpl.BasicServiceImpl;

import static java.lang.Double.parseDouble;

public class BasicFragment extends Fragment implements View.OnClickListener {

    private boolean shouldRefreshOnResume = false;
    private Button mCalculateAddition;
    private Button mCalculateSubtraction;
    private Button mCalculateMultiplication;
    private Button mCalculateDivision;
    private EditText mFirstNumberInput;
    private EditText mSecondNumberInput;
    private TextView mResultTextView;


    BasicService basicService = new BasicServiceImpl();
    public BasicFragment() {
    }
     interface OnFragmentInteractionListener {
         void onFragmentInteraction(Uri uri);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View view =  inflater.inflate(R.layout.fragment_basic_, container, false);
           initView(view);
          registerListener();
        return view;
    }

    /**
     * Register Listener
     */
    private void registerListener() {
        mCalculateAddition.setOnClickListener(this);
        mCalculateMultiplication.setOnClickListener(this);
        mCalculateDivision.setOnClickListener(this);
        mCalculateSubtraction.setOnClickListener(this);

    }
    /**
     * init View
     * @param view view
     */
    private void initView(View view) {
        mCalculateAddition = view.findViewById(R.id.addButton);
        mCalculateSubtraction = view.findViewById(R.id.subtractButton);
        mCalculateDivision = view.findViewById(R.id.divideButton);
        mCalculateMultiplication = view.findViewById(R.id.multiplyButton);
        mFirstNumberInput = view.findViewById(R.id.firstNumberEditText);
        mSecondNumberInput = view.findViewById(R.id.secondNumberEditText);
        mResultTextView = view.findViewById(R.id.resultTextView);

    }

    /**\
     *  Validate User Input
     * @param inputNumber1 Double
     *  @param inputNumber2 Double
     * @return Boolean
     */
    public  boolean validateInput(String inputNumber1, String inputNumber2){
        boolean status = true;
        if (TextUtils.isEmpty(inputNumber1)) {
            Toast.makeText(getContext(),"Please Enter Number",Toast.LENGTH_LONG).show();
            status = false;
        }

        if (TextUtils.isEmpty(inputNumber2)) {
            Toast.makeText(getContext(),"Please Enter Number",Toast.LENGTH_LONG).show();
          status = false;
        }
        return status;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addButton:
                calculateAddition();
                break;
            case  R.id.subtractButton:
                calculateSubtraction();
                break;
            case R.id.multiplyButton:
                calculateMultiplication();
                break;
            case R.id.divideButton:
                calculateDivision();
                break;
        }
    }

    /**
     * Perform Division
     */
    private void calculateDivision() {
        String number1 = mFirstNumberInput.getText().toString();
        String number2 = mSecondNumberInput.getText().toString();
        if(validateInput(number1, number2)){
            double result =  basicService.performDivision(parseDouble(mFirstNumberInput.getText().toString()),
                    parseDouble(mSecondNumberInput.getText().toString()));
            mResultTextView.setText(String.format("Result :%s", result));
        }
    }

    /**
     * Perform Multiplication
     */
    private void calculateMultiplication() {
        String number1 = mFirstNumberInput.getText().toString();
        String number2 = mSecondNumberInput.getText().toString();
        if(validateInput(number1, number2)){
            double result =  basicService.performMultiplication(parseDouble(mFirstNumberInput.getText().toString()),
                    parseDouble(mSecondNumberInput.getText().toString()));
            mResultTextView.setText(String.format("Result :%s", result));
        }
    }

    /**
     *  Perform Subtraction
     */
    private void calculateSubtraction() {
        String number1 = mFirstNumberInput.getText().toString();
        String number2 = mSecondNumberInput.getText().toString();
        if(validateInput(number1, number2)){
            double result =  basicService.performSubtraction(parseDouble(mFirstNumberInput.getText().toString()),
                    parseDouble(mSecondNumberInput.getText().toString()));
            mResultTextView.setText(String.format("Result :%s", result));
        }
    }


    /**
     * Calculate Addition
     */
    private void calculateAddition(){
        String number1 = mFirstNumberInput.getText().toString();
        String number2 = mSecondNumberInput.getText().toString();
        if(validateInput(number1, number2)){
            double result =  basicService.performAddition(parseDouble(mFirstNumberInput.getText().toString()),
                    parseDouble(mSecondNumberInput.getText().toString()));
            mResultTextView.setText(String.format("Result :%s", result));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Check should we need to refresh the fragment
        if(shouldRefreshOnResume){
           Toast.makeText(getContext(),"Refreshh",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        shouldRefreshOnResume = true;
    }
}

