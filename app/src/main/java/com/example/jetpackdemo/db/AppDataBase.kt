package com.example.jetpackdemo.db

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.jetpackdemo.db.dao.ShoeDao
import com.example.jetpackdemo.db.data.Shoe
import com.example.jetpackdemo.worker.shoeWorker.ShoeWorker

@Database(entities = [Shoe::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    // 得到ShoeDao
    abstract fun shoeDao(): ShoeDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDataBase(context)
                    .also {
                        instance = it
                    }
            }
        }

        private fun buildDataBase(context: Context): AppDataBase {
            return Room
                .databaseBuilder(context, AppDataBase::class.java, "jetPackDemo-database")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        // 读取鞋的集合
                        val request = OneTimeWorkRequestBuilder<ShoeWorker>().build()
                        WorkManager.getInstance().enqueue(request)
                    }
                }).build()
        }
    }
}