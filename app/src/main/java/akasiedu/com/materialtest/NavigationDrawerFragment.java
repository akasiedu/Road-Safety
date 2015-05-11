package akasiedu.com.materialtest;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

//import android.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment implements CategoryAdapter.ClickListener{

    private RecyclerView recyclerView;


    private View containerView;
    private static final String PREF_FILE_NAME="testpref";
    public static final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private CategoryAdapter categoryAdapter;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer=Boolean.valueOf(readFromPreferences(getActivity(),KEY_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState!=null){
            mFromSavedInstanceState =  true;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = (inflater.inflate(R.layout.fragment_navigation_drawer, container, false));
        recyclerView= (RecyclerView) layout.findViewById(R.id.drawerList);

        categoryAdapter=new CategoryAdapter(getActivity(), getData());
        categoryAdapter.setClickListener(this);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecycleTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return layout;

    }

    public static List<Information> getData(){
        List<Information> data=new ArrayList<>();
        int[] icons={R.drawable.road_signs, R.drawable.fixes, R.drawable.driver_manual, R.drawable.communities};
        String[] titles={"Road Signs", "Emergency Fixes", "Driving Manual", "Meet New Drivers"};

//      Looping through my titles
        for (int i=0;i<titles.length && i<icons.length; i++){
            Information current = new Information();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar){
        containerView=getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close ){

            @Override
            public void onDrawerOpened(View drawerView){
               super.onDrawerOpened(drawerView);
                if (mUserLearnedDrawer){
                    mUserLearnedDrawer=true;
                    savedToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer+"");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (slideOffset<0.5){
                    toolbar.setAlpha(1-slideOffset);
                }
            }
        };
//        if (!mUserLearnedDrawer && !mFromSavedInstanceState){
//            mDrawerLayout.openDrawer(containerView);
//        }

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    @Override
    public void itemClicked(View view, int position) {
//        startActivity(new Intent(getActivity(), RoadSignActivity.class));

        switch (position){
            case 0:
                startActivity(new Intent(getActivity(), MainActivity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), CarFixActivity.class));
                break;
        }


    }


    static class RecycleTouchListener implements RecyclerView.OnItemTouchListener{
        private ClickListener clickListener;

        private GestureDetector gestureDetector;

        public RecycleTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener){
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                   View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child!=null && clickListener!=null){
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });

        }



        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child!=null && clickListener!=null && gestureDetector.onTouchEvent(e)){
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }
    }

    public interface ClickListener{
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }

    public static void savedToPreferences(Context context, String preferenceName, String preferenceValue){
        SharedPreferences sharedPreferences= context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();


    }

    public static String readFromPreferences(Context context, String preferenceName, String preferenceValue){
        SharedPreferences sharedPreferences= context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, preferenceValue);
    }


}
