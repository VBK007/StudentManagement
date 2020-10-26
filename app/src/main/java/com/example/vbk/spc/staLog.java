package com.example.vbk.spc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vbk.spc.Common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class staLog extends AppCompatActivity {

    Button btnStaLogin;
    EditText edtid,edtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sta_log);

        btnStaLogin=(Button)findViewById(R.id.staLogin);
        edtid=(MaterialEditText)findViewById(R.id.stid);
        edtpass=(MaterialEditText)findViewById(R.id.pwd);

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_staff=database.getReference("Staff");


        btnStaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(staLog.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_staff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(edtid.getText().toString()).exists()) {


                            mDialog.dismiss();
                            Staff staff = dataSnapshot.child(edtid.getText().toString()).getValue(Staff.class);

                            if (staff.getPassword().equals(edtpass.getText().toString())) {

                                Intent homeIn=new Intent(staLog.this,MainActivity.class);
                                Common.currentStaff=staff;
                                startActivity(homeIn);
                                finish();
                                Toast.makeText(staLog.this, "LoginSuccesfully!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(staLog.this, "LoginFailed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(staLog.this, "User not Found!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
