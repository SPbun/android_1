package lsj239.a2014050239lsj;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListViewApater extends BaseAdapter {

    private  static final int TYPE_A=0;
    private  static final int TYPE_B=1;
    private Context context;

    private List<Object> data =new ArrayList<>();
    public ListViewApater(Context context,ArrayList<Object> data){
        this.context = context;
       
        this.data=data;
    }


    @Override
    public int getCount() {
        return data.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    public int getItemViewType(int position){
        int result = 0;
        if(data.get(position) instanceof DayItem){
            result = TYPE_A;
        }else if (data.get(position) instanceof AddItemPoint){
            result = TYPE_B;
        }
        return result;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;

        int type = getItemViewType(position);
        if(convertView == null){
            holder1 = new ViewHolder1();
            holder2 = new ViewHolder2();

            switch (type) {
                case TYPE_A:
                    convertView = View.inflate(context, R.layout.day_item, null);
                    holder1.week = (TextView) convertView.findViewById(R.id.leftUp);
                    holder1.day = (TextView) convertView.findViewById(R.id.leftBottom);
                    holder1.detail = (TextView) convertView.findViewById(R.id.rightOne);
                    convertView.setTag(R.id.tag_first,holder1);
                    break;
                case TYPE_B:
                    convertView = View.inflate(context, R.layout.add_item, null);
                    holder2.imgResourceID = (ImageView) convertView.findViewById(R.id.addDotBtn);
                    convertView.setTag(R.id.tag_second,holder2);
                    break;
            }
        }else{
            switch (type) {
                case TYPE_A:
                    holder1 = (ViewHolder1) convertView.getTag(R.id.tag_first);
                    break;
                case TYPE_B:
                    holder2 = (ViewHolder2) convertView.getTag(R.id.tag_second);
                    break;
            }
        }

        Object o = data.get(position);
        
        switch (type) {
            case TYPE_A:
                DayItem a = (DayItem) o;
                holder1.detail.setText(a.getDetail());
                holder1.week.setText(a.getWeek());
                holder1.day.setText(a.getDay());
                break;

            case TYPE_B:
                AddItemPoint b = (AddItemPoint) o;
                holder2.imgResourceID.setImageResource(b.getImgResourceID());
                break;
        }
        return convertView;
    }


    private class ViewHolder1 {
        TextView week;
        TextView day;
        TextView detail;
    }


    private class ViewHolder2 {
        ImageView imgResourceID;
    }
}
