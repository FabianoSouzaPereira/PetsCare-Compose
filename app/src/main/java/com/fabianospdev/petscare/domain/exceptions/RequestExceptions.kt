package com.fabianospdev.petscare.domain.exceptions

// Base exception for all request errors
open class RequestException(message: String? = null, cause: Throwable? = null) : Exception(message, cause)

// General request error exceptions
sealed class GeneralRequestException(message: String? = null, cause: Throwable? = null) : RequestException(message, cause)

open class NetworkException(message: String? = "Network error", cause: Throwable? = null) : GeneralRequestException(message, cause)
open class TimeoutException(message: String? = "Request timed out", cause: Throwable? = null) : NetworkException(message, cause)
open class ServerException(message: String? = "Server error", cause: Throwable? = null) : GeneralRequestException(message, cause)
open class UnauthorizedException(message: String? = "Unauthorized", cause: Throwable? = null) : GeneralRequestException(message, cause)
open class BadRequestException(message: String? = "Bad request", cause: Throwable? = null) : GeneralRequestException(message, cause)
open class ForbiddenException(message: String? = "Forbidden access", cause: Throwable? = null) : GeneralRequestException(message, cause)
open class ConflictException(message: String? = "Data conflict", cause: Throwable? = null) : GeneralRequestException(message, cause)

// User-related exceptions
sealed class UserException(message: String? = null, cause: Throwable? = null) : RequestException(message, cause)

open class UserNotFoundException(message: String? = "User not found", cause: Throwable? = null) : UserException(message, cause)
open class EmailAlreadyInUseException(message: String? = "Email already in use", cause: Throwable? = null) : UserException(message, cause)
open class PasswordTooWeakException(message: String? = "Password is too weak", cause: Throwable? = null) : UserException(message, cause)
open class InvalidTokenException(message: String? = "Invalid authentication token", cause: Throwable? = null) : UserException(message, cause)
open class ValidationException(message: String? = "Validation failed", cause: Throwable? = null) : UserException(message, cause)
open class AccountLockedException(message: String? = "Account locked", cause: Throwable? = null) : UserException(message, cause)
open class SessionExpiredException(message: String? = "Session expired", cause: Throwable? = null) : UserException(message, cause)

//Exceptions related to transactions or resources
sealed class TransactionException(message: String? = null, cause: Throwable? = null) : RequestException(message, cause)

open class InsufficientFundsException(message: String? = "Insufficient funds", cause: Throwable? = null) : TransactionException(message, cause)
open class ItemNotFoundException(message: String? = "Item not found", cause: Throwable? = null) : TransactionException(message, cause)
open class PermissionDeniedException(message: String? = "Permission denied", cause: Throwable? = null) : TransactionException(message, cause)
open class MaxAttemptsExceededException(message: String? = "Maximum number of attempts exceeded", cause: Throwable? = null) : TransactionException(message, cause)

