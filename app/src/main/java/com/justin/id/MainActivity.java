package com.justin.id;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView ed_name;
    private TextView ed_mail;
    private Button summit;
    private TextView countN;
    private TextView countM;
    int number =0;
    int mail =0;
    int count=0;
    private String message;
    private String message2;
    private String message3;
    private ImageView smile;
    private ImageView smiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ed_name = findViewById(R.id.editName);
        ed_mail = findViewById(R.id.editMail);
        summit = findViewById(R.id.summit);
        countN = findViewById(R.id.countNumber);
        countM = findViewById(R.id.mail);
        FloatingActionButton fab = findViewById(R.id.fab);
        smile = findViewById(R.id.imageView);
        smiles = findViewById(R.id.imageView2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    public  void reset(){
        mail =0;
        number =0;
        countN.setText(String.valueOf(mail));
        countM.setText(String.valueOf(number));
        count=0;
    }
        public void result (View view){
            DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
            reset();
                }
            };

            if (ed_name.getText().length()<5&&ed_mail.getText().length()<8){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("result")
                        .setMessage("mail fail&name fail"+"\n"+"please enter again")
                        .setPositiveButton("ok",null)
                        .show();
                count++;
                number++;
                mail++;
                countN.setText(Integer.toString(number));
                countM.setText(String.valueOf(mail));
                smile.setVisibility(View.VISIBLE);
                smiles.setVisibility(View.VISIBLE);
            }
            else if (ed_mail.getText().length()<8){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("result")
                        .setMessage("mail fail")
                        .setPositiveButton("ok",null)
                        .show();
                mail++;
                countM.setText(Integer.toString(mail));
                message ="mail fail";
                count++;
                smiles.setVisibility(View.VISIBLE);
                smiles.setVisibility(View.GONE);
            }
            else if (ed_name.getText().length()<5){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("result")
                        .setMessage("name fail")
                        .setPositiveButton("ok",null)
                        .show();
                number ++;
                countN.setText(Integer.toString(number));
                message ="number fail";
                count++;
                smiles.setVisibility(View.VISIBLE);
                smile.setVisibility(View.GONE);
            }
            else {
                count++;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("result")
                        .setMessage("you guess: "+count+"\n"+
                                "your name is :"+ed_name.getText()+"\n"+
                                        "your email is: "+ed_mail.getText()
                                )
                        .setPositiveButton("ok",listener)
                        .show();
                smile.setVisibility(View.GONE);
                smiles.setVisibility(View.GONE);
            }
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
