//package akasiedu.com.materialtest;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.GridView;
//
///**
// * Created by kwame on 5/2/15.
// */
//public class RoadSignActivity extends ActionBarActivity{
//    private Toolbar toolbar;
//    GridView gv;
//    Context context;
//
//    public static String [] signList={"Bicycle Cross","Chevron Symbol","Crossing",
//            "Deer Crossing","Emergency Vehicle","Flagger Symbol",
//            "Hill Truck","Left Curve","Left Lane Ends","Left Turn Ahead",
//            "No Crossing","No Left Turn","No Parking","No Right Turn",
//            "No Truck Allowed","No-U-Turn","Right Curve","Right Lane Ends",
//            "Right Turn Ahead","School Crossing","Stop Ahead", "Two Way Street","Worker Symbol" };
//    public static int [] signImages={R.drawable.bicycle_crossing, R.drawable.chevron_symbol, R.drawable.crossing,
//            R.drawable.deer_crossing, R.drawable.emergency_vehicle, R.drawable.flagger_symbol,
//            R.drawable.hill_track_sign, R.drawable.left_curve, R.drawable.left_lane_ends,
//            R.drawable.left_turn_ahead, R.drawable.no_crossing, R.drawable.no_left_turn,
//            R.drawable.no_parking,R.drawable.no_right_turn, R.drawable.no_truck,
//            R.drawable.no_u_turn, R.drawable.right_curve, R.drawable.right_lane_ends,
//            R.drawable.right_turn_ahead, R.drawable.school_crossing, R.drawable.stop_ahead,
//            R.drawable.two_way_street, R.drawable.worker_symbol };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.road_signs);
//
//        gv=(GridView) findViewById(R.id.gridView1);
//        gv.setAdapter(new GridAdapter(this, signList, signImages));
//
//        toolbar=(Toolbar) findViewById(R.id.app_bar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//}
