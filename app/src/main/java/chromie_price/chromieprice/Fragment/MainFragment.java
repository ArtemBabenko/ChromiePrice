package chromie_price.chromieprice.Fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import chromie_price.chromieprice.Adapter.ParentRecyclerAdapter;
import chromie_price.chromieprice.Dialogs.DialogOfChoice;
import chromie_price.chromieprice.Item.ChildRecyclerItem;
import chromie_price.chromieprice.Item.ParentRecyclerItem;
import chromie_price.chromieprice.R;
import chromie_price.chromieprice.app.App;
import chromie_price.chromieprice.storage.ChildDao;
import chromie_price.chromieprice.storage.ChildTable;
import chromie_price.chromieprice.storage.Database;
import chromie_price.chromieprice.storage.ParentDao;
import chromie_price.chromieprice.storage.ParentTable;

import static android.content.ContentValues.TAG;


public class MainFragment extends Fragment implements View.OnClickListener {

    private Database database;
    private ParentDao parentDao;
    private ChildDao childDao;

    private ParentRecyclerAdapter parentRecyclerAdapter;
    private RecyclerView parentRecyclerView;
    private List<ParentRecyclerItem> parentList = new ArrayList<>();
    private List<ChildRecyclerItem> childList = new ArrayList<>();

    private FloatingActionButton fab;
    private int fabStatus = 1;
    private int fabArrowPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        parentRecyclerView = v.findViewById(R.id.parent_recycler);
        fab = v.findViewById(R.id.fab);
        fab.setAlpha(0.8f);
        fab.setOnClickListener(this);

        initDatabase();
        addData();
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
                } else {
                    parentRecyclerView.scrollToPosition(fabArrowPosition);
                    fab.setImageResource(R.mipmap.ic_add);
                    fabStatus = 1;
                }
        }
    }


    private void initRecyclerView() {
        parentRecyclerAdapter = new ParentRecyclerAdapter(getContext(), loadData());
        parentRecyclerAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            //При сварачивании и розварачивании дочерних списков подщитывает видемое количство елементов для кнопка обратного возврата
            public void onParentExpanded(int parentPosition) {
                ParentRecyclerItem parentItem = parentList.get(parentPosition);
                fabArrowPosition += parentItem.getChildList().size();
            }

            @Override
            public void onParentCollapsed(int parentPosition) {
                ParentRecyclerItem parentItem = parentList.get(parentPosition);
                fabArrowPosition -= parentItem.getChildList().size();
            }
        });


        parentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        parentRecyclerView.setItemAnimator(new DefaultItemAnimator());
        parentRecyclerView.scrollToPosition(loadData().size() - 1);
        parentRecyclerView.setAdapter(parentRecyclerAdapter);

        changeFab(parentRecyclerView, fab);
        fabArrowPosition = parentList.size() - 1;
    }

    private void initDatabase() {
        database = App.getInstance().getDatabase();
        parentDao = database.parentDao();
        childDao = database.childDao();
    }

    //Выгрузка данных в Recycler
    private List<ParentRecyclerItem> loadData() {
        List<ParentTable> listP = parentDao.getAllParents();
        Log.v(TAG, "SizeParent: " + listP.size());
        for (ParentTable parentTable : listP) {
            List<ChildTable> listCh = childDao.findChildsForParent(parentTable.getId());
            Log.v(TAG, "SizeChild: " + listCh.size());
            for (ChildTable childTable : listCh) {
                childList.add(new ChildRecyclerItem(String.valueOf(childTable.getName()), 1, 1, 1, 1, 1));
            }
            parentList.add(new ParentRecyclerItem(parentTable.getName(), childList));
        }

        return parentList;
    }

    //    Подгрузка даных в базу
    private void addData() {
        for (int i = 0; i < 10; i++) {
            Long parentId = parentDao.insert(new ParentTable("ParentName" + i));
            Log.v(TAG, "ParentID: " + parentId);
            childDao.insert(new ChildTable(parentId, "ChildName"));
        }
    }


//    //Методы для имитации заполнения данными
//    private List<ParentRecyclerItem> getParentRecyclerItem() {
////        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
////        String date = df.format(Calendar.getInstance().getTime());
//
//        parentList = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            parentList.add(new ParentRecyclerItem(String.valueOf(i), getChildRecyclerItem()));
//        }
//
//        return parentList;
//    }
//
//    private List<ChildRecyclerItem> getChildRecyclerItem() {
//        List<ChildRecyclerItem> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(new ChildRecyclerItem(String.valueOf(i), i, i, i, i, i));
//        }
//        return list;
//    }


    private void changeFab(RecyclerView recyclerView, final FloatingActionButton fab) {
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
