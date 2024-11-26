package com.example.petscompose_class.data.repositories

import com.example.petscompose_class.data.dao.LoginDao
import com.example.petscompose_class.data.models.login.RoomLogin
import com.example.petscompose_class.domain.repositories.LoginLocalRepository
import javax.inject.Inject

class LoginLocalRepositoryImpl @Inject constructor(
    private val loginDao: LoginDao
): LoginLocalRepository {

    override suspend fun loginUser(username: String, password: String): RoomLogin? {
        return loginDao.login(username,password)
    }

    override suspend fun insertUser(localLogin: RoomLogin): Long {
        return loginDao.insert(localLogin)
    }

    override suspend fun updateUser(localLogin: RoomLogin): Int {
        return loginDao.update(localLogin)
    }

    override suspend fun deleteUser(localLogin: RoomLogin): Int {
        return loginDao.delete(localLogin)
    }
}