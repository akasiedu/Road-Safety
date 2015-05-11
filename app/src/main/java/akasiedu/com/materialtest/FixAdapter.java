package akasiedu.com.materialtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by kwame on 5/2/15.
 */
public class FixAdapter extends ArrayAdapter<String> {
    public FixAdapter(Context context, String[] values) {
        super(context, R.layout.list_row_layout, values );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater myinflate=LayoutInflater.from(getContext());

        View myView = myinflate.inflate(R.layout.list_row_layout, parent, false);

        String carFix =getItem(position);
        TextView myTextView = (TextView) myView.findViewById(R.id.myTextView);

        myTextView.setText(carFix);

//        ImageView myImageView = (ImageView) myView.findViewById(R.id.myImageView);
//        myImageView.setImageResource(R.drawable.fix);

        return myView;
    }
}
