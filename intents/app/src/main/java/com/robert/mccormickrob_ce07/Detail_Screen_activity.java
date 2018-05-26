package com.robert.mccormickrob_ce07;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Detail_Screen_activity extends AppCompatActivity {

    TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__screen);

        initViews();
    }

    public void initViews(){
        textView1=findViewById(R.id.tv1);
        textView2=findViewById(R.id.tv2);
        textView3=findViewById(R.id.tv3);

        textView1.setText(getIntent().getStringExtra("com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME"));
        textView2.setText(getIntent().getStringExtra("com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME"));
        textView3.setText(String.valueOf(getIntent().getIntExtra("com.fullsail.android.jav2ce08.EXTRA_INT_AGE",0)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_delete,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.delete){
            Intent intent=new Intent();
            intent.putExtra("com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME",textView1.getText().toString());
            intent.putExtra("com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME",textView2.getText().toString());
            intent.putExtra("com.fullsail.android.jav2ce08.EXTRA_INT_AGE", Integer.parseInt(textView3.getText().toString()));
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
