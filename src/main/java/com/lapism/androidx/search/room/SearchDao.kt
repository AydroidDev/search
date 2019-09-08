package com.lapism.androidx.search.room

import androidx.room.*


@Dao
interface SearchDao {

    // *********************************************************************************************
    @Transaction  // get:
    @Query("SELECT * FROM search")
    fun getAll(): List<Search> // LiveData<List<Product>>

    @Transaction
    // SELECT * FROM search WHERE title LIKE  :firstName AND OR subtitle LIKE :lastName
    @Query("SELECT * FROM search WHERE title= :query OR subtitle= :query")
    fun get(query: String): Search

    // *********************************************************************************************
    @Transaction
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(search: Search)

    @Transaction
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAll(vararg search: Search)

    // *********************************************************************************************
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(search: Search)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg search: Search)

    // *********************************************************************************************
    @Transaction
    @Delete
    fun delete(search: Search)

    @Transaction
    @Query("DELETE FROM search")
    fun deleteAll()

    @Transaction
    @Query("DELETE FROM search WHERE title= :title")
    fun delete(title: String)

    // *********************************************************************************************
    @Transaction
    @Query("SELECT COUNT(*) from search")
    fun count(): Int

}
