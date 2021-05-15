package com.example.basic_bai2_nguyenhuynhcongly_18077551;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Address.class}, version = 1)
public abstract class AppDatabase2 extends RoomDatabase {
    public abstract AddressDao addressDao();
}
