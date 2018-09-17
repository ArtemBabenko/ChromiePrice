package chromie_price.chromieprice.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import chromie_price.chromieprice.Adapter.ParentRecyclerAdapter;
import chromie_price.chromieprice.Dialogs.DialogOfChoice;
import chromie_price.chromieprice.Item.ChildRecyclerItem;
import chromie_price.chromieprice.Item.ParentRecyclerItem;
import chromie_price.chromieprice.R;


public class MainFragment extends Fragment implements View.OnClickListener {

    private ParentRecyclerAdapter parentRecyclerAdapter;
    private RecyclerView parentRecyclerView;

    private FloatingActionButton fab;
    private int fabStatus = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        parentRecyclerView = v.findViewById(R.id.parent_recycler);
        fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        initRecyclerView();
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                if (fabStatus == 1) {
                    DialogOfChoice dialog = new DialogOfChoice();
                    dialog.show(getFragmentManager(), "Choice");
                }else{
                    parentRecyclerView.scrollToPosition(getParentRecyclerItem().size() - 1);
                    fab.setImageResource(R.mipmap.ic_add);
                    fabStatus = 1;
                }
        }
        }

        private void initRecyclerView () {
            parentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            parentRecyclerView.setItemAnimator(new DefaultItemAnimator());
            parentRecyclerView.scrollToPosition(getParentRecyclerItem().size() - 1);
            parentRecyclerAdapter = new ParentRecyclerAdapter(getContext(), getParentRecyclerItem());
            parentRecyclerView.setAdapter(parentRecyclerAdapter);
            changeFab(parentRecyclerView, fab);

        }


        private List<ParentRecyclerItem> getParentRecyclerItem () {
            List<ParentRecyclerItem> list = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                list.add(new ParentRecyclerItem(getChildRecyclerItem()));
            }
            return list;
        }

        private List<ChildRecyclerItem> getChildRecyclerItem () {
            List<ChildRecyclerItem> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new ChildRecyclerItem(String.valueOf(i), i, i, i, i, i));
            }
            return list;
        }

        private void changeFab (RecyclerView recyclerView,final FloatingActionButton fab){
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    //Отображение списка наоборот поетому так
                    if (dy > 0) {
                        fab.setImageResource(R.mipmap.ic_add);
                        fabStatus = 1;
                    } else if (dy < 0) {
                        fab.setImageResource(R.mipmap.ic_arrow);
                        fabStatus = 2;
                    }
                }
            });

        }
    }
