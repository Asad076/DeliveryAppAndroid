package com.itridtechnologies.codenamefive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class RiderLogin extends AppCompatActivity {

    private static final Pattern phoneNumPattern = Pattern.compile("^\\s*(?:\\+" +
            "?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$");
    private CardView cardView;
    private Animation bottomUp;
    private Button loginRider;
    private TextInputLayout riderPhoneOrEmail;
    private boolean inputOk;
    private String keyboardType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_login);

        //find views
        cardView = findViewById(R.id.cardViewRiderLogin);
        loginRider = findViewById(R.id.btn_loginRider);
        riderPhoneOrEmail = findViewById(R.id.et_partnerPhoneEmail);
        //load anim
        bottomUp = AnimationUtils.loadAnimation(this, R.anim.right_to_left_slide);
        //set anim
        cardView.setAnimation(bottomUp);
        //setInputType
        try {
            riderPhoneOrEmail.getEditText().setInputType(1);
        } catch (Exception e) {
            Toast.makeText(this, "Keyboard Type Exception", Toast.LENGTH_SHORT).show();
        }

        //listeners
        loginRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
                if (inputOk) {
                    riderPhoneOrEmail.setError(null);
                    Intent intent = new Intent(RiderLogin.this, RiderLoginOtp.class);
                    //send values to next activity
                    intent.putExtra("riderPhone", riderPhoneOrEmail.getEditText().getText().toString());
                    intent.putExtra("keyboardType", keyboardType);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }//validation
        });

    }//onCreate

    //methods
    private void validateInput() {

        inputOk = false;
        String input = riderPhoneOrEmail.getEditText().getText().toString().trim();

        if (input.isEmpty()) {
            riderPhoneOrEmail.setError("Field can't be empty");
            inputOk = false;
        } else if (Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
            inputOk = true;
            keyboardType = "password";
        } else if (phoneNumPattern.matcher(input).matches()) {
            inputOk = true;
            keyboardType = "phone";
        } else {
            riderPhoneOrEmail.setError("Invalid Phone or Email");
            inputOk = false;
        }
    }//end validate email

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}