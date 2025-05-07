package com.example.agdesk.DomainLayer.repository;

import com.example.agdesk.DataLayer.DAOs.TaskDAO;
import com.example.agdesk.DataLayer.DAOs.UserDAO;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class TaskRepository_Factory implements Factory<TaskRepository> {
  private final Provider<TaskDAO> taskDAOProvider;

  private final Provider<UserDAO> userDAOProvider;

  public TaskRepository_Factory(Provider<TaskDAO> taskDAOProvider,
      Provider<UserDAO> userDAOProvider) {
    this.taskDAOProvider = taskDAOProvider;
    this.userDAOProvider = userDAOProvider;
  }

  @Override
  public TaskRepository get() {
    return newInstance(taskDAOProvider.get(), userDAOProvider.get());
  }

  public static TaskRepository_Factory create(Provider<TaskDAO> taskDAOProvider,
      Provider<UserDAO> userDAOProvider) {
    return new TaskRepository_Factory(taskDAOProvider, userDAOProvider);
  }

  public static TaskRepository newInstance(TaskDAO taskDAO, UserDAO userDAO) {
    return new TaskRepository(taskDAO, userDAO);
  }
}
