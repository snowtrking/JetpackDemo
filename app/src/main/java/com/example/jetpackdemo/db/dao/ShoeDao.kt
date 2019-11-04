package com.example.jetpackdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.jetpackdemo.db.data.Shoe

@Dao
interface ShoeDao {

//    // 查询多个 通过品牌查询多款鞋
//    @Query("SELECT * FROM shoe WHERE shoe_brand=:brand")
//    fun findShoeByBrand(brand: String): List<Shoe>

    @Query("SELECT * FROM shoe WHERE id between:startIndex AND :endIndex ORDER BY id ASC")
    fun findShoesByIndexRange(startIndex: Long, endIndex: Long): List<Shoe>

    @Query("SELECT *FROM shoe")
//    fun getAllShoesLD(): DataSource.Factory<Int, Shoe>
    fun getAllShoesLD(): LiveData<List<Shoe>>

    // 配合LiveData 通过Id查询单款鞋子
    @Query("SELECT * FROM shoe WHERE id=:id")
    fun findShoeByIdLD(id: Long): LiveData<Shoe>

    @Query("SELECT * FROM shoe WHERE shoe_brand IN(:brand)")
    fun findShoesByBrandLD(brand: Array<String>): DataSource.Factory<Int, Shoe>
//    fun findShoesByBrandLD(brand: Array<String>): LiveData<List<Shoe>>

    // 根据收藏结合 查询用户喜欢的鞋的集合
    @Query(
        "SELECT shoe.id,shoe.shoe_name,shoe.shoe_description,shoe.shoe_price,shoe.shoe_brand,shoe.shoe_imgUrl " +
                "FROM shoe " +
                "INNER JOIN fav_shoe ON fav_shoe.shoe_id = shoe.id " +
                "WHERE fav_shoe.user_id = :userId"
    )
    fun findShoesByUserId(userId: Long): LiveData<List<Shoe>>

    // 增加一双鞋子
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoe(shoe: Shoe)

    // 增加多双鞋子
    // 除了List之外，也可以使用数组
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoes(shoes: List<Shoe>)

    @Delete
    fun deleteShoe(shoe: Shoe)

    // 删除多个鞋子
    // 参数也可以使用数组
    @Delete
    fun deleteShoes(shoes: List<Shoe>)

    // 更新一双鞋
    @Update
    fun updateShoe(shoe: Shoe)

    // 更新多双鞋
    // 参数也可以是集合
    @Update
    fun updateShoes(shoes: Array<Shoe>)
}