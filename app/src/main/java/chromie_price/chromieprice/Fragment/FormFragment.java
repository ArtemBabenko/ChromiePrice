package chromie_price.chromieprice.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import chromie_price.chromieprice.Adapter.FormRecyclerAdapter;
import chromie_price.chromieprice.R;

public class FormFragment extends Fragment implements View.OnClickListener {

    public static final String BUNDLE_KAY = "LIST_ITEM";

    private ArrayList<String> itemList = new ArrayList<>();
    private FormRecyclerAdapter formRecyclerAdapter;
    private RecyclerView formRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        view.findViewById(R.id.form_btn_ok).setOnClickListener(this);
        view.findViewById(R.id.form_btn_cancel).setOnClickListener(this);
        formRecyclerView = view.findViewById(R.id.form_recycler);

        loadDate();
        initRecyclerView();

        return view;
    }

    private void initRecyclerView() {
        formRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        formRecyclerAdapter = new FormRecyclerAdapter();
        formRecyclerAdapter.setItems(itemList);
        formRecyclerView.setAdapter(formRecyclerAdapter);
    }

    private void loadDate() {
        Bundle bundle = this.getArguments();
        itemList = bundle.getStringArrayList(BUNDLE_KAY);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.form_btn_cancel:
                getActivity().onBackPressed();
        }
    }
}
