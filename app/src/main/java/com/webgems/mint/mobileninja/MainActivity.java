package com.webgems.mint.mobileninja;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.net.Uri;


public class MainActivity extends ActionBarActivity {

    String encodedHash;

    {
        encodedHash = Uri.encode("#");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] ussdCodes = {"Check Airtime", "Buy Whatsapp Bundle", "Buy Facebook Bundle", "Buy Data Bundle", "Buy SMS Bundle", "Send Call me back", "Ecocash"};

        ListAdapter myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ussdCodes);
        ListView ussdListView = (ListView) findViewById(R.id.ussdListView);
        ussdListView.setAdapter(myAdapter);

        // OnClick Listener for launching call intent
        ussdListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String ussdCode = String.valueOf(adapterView.getItemAtPosition(i));

                        switch (ussdCode) {

                            case "Check Airtime":
                                Intent callIntent = new Intent(Intent.ACTION_CALL);
                                callIntent.setData(Uri.parse("tel:*125" + encodedHash));
                                startActivity(callIntent);
                                break;
                            case "Buy Whatsapp Bundle":
                                break;
                            case "Buy Facebook Bundle":
                                break;
                            case "Buy Data Bundle":
                                break;
                            case "Buy SMS Bundle":
                                break;
                            case "Send Call Me Back":
                                break;
                            case "Ecocash":
                                break;

                        }
                    }
                }
        );

        // OnClick Listener echoing out the text of item clicked using a Toast with make text
//        ussdListView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        String ussdCode = String.valueOf(adapterView.getItemAtPosition(i));
//                        Toast.makeText(MainActivity.this, ussdCode, Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
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
