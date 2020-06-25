package com.itridtechnologies.codenamefive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RiderPaymentInformation extends AppCompatActivity {

    private ImageView closePaymentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_payment_information);

        //find views
        closePaymentInfo = findViewById(R.id.close_payment_info);
        //listener
        closePaymentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RiderPaymentInformation.this, RiderProfile.class);
                startActivity(intent);
                //close anim
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }//onCreate

    @Override
    public void finish() {
        super.finish();
        //close anim
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}