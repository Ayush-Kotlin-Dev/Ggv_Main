package com.ayush.ggv.dao.auth

interface UserDao {
    suspend fun createUser(username: String, email: String, passwordHash: String): UserRow?
    suspend fun findUserById(id: Long): UserRow?
    suspend fun findUserByUsername(username: String): UserRow?
    suspend fun findUserByEmail(email: String): UserRow?
    suspend fun deleteUser(id: Int): Int
    suspend fun updateUser(id: Int, username: String, email: String, passwordHash: String): Int
}


