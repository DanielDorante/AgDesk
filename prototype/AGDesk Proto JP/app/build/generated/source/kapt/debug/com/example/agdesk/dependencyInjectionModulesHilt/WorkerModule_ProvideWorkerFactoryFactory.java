package com.example.agdesk.dependencyInjectionModulesHilt;

import com.example.agdesk.DomainLayer.repository.NetworkRepository;
import com.example.agdesk.WorkManger.CustomWorkerFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class WorkerModule_ProvideWorkerFactoryFactory implements Factory<CustomWorkerFactory> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public WorkerModule_ProvideWorkerFactoryFactory(
      Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public CustomWorkerFactory get() {
    return provideWorkerFactory(networkRepositoryProvider.get());
  }

  public static WorkerModule_ProvideWorkerFactoryFactory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new WorkerModule_ProvideWorkerFactoryFactory(networkRepositoryProvider);
  }

  public static CustomWorkerFactory provideWorkerFactory(NetworkRepository networkRepository) {
    return Preconditions.checkNotNullFromProvides(WorkerModule.INSTANCE.provideWorkerFactory(networkRepository));
  }
}
