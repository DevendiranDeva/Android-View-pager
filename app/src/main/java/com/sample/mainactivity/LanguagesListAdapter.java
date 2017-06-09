package com.sample.mainactivity;



import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class LanguagesListAdapter extends BaseAdapter{
    String [] result;
    String [] Hours;
    String [] Discrip;
    Context context;
    String [] imageId;
    private static LayoutInflater inflater=null;

    public LanguagesListAdapter(FragmentActivity mainActivity, String[] strings, String[] languages, String[] hours, String[] discription) {
// TODO Auto-generated constructor stub
        result=strings;
        context=mainActivity;
        imageId=languages;
        Hours=hours;
        Discrip=discription;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
// TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
// TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv_language,hours,discrip;
        ImageView im_language;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
        Holder holder=new Holder();
        View view;
        view = inflater.inflate(R.layout.layout_language_list_item, null);

        holder.tv_language=(TextView) view.findViewById(R.id.tv_language);
        holder.hours=(TextView) view.findViewById(R.id.hours);
        holder.discrip=(TextView) view.findViewById(R.id.discrip);



        holder.im_language=(ImageView) view.findViewById(R.id.im_language);

        holder.tv_language.setText(result[position]);
        holder.hours.setText(Hours[position]);
        holder.discrip.setText(Discrip[position]);
        Picasso.with(context).load(imageId[position]).into(holder.im_language);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
              //  Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
