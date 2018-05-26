package com.robert.mccormickrob_ce07;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class Form_Activity extends AppCompatActivity {

    EditText editText1,editText2,editText3;
    String name,course,phone;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        InitViews();

    }

    public void InitViews(){
        editText1=findViewById(R.id.ed1);
        editText2=findViewById(R.id.ed2);
        editText3=findViewById(R.id.ed3);
    }

    public void loadData(){
        name=editText1.getText().toString();
        course=editText2.getText().toString();
        age= Integer.parseInt(editText3.getText().toString());

        Intent i=new Intent();

        /*Bundle bundle=new Bundle();
        bundle.putString("Name",name);
        bundle.putString("Course",course);
        bundle.putString("Phone",phone);*/

        i.putExtra("com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME",name);
        i.putExtra("com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME",course);
        i.putExtra("com.fullsail.android.jav2ce08.EXTRA_INT_AGE",age);
        setResult(Activity.RESULT_OK,i);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.save){
            loadData();
        }
        return super.onOptionsItemSelected(item);
    }
}
