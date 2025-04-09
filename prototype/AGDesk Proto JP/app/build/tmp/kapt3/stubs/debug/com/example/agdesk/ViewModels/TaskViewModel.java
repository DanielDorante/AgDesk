package com.example.agdesk.ViewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0010\"\u00020\b\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/example/agdesk/ViewModels/TaskViewModel;", "Landroidx/lifecycle/ViewModel;", "taskRepository", "Lcom/example/agdesk/repository/TaskRepository;", "(Lcom/example/agdesk/repository/TaskRepository;)V", "_tasks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/agdesk/models/TaskModel;", "tasks", "Lkotlinx/coroutines/flow/StateFlow;", "getTasks", "()Lkotlinx/coroutines/flow/StateFlow;", "insertTasks", "Lkotlinx/coroutines/Job;", "taskModel", "", "([Lcom/example/agdesk/models/TaskModel;)Lkotlinx/coroutines/Job;", "loadTasks", "updateTask", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TaskViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.agdesk.repository.TaskRepository taskRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.agdesk.models.TaskModel>> _tasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.agdesk.models.TaskModel>> tasks = null;
    
    @javax.inject.Inject()
    public TaskViewModel(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.repository.TaskRepository taskRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.agdesk.models.TaskModel>> getTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertTasks(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.TaskModel... taskModel) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateTask(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.TaskModel taskModel) {
        return null;
    }
}