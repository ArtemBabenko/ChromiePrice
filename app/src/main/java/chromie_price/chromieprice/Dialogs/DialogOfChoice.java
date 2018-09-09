package chromie_price.chromieprice.Dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import chromie_price.chromieprice.Fragment.FormFragment;
import chromie_price.chromieprice.R;

public class DialogOfChoice extends DialogFragment implements View.OnClickListener {

    public static final String BUNDLE_KAY = "LIST_ITEM";

    private TextView headText;

    private ArrayList<String> itemList = new ArrayList();
    private CheckBox water;
    private CheckBox elPower;
    private CheckBox gas;
    private CheckBox coldWater;
    private CheckBox hotWater;
    private CheckBox houseHeatint;
    private CheckBox internet;
    private CheckBox serv;
    private CheckBox parkPlace;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_of_choice, container, false);
        initView(v);
        return v;
    }

    private void initView(View view) {
        headText = view.findViewById(R.id.choice_message);
        water = view.findViewById(R.id.check_water);
        elPower = view.findViewById(R.id.check_electric_power);
        gas = view.findViewById(R.id.check_gas);
        coldWater = view.findViewById(R.id.check_cold_water);
        hotWater = view.findViewById(R.id.check_hot_water);
        houseHeatint = view.findViewById(R.id.check_house_heating);
        internet = view.findViewById(R.id.check_internet);
        serv = view.findViewById(R.id.check_services);
        parkPlace = view.findViewById(R.id.check_parking_place);
        view.findViewById(R.id.button_ok).setOnClickListener(this);
        view.findViewById(R.id.button_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_ok) {
            if (water.isChecked()) {
                itemList.add("Water");
            }
            if (elPower.isChecked()) {
                itemList.add("Electric power");
            }
            if (gas.isChecked()) {
                itemList.add("Gas");
            }
            if (coldWater.isChecked()) {
                itemList.add("Cold water");
            }
            if (hotWater.isChecked()) {
                itemList.add("Hot water");
            }
            if (houseHeatint.isChecked()) {
                itemList.add("House heating");
            }
            if (internet.isChecked()) {
                itemList.add("Internet");
            }
            if (serv.isChecked()) {
                itemList.add("Service");
            }
            if (parkPlace.isChecked()) {
                itemList.add("Parking Place");
            }

            onCreateFormFragment();
            dismiss();
        } else {
            dismiss();
        }

    }

    private void onCreateFormFragment() {
        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FormFragment formFragment = new FormFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(BUNDLE_KAY, itemList);
        formFragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragment_container, formFragment);
        fragmentTransaction.commit();
    }

}
