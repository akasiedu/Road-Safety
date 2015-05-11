package akasiedu.com.materialtest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by kwame on 5/2/15.
 */
public class CarFixActivity  extends ActionBarActivity{
    private Toolbar toolbar;


    private ListView fixListView;
    private CardView myCardView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fix_activity);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] carFixes = {"PROBLEM: UNEVEN TYRE WEAR \n RECOGNISE IT: It may not be obvious when driving that your car’s tyres are unevenly worn, but worn tyres can be dangerous due to their reduced grip on the road. A quick check will tell you if your tyres are worn unevenly. The easiest way is to jack up your car and inspect each tyre individually, noting whether there are any bald spots on the inside or outside of the tyre, or whether there are any dips and dents in the tyre tread. \n FIX IT: Rotating your tyres and having your wheels aligned regularly.\n" +
                "In terms of how often you should get your tyres rotated, it’s different for every vehicle and type of tyre, but having them rotated at every oil change is a good rule of thumb. Check with the tyre manufacturer for a more specific time frame. Remember that the more often you rotate your tyres, the more evenly they’ll wear, and when you have the tyres rotated, you should also get them checked for balance and alignment.",
                "PROBLEM: AIR CONDITIONER NOT WORKING \n RECOGNISE IT: Your air con will switch on, but you notice it’s just blowing room-temperature air around rather than cold air. \n FIX IT: The most likely cause of this is that there is no refrigerant left in your system. This could be caused by a leak in your system somewhere, which will have to be fixed before refilling the refrigerant. If you’re car-savvy and you own a set of air conditioning gauges, refilling the refrigerant is usually easy to do yourself. However, if you’re not so confident, enlist the help of a knowledgeable friend or take a quick trip to the mechanic. \n", "PROBLEM: Engine overheating \n RECOGNISE PROBLEM: You may notice steam or smoke coming from your bonnet, or the needle on your engine temperature gauge may be through the roof. \n SOLUTION: Overheating can be caused by a few different factors. The simplest cause may be that your car needs more coolant. Yet depleted coolant can be caused by bigger problem, like leaks or faulty hoses, so always check for the underlying cause before simply filling it up with more. Another common reason for overheating may be that the radiator fan which keeps your engine cool is faulty, so check your fan motor connection and fan thermostat.\n ", "PROBLEM: Noisy brakes \n RECOGNISE IT: You’ll know it when you hear it! \n SOLUTION: There could be a number of reasons for noisy brakes. It could be that your brake pads are loose, worn out, or you may have brake dust inside the drum. If you can’t see anything wrong with your brake pads, and you suspect it may be brake dust, it may be best to leave this to a professional – brake dust can be extremely dangerous if accidentally inhaled."};

        ListAdapter myListAdapter = new FixAdapter(this, carFixes);




        fixListView = (ListView) findViewById(R.id.fixListView);
        fixListView.setAdapter(myListAdapter);

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
