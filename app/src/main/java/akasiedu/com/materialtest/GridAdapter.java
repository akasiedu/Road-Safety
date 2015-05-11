package akasiedu.com.materialtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kwame on 5/2/15.
 */
public class GridAdapter extends BaseAdapter {
    String [] results;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;

    public GridAdapter(MainActivity mainActivity , String[] signList, int[] signImages){
        results=signList;
        context=mainActivity;
        imageId=signImages;

        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return results.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class Holder{TextView tv; ImageView img;}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(results[position]);
        holder.img.setImageResource(imageId[position]);

        return rowView;
    }
}
