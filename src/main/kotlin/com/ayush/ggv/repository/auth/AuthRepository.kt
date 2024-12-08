package com.ayush.ggv.repository.auth

import com.ayush.ggv.model.auth.AuthResponse
import com.ayush.ggv.model.auth.SignInParams
import com.ayush.ggv.model.auth.SignUpParams
import com.ayush.ggv.utils.Response

interface AuthRepository {
    suspend fun signUp(params: SignUpParams): Response<AuthResponse>
    suspend fun signIn(params: SignInParams): Response<AuthResponse>
}