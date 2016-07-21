package id.prasetiyo.myfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        manager = getFragmentManager();
        Fragment newFragment = new Main2Fragment();
        FragmentTransaction transaction =manager.beginTransaction();
        transaction.replace(R.id.fragment,newFragment,"A").commit();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Fragment newFragment = new DetailsFragment();
                FragmentTransaction transaction =manager.beginTransaction();
                /*transaction.setCustomAnimations(R.animator.fragment_slide_left_enter,
                        R.animator.fragment_slide_left_exit,
                        R.animator.fragment_slide_right_enter,
                        R.animator.fragment_slide_right_exit);*/
                transaction.setCustomAnimations(R.animator.slide_up,
                        R.animator.slide_down,
                        R.animator.slide_up,
                        R.animator.slide_down);

                transaction.replace(R.id.fragment,newFragment,"B");
                transaction.commit();
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
            Fragment newFragment = new Main2Fragment();
            FragmentTransaction transaction =manager.beginTransaction();
            //transaction.setCustomAnimations(R.animator.fragment_slide_right_enter,R.animator.fragment_slide_right_exit,R.animator.fragment_slide_left_enter,R.animator.fragment_slide_left_exit);
            transaction.setCustomAnimations(R.animator.slide_up,
                    R.animator.slide_down,
                    R.animator.slide_up,
                    R.animator.slide_down);
            transaction.replace(R.id.fragment,newFragment,"A").commit();
        }

        return super.onOptionsItemSelected(item);
    }
}
