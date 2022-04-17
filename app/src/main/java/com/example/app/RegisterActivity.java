package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.*;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextRegisterFullName, editTextRegisterEmail, editTextRegisterDoB, editTextRigesterMobile,
            editTextRegisterPwd, editTextRegisterConfirmPwd;
    private ProgressBar progressBar;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");
        Toast.makeText(RegisterActivity.this,"You can register now",Toast.LENGTH_LONG).show();

        editTextRegisterFullName = findViewById(R.id.editText_register_full_name);

        editTextRegisterEmail = findViewById(R.id.editText_register_email);
        editTextRegisterDoB = findViewById(R.id.editText_register_dob);
        editTextRigesterMobile  =findViewById(R.id.editText_register_mobile);
        editTextRegisterPwd = findViewById(R.id.editText_register_password);
        editTextRegisterConfirmPwd = findViewById(R.id.editText_register_confirm_password);

        // Radio butten for Gender
        radioGroupRegisterGender = findViewById(R.id.radio_group_register_gender);
        radioGroupRegisterGender.clearCheck();

        Button buttonRegister = findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);

                //Obatain the entered data

                String textFullName = editTextRegisterFullName.getText().toString();
                String textEmail = editTextRegisterEmail.getText().toString();
                String textDoB = editTextRegisterDoB.getText().toString();
                String textMobile = editTextRigesterMobile.getText().toString();
                String textPwd = editTextRegisterPwd.getText().toString();
                String textConfirmPwd = editTextRegisterConfirmPwd.getText().toString();
                String textGender;  // can't obtain the value before verifying if any button was selected or not

                if(TextUtils.isEmpty(textFullName)){
                    Toast.makeText(RegisterActivity.this,"Please enter your full name", Toast.LENGTH_LONG).show();
                    editTextRegisterFullName.setError("Error Name is required");
                    editTextRegisterFullName.requestFocus();
                }
                else if(TextUtils.isEmpty(textEmail)){
                    Toast.makeText(RegisterActivity.this,"Please enter Email", Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError("Email is required");
                    editTextRegisterEmail.requestFocus();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
                    Toast.makeText(RegisterActivity.this,"Please re_enter your email",Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError("Valid email is required");
                    editTextRegisterEmail.requestFocus();
                }
                else if(TextUtils.isEmpty(textDoB)){
                    Toast.makeText(RegisterActivity.this,"Please enter your Date of Birth",Toast.LENGTH_LONG).show();
                    editTextRegisterDoB.setError("Date of Birth is required");
                    editTextRegisterDoB.requestFocus();
                }
                else if(radioGroupRegisterGender.getCheckedRadioButtonId()==-1){
                    Toast.makeText(RegisterActivity.this,"Please select your gender",Toast.LENGTH_LONG).show();
                    radioButtonRegisterGenderSelected.setError("Gender is required");
                    radioButtonRegisterGenderSelected.requestFocus();
                }
                else if(TextUtils.isEmpty(textMobile)){
                    Toast.makeText(RegisterActivity.this,"Please enter your mobile",Toast.LENGTH_LONG).show();
                    editTextRigesterMobile.setError("Mobile no should be 10 digits");
                    editTextRigesterMobile.requestFocus();
                }
                else if(TextUtils.isEmpty(textPwd)){
                    Toast.makeText(RegisterActivity.this,"Please enter your Password",Toast.LENGTH_LONG).show();
                    editTextRegisterPwd.setError("Password is required");
                    editTextRegisterPwd.requestFocus();
                }
                else if(textPwd.length()<6){
                    Toast.makeText(RegisterActivity.this,"Password should be atleast 6 digits",Toast.LENGTH_LONG).show();
                    editTextRegisterPwd.requestFocus();
                }
                else if(TextUtils.isEmpty(textConfirmPwd)){
                    Toast.makeText(RegisterActivity.this,"Please confirm your Password",Toast.LENGTH_LONG).show();
                    editTextRegisterConfirmPwd.setError("Password confirmation is required");
                    editTextRegisterConfirmPwd.requestFocus();
                }
                else if(!textPwd.equals(textConfirmPwd)){
                    Toast.makeText(RegisterActivity.this,"Please enter same password",Toast.LENGTH_LONG).show();
                    editTextRegisterConfirmPwd.setError("Password confirmatin is required");
                    editTextRegisterConfirmPwd.requestFocus();

                    // clear the entered passwords
                    editTextRegisterPwd.clearComposingText();
                    editTextRegisterConfirmPwd.clearComposingText();
                }
                else {
                    textGender = radioButtonRegisterGenderSelected.getText().toString();
                    progressBar.setVisibility(view.VISIBLE);
                    registeruser(textFullName,textEmail,textDoB,textGender,textMobile,textPwd);
                }

            }


        });
    }
    // Register User using the credinatail given
    private void registeruser(String textFullName, String textEmail, String textDoB, String textGender, String textMobile, String textPwd) {

    }
}
