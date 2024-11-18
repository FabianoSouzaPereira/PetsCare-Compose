package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.dao.LoginDao
import com.fabianospdev.petscare.data.models.login.RoomLogin
import com.fabianospdev.petscare.domain.repositories.LoginLocalRepository
import javax.inject.Inject

class LoginLocalRepositoryImpl @Inject constructor(
    private val loginDao: LoginDao
): LoginLocalRepository {

    override suspend fun loginUser(username: String, password: String): Result<RoomLogin?>{
        return loginDao.login(username,password)
    }

    override suspend fun insertUser(localLogin: RoomLogin): Result<RoomLogin> {
        return loginDao.insert(localLogin)
    }

    override suspend fun updateUser(localLogin: RoomLogin): Result<RoomLogin> {
        return loginDao.update(localLogin)
    }

    override suspend fun deleteUser(localLogin: RoomLogin): Result<RoomLogin> {
        return loginDao.delete(localLogin)
    }
}