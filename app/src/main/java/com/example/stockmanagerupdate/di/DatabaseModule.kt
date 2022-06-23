package com.example.stockmanagerupdate.di

import android.content.Context
import androidx.room.Room
import com.example.stockmanagerupdate.database.OrderDao
import com.example.stockmanagerupdate.database.OrderDatabase
import com.example.stockmanagerupdate.database.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideOrderDao(orderDatabase: OrderDatabase): OrderDao{
        return orderDatabase.orderDao
    }

    @Provides
    @Singleton
    fun provideOrderDatabase(@ApplicationContext appContext : Context) : OrderDatabase {
        return Room.databaseBuilder(
            appContext,
            OrderDatabase::class.java,
            "order_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideRepository(orderdao : OrderDao) = Repository(orderdao)
}