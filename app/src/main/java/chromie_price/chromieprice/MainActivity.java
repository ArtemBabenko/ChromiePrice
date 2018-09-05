package chromie_price.chromieprice;

import android.os.Bundle;
import android.os.FileObserver;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import chromie_price.chromieprice.Adapter.ParentRecyclerAdapter;
import chromie_price.chromieprice.Dialogs.DialogOfChoice;
import chromie_price.chromieprice.Item.ChildRecyclerItem;
import chromie_price.chromieprice.Item.ParentRecyclerItem;

public class MainActivity extends AppCompatActivity {

    private ParentRecyclerAdapter parentRecyclerAdapter;
    private RecyclerView parentRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogOfChoice dialog = new DialogOfChoice();
                dialog.show(getSupportFragmentManager(), "Choice");
            }
        });


        initRecyclerView();
        loudItem();
    }

    private void initRecyclerView() {
        parentRecyclerView = findViewById(R.id.parent_recycler);
        parentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        parentRecyclerAdapter = new ParentRecyclerAdapter(getApplicationContext());
        parentRecyclerView.setAdapter(parentRecyclerAdapter);
    }

    private void loudItem() {
        Collection<ParentRecyclerItem> parentList = getParentRecyclerItem();
        parentRecyclerAdapter.setItems(parentList);
    }

    private Collection<ParentRecyclerItem> getParentRecyclerItem() {
        ArrayList<ParentRecyclerItem> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ParentRecyclerItem(getChildRecyclerItem()));
        }
        return list;
    }

    private Collection<ChildRecyclerItem> getChildRecyclerItem() {
        ArrayList<ChildRecyclerItem> list = new ArrayList<>();
        for (int i = 1000000; i < 10000000; i+=1000000) {
            list.add(new ChildRecyclerItem(String.valueOf(i), i, i, i, i, i));
        }
        return list;
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
