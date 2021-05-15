package com.example.basic_bai2_nguyenhuynhcongly_18077551;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class bai2_Congly extends AppCompatActivity implements com.example.basic_bai2_nguyenhuynhcongly_18077551.Adapter.CustomButtonListener{
    ListView listView;
    List<Address> addresses;
    com.example.basic_bai2_nguyenhuynhcongly_18077551.Adapter Adapter;
    AppDatabase2 database;
    AddressDao addressDao;
    TextView txtTim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTim = findViewById(R.id.txtTim);
        listView = findViewById(R.id.listview);

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase2.class, "addressdbtest")
                .allowMainThreadQueries()
                .build();
        addressDao = database.addressDao();
        addresses = addressDao.getAll();
        Adapter = new Adapter(addresses,this,this);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Address address= addresses.get(i);
                txtTim.setText(address.getName());
            }
        });


        Button btnSave = findViewById(R.id.btnLuu);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = txtTim.getText().toString();
                if(text.equalsIgnoreCase("")==false){
                    Address address = new Address( text);
                    addressDao.insertAll(address);
                    addresses = addressDao.getAll();
                    Adapter.changeList(addresses);
                }
            }
        });
    }

    @Override
    public void deleteAddress(int position) {
        Address addressPosition = addresses.get(position);
        addressDao.delete(addressPosition);
        addresses = addressDao.getAll();
        Adapter.changeList(addresses);
    }

    @Override
    public void editAddress(int position) {
        Address addressUpdate = addresses.get(position);
        addressUpdate.setName(txtTim.getText().toString());
        addressDao.update(addressUpdate);
        Adapter.changeList(addresses);
    }

}