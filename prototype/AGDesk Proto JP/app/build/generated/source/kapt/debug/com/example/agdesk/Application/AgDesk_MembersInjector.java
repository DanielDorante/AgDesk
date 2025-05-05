package com.example.agdesk.Application;

import com.example.agdesk.WorkManger.CustomWorkerFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AgDesk_MembersInjector implements MembersInjector<AgDesk> {
  private final Provider<CustomWorkerFactory> customWorkerFactoryProvider;

  public AgDesk_MembersInjector(Provider<CustomWorkerFactory> customWorkerFactoryProvider) {
    this.customWorkerFactoryProvider = customWorkerFactoryProvider;
  }

  public static MembersInjector<AgDesk> create(
      Provider<CustomWorkerFactory> customWorkerFactoryProvider) {
    return new AgDesk_MembersInjector(customWorkerFactoryProvider);
  }

  @Override
  public void injectMembers(AgDesk instance) {
    injectCustomWorkerFactory(instance, customWorkerFactoryProvider.get());
  }

  @InjectedFieldSignature("com.example.agdesk.Application.AgDesk.customWorkerFactory")
  public static void injectCustomWorkerFactory(AgDesk instance,
      CustomWorkerFactory customWorkerFactory) {
    instance.customWorkerFactory = customWorkerFactory;
  }
}
