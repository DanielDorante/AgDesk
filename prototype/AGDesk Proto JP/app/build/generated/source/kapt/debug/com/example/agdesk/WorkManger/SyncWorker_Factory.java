package com.example.agdesk.WorkManger;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.example.agdesk.repository.NetworkRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class SyncWorker_Factory {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public SyncWorker_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  public SyncWorker get(Context appContext, WorkerParameters workerParams) {
    return newInstance(appContext, workerParams, networkRepositoryProvider.get());
  }

  public static SyncWorker_Factory create(Provider<NetworkRepository> networkRepositoryProvider) {
    return new SyncWorker_Factory(networkRepositoryProvider);
  }

  public static SyncWorker newInstance(Context appContext, WorkerParameters workerParams,
      NetworkRepository networkRepository) {
    return new SyncWorker(appContext, workerParams, networkRepository);
  }
}
