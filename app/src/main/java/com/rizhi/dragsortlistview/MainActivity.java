package com.rizhi.dragsortlistview;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rizhi.dragsortlistview.DragAdapter;
import com.rizhi.dragsortlistview.DragSortListView;
import com.rizhi.dragsortlistview.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private DragSortListView listView;

    private List<String> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for(int i=0;i<20;i++)
        {
            String asdasd=i+"xxxxxxx";
            data.add(asdasd);
        }

        listView= (DragSortListView) findViewById(R.id.lv);

        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        listView.addHeaderView(imageView);


        listView.setAdapter(new MyAdapter(this, data));

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


    private class MyAdapter extends DragAdapter<String> {

        public MyAdapter(Context context, List<String> list) {
            super(context, list);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view;
            Holder holder;

            if(convertView==null)
            {
                view=View.inflate(MainActivity.this,R.layout.lv_item,null);
                holder=new Holder();
                holder.imageView= (ImageView) view.findViewById(R.id.iv_logo);
                holder.tv_content= (TextView) view.findViewById(R.id.tv_content);
                view.setTag(holder);
            }else{
                view=convertView;
                holder= (Holder) view.getTag();
            }

            holder.tv_content.setText(data.get(position)+"xxxx");

            return view;
        }
    }


    class Holder {
        TextView tv_content;
        ImageView imageView;
    }



}
