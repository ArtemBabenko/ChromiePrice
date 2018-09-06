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

import chromie_price.chromieprice.Fragment.FormFragment;
import chromie_price.chromieprice.R;

public class DialogOfChoice extends DialogFragment implements View.OnClickListener {

    private TextView headText;


    private CheckBox water;
    private CheckBox elPower;
    private CheckBox gas;
    private CheckBox coldWater;
    private CheckBox hotWater;
    private CheckBox houseHeatint;
    private CheckBox internet;
    private CheckBox serv;
    private CheckBox parkPlace;

    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }


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
            }
            if (elPower.isChecked()) {
            }
            if (gas.isChecked()) {
            }
            if (coldWater.isChecked()) {
            }
            if (hotWater.isChecked()) {
            }
            if (houseHeatint.isChecked()) {
            }
            if (internet.isChecked()) {
            }
            if (serv.isChecked()) {
            }
            if (parkPlace.isChecked()) {
            }

            onCreateFormFragment();
            dismiss();
        } else {
            dismiss();
        }

    }

    private void onCreateFormFragment(){
        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FormFragment formFragment = new FormFragment();
        fragmentTransaction.replace(R.id.fragment_conteiner, formFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
