package com.noureldin.githubrepositoryodcamit.presentation.mapper

import android.util.Log
import com.noureldin.githubrepositoryodcamit.domain.model.CustomRemoteExceptionDomainModel
import com.noureldin.githubrepositoryodcamit.presentation.model.CustomRemoteExceptionUiModel


fun CustomRemoteExceptionDomainModel.toCustomExceptionRemoteUiModel(): CustomRemoteExceptionUiModel {
    Log.d("Exception", this.toString())
    return when (this) {
        is CustomRemoteExceptionDomainModel.NoInternetConnectionRemoteException -> CustomRemoteExceptionUiModel.NoInternetConnection
        is CustomRemoteExceptionDomainModel.TimeOutExceptionRemoteException -> CustomRemoteExceptionUiModel.Timeout
        is CustomRemoteExceptionDomainModel.ServiceUnavailableRemoteException -> CustomRemoteExceptionUiModel.ServiceUnreachable
        is CustomRemoteExceptionDomainModel.AccessDeniedRemoteException -> CustomRemoteExceptionUiModel.ServiceUnreachable
        is CustomRemoteExceptionDomainModel.ServiceNotFoundRemoteException -> CustomRemoteExceptionUiModel.ServiceUnreachable
        is CustomRemoteExceptionDomainModel.UnknownRemoteException -> CustomRemoteExceptionUiModel.Unknown
    }
}