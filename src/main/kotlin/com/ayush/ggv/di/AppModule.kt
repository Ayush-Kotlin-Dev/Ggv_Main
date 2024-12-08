package com.ayush.ggv.di

import com.ayush.ggv.dao.auth.UserDao
import com.ayush.ggv.dao.auth.UserDaoImpl
import com.ayush.ggv.repository.auth.AuthRepository
import com.ayush.ggv.repository.auth.AuthRepositoryImpl
import org.koin.dsl.module

val appModule = module {


    single <UserDao>{ UserDaoImpl() }
    single  <AuthRepository>{ AuthRepositoryImpl(get()) }


}