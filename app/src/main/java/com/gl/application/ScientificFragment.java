package com.gl.application;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gl.application.Service.ScientificService;
import com.gl.application.ServiceImpl.ScientificServiceImpl;

import static java.lang.Double.parseDouble;

public class ScientificFragment extends Fragment implements View.OnClickListener {

    private Button mCalculateLog;
    private Button mCalculateLn;
    private EditText mNumberInputEditText;
    private TextView mCalculatedLog;
    ScientificService calculateLogService = new ScientificServiceImpl();
    public ScientificFragment() {
    }

    public interface OnFragmentInteractionListener  {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_scientific_, container, false);
        initView(view);
        registerListener();
        return view;
    }

    /**
     * Listener
     */
    private void registerListener() {
        mCalculateLog.setOnClickListener(this);
        mCalculateLn.setOnClickListener(this);
    }

    /**
     * Init View
     * @param view param
     */
    private void initView(View view) {
        mCalculateLog = view.findViewById(R.id.logButton);
        mCalculateLn =  view.findViewById(R.id.logNButton);
        mNumberInputEditText =  view.findViewById(R.id.scientificNumberEditText);
        mCalculatedLog = view.findViewById(R.id.scientificResultTextView);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.logButton:
                calculateLog();
                break;

            case R.id.logNButton:
                 calculateLogN();
                break;
        }

    }

    /**
     * calculate LogN
     */
    private void calculateLogN() {
        String number = mNumberInputEditText.getText().toString();
        if(validateInput(number)){
            double result =  calculateLogService.calculateLogN(parseDouble(mNumberInputEditText.getText().toString()));
            mCalculatedLog.setText(String.format("Result :%s", result));
        }
    }


    /**\
     *  Validate User Input
     * @param inputNumber Double
     * @return Boolean
     */
    public  boolean validateInput(String inputNumber){
        if (TextUtils.isEmpty(inputNumber)) {
            Toast.makeText(getContext(),"Please Enter Numer",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    /**
     * Calculate Log
     */
    private void calculateLog(){
        String number = mNumberInputEditText.getText().toString();
        if(validateInput(number)){
             double result =  calculateLogService.calculateLog(parseDouble(mNumberInputEditText.getText().toString()));
            mCalculatedLog.setText(String.format("Result :%s", result));
        }
    }
}
