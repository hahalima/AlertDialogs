package com.example.chris_000.alertdialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private Button showDialog;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showButtonId);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show the AlertDialog
                dialog = new AlertDialog.Builder(MainActivity.this);
                //Set title
                dialog.setTitle(getResources().getString(R.string.dialog_title));
                //Set message
                dialog.setMessage(getResources().getString(R.string.dialog_message));
                //Set cancelable
                dialog.setCancelable(false);
                //Set an icon
                dialog.setIcon(android.R.drawable.sym_def_app_icon);
                //Set Positive Button
                dialog.setPositiveButton(getResources().getString(R.string.positive_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Exit activity
                                MainActivity.this.finish();
                            }
                        }
                );
                //Set Negative Button
                dialog.setNegativeButton(getResources().getString(R.string.negative_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }

                );
                AlertDialog alertD = dialog.create();
                alertD.show();
            }
        });


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
