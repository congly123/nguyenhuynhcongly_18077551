package com.example.basic_bai2_nguyenhuynhcongly_18077551;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<com.example.basic_bai2_nguyenhuynhcongly_18077551.User> getAll();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    List<com.example.basic_bai2_nguyenhuynhcongly_18077551.User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE name LIKE :name" )
    com.example.basic_bai2_nguyenhuynhcongly_18077551.User findByName(String name);

    @Insert
    void insertAll(com.example.basic_bai2_nguyenhuynhcongly_18077551.User... users);

    @Delete
    void delete(com.example.basic_bai2_nguyenhuynhcongly_18077551.User user);

}
