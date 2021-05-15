package com.example.basic_bai2_nguyenhuynhcongly_18077551;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AddressDao {
    @Query("SELECT * FROM address")
    List<com.example.basic_bai2_nguyenhuynhcongly_18077551.Address> getAll();

    @Query("SELECT * FROM address WHERE id IN (:addressIds)")
    List<User> loadAllByIds(int[] addressIds);

    @Query("SELECT * FROM address WHERE name LIKE :name" )
    User findByName(String name);

    @Insert
    void insertAll(com.example.basic_bai2_nguyenhuynhcongly_18077551.Address... addresses);

    @Delete
    void delete(com.example.basic_bai2_nguyenhuynhcongly_18077551.Address address);

    @Update
    void update(com.example.basic_bai2_nguyenhuynhcongly_18077551.Address address);
}
