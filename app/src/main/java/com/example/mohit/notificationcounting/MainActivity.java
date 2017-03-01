package com.example.mohit.notificationcounting;

import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;



        import android.graphics.Bitmap;
        import android.graphics.drawable.BitmapDrawable;
        import android.graphics.drawable.Drawable;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
import android.widget.Toast;

import com.mohit.notificationcounting.R;


public class MainActivity extends ActionBarActivity {

    public Button small,middle, large,xlarge,dxlarge,txlarge;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Button increaseButton = (Button) findViewById(R.id.increaseButton);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIncrease();
            }
        });
        */
    }


    public void buttonClicked(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);

        small = (Button)alertLayout.findViewById(R.id.s);
        middle = (Button)alertLayout.findViewById(R.id.m);
        large = (Button)alertLayout.findViewById(R.id.l);
        xlarge=(Button) alertLayout.findViewById(R.id.xl);
        dxlarge=(Button) alertLayout.findViewById(R.id.dxl);
        txlarge=(Button) alertLayout.findViewById(R.id.txl);


        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doIncrease();
                Toast.makeText(getBaseContext(), "small size added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doIncrease();
                Toast.makeText(getBaseContext(), "middle size added to cart", Toast.LENGTH_SHORT).show();
            }
        });


        large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doIncrease();
                Toast.makeText(getBaseContext(), "large size added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        xlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doIncrease();
                Toast.makeText(getBaseContext(), "xtra large size added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        dxlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doIncrease();
                Toast.makeText(getBaseContext(), "2xl size added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        txlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doIncrease();
                Toast.makeText(getBaseContext(), "3xl size added to cart", Toast.LENGTH_SHORT).show();
            }
        });


        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        // alert.setTitle("SELECT SIZE");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch

        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {



            }
        });

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // String user = etUsername.getText().toString();
                //String pass = etPassword.getText().toString();
                //  Toast.makeText(getBaseContext(), "Username: " + user + " Password: " + pass, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.testAction);
       menuItem.setIcon(buildCounterDrawable(count, R.drawable.smiley));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            Toast.makeText(getApplicationContext(),"This is my toast message",Toast.LENGTH_LONG).show();



            return true;

        }
        if(id==R.id.testAction) {

            Toast.makeText(getApplicationContext(),"This is next page",Toast.LENGTH_LONG).show();
            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    private Drawable buildCounterDrawable(int count, int backgroundImageId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.counter_menuitem_layout, null);
        view.setBackgroundResource(backgroundImageId);

        if (count == 0) {
            View counterTextPanel = view.findViewById(R.id.counterValuePanel);
            counterTextPanel.setVisibility(View.GONE);
        } else {
            TextView textView = (TextView) view.findViewById(R.id.count);
            textView.setText("" + count);
        }

        view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        return new BitmapDrawable(getResources(), bitmap);
    }

    private void doIncrease() {
        count++;
        invalidateOptionsMenu();
    }
}
