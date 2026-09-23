package com.example.myapplication.ui

import com.example.myapplication.domain.model.User

// GIVEN (read it, do not change it)
sealed interface AuthUiState {
    data object Idle : AuthUiState
    data object Loading : AuthUiState
    data class Error(val message: String) : AuthUiState
    data class AccountCreated(val name: String) : AuthUiState
    data class LoggedIn(val user: User) : AuthUiState
}