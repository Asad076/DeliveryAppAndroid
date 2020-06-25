package com.itridtechnologies.codenamefive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class RiderLoginOtp extends AppCompatActivity {

    Animation bottomUp;
    CardView cardView;
    Button next;
    private TextView riderPhoneNumber;
    private TextView infoMessage;
    private TextInputLayout riderSecurityCode;
    private String msg = "We sent a code to";
    private String msg2 = "Enter your password to login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_login_otp);

        //find views
        cardView = findViewById(R.id.cardViewRiderOtp);
        next = findViewById(R.id.btn_loginRider);
        riderPhoneNumber = findViewById(R.id.tv_rider_phone_num);
        riderSecurityCode = findViewById(R.id.et_partner_security_code);
        infoMessage = findViewById(R.id.tv_msg);

        //getValuesFromPreviousActivity
        getIntentValues();

        //load anim
        bottomUp = AnimationUtils.loadAnimation(this, R.anim.right_to_left_slide);

        //set anim
        cardView.setAnimation(bottomUp);

        //listeners
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RiderLoginOtp.this, RiderAppMenu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }//onCreate

    public void getIntentValues() {

        Intent intent = getIntent();
        String EXTRA_PHONE = intent.getStringExtra("riderPhone");
        String EXTRA_KEYBOARD = intent.getStringExtra("keyboardType");

        assert EXTRA_KEYBOARD != null;
        assert EXTRA_PHONE != null;
        if (!EXTRA_PHONE.isEmpty() && EXTRA_KEYBOARD.equals("phone")) {
            infoMessage.setText(msg);
            riderSecurityCode.getEditText().setHint("Security code");
            riderPhoneNumber.setText(EXTRA_PHONE);
            riderSecurityCode.getEditText().setInputType(3);//phone
        } else if (EXTRA_KEYBOARD.equals("password")) {
            infoMessage.setText(msg2);
            riderSecurityCode.getEditText().setHint("Enter your password");
            riderSecurityCode.getEditText().setInputType(1);//text
        }

    }//end method

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}//end class