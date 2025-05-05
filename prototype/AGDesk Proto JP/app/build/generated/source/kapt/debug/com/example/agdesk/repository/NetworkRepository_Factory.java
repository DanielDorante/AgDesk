package com.example.agdesk.repository;

import com.example.agdesk.DataLayer.DAOs.DbSyncDAO;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
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
public final class NetworkRepository_Factory implements Factory<NetworkRepository> {
  private final Provider<AssetRepository> assetRepositoryProvider;

  private final Provider<TaskRepository> taskRepositoryProvider;

  private final Provider<HttpClient> httpClientProvider;

  private final Provider<DbSyncDAO> dbSyncDAOProvider;

  public NetworkRepository_Factory(Provider<AssetRepository> assetRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider, Provider<HttpClient> httpClientProvider,
      Provider<DbSyncDAO> dbSyncDAOProvider) {
    this.assetRepositoryProvider = assetRepositoryProvider;
    this.taskRepositoryProvider = taskRepositoryProvider;
    this.httpClientProvider = httpClientProvider;
    this.dbSyncDAOProvider = dbSyncDAOProvider;
  }

  @Override
  public NetworkRepository get() {
    return newInstance(assetRepositoryProvider.get(), taskRepositoryProvider.get(), httpClientProvider.get(), dbSyncDAOProvider.get());
  }

  public static NetworkRepository_Factory create(Provider<AssetRepository> assetRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider, Provider<HttpClient> httpClientProvider,
      Provider<DbSyncDAO> dbSyncDAOProvider) {
    return new NetworkRepository_Factory(assetRepositoryProvider, taskRepositoryProvider, httpClientProvider, dbSyncDAOProvider);
  }

  public static NetworkRepository newInstance(AssetRepository assetRepository,
      TaskRepository taskRepository, HttpClient httpClient, DbSyncDAO dbSyncDAO) {
    return new NetworkRepository(assetRepository, taskRepository, httpClient, dbSyncDAO);
  }
}
