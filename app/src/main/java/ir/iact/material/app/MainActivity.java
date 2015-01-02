package ir.iact.material.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        List<String> strings = new ArrayList<>();
        strings.add("Title 1");
        strings.add("Title 2");
        strings.add("Title 3");
        strings.add("Title 4");

        MyListAdapter myListAdapter = new MyListAdapter(strings);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myListAdapter);
    }

    class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{

        List<String> items;

        MyListAdapter(List<String> items) {
            this.items = items;
        }

        @Override
        public MyListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Context context = viewGroup.getContext();
            View parent = LayoutInflater.from(context).inflate(R.layout.feed_list_item, viewGroup, false);
            return new ViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(MyListAdapter.ViewHolder viewHolder, int i) {
            String s = items.get(i);
            viewHolder.title.setText(s);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView title;

            public ViewHolder(View itemView) {
                super(itemView);
                title = (TextView) itemView.findViewById(R.id.listItem_title);
            }
        }
    }
}
