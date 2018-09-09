package chromie_price.chromieprice.Fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;

import chromie_price.chromieprice.Adapter.ParentRecyclerAdapter;
import chromie_price.chromieprice.Dialogs.DialogOfChoice;
import chromie_price.chromieprice.Item.ChildRecyclerItem;
import chromie_price.chromieprice.Item.ParentRecyclerItem;
import chromie_price.chromieprice.R;


public class MainFragment extends Fragment implements View.OnClickListener {

    private ParentRecyclerAdapter parentRecyclerAdapter;
    private RecyclerView parentRecyclerView;
    FloatingActionButton fab;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        parentRecyclerView = v.findViewById(R.id.parent_recycler);
        fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        initRecyclerView();
        loudItem();
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                DialogOfChoice dialog = new DialogOfChoice();
                dialog.show(getFragmentManager(), "Choice");

        }
    }

    private void initRecyclerView() {
        parentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        parentRecyclerAdapter = new ParentRecyclerAdapter(getContext());
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
        for (int i = 1000000; i < 10000000; i += 1000000) {
            list.add(new ChildRecyclerItem(String.valueOf(i), i, i, i, i, i));
        }
        return list;
    }

    public void onStart() {
        super.onStart();
        fab.show();
    }

    public void onResume() {
        super.onResume();
        fab.show();
    }

    public void onPause() {
        super.onPause();
        fab.show();
    }

    @Override
    public void onStop() {
        super.onStop();
        fab.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fab.show();
    }

    public void onDestroy() {
        super.onDestroy();
        fab.show();
    }

    public void onDetach() {
        super.onDetach();
        fab.show();
    }
}
