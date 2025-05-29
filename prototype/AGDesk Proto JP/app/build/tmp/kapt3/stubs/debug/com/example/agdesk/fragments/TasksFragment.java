package com.example.agdesk.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\"H\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00020\"002\u0006\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020-H\u0002J$\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020 H\u0016J\b\u0010=\u001a\u00020(H\u0016J\u0010\u0010>\u001a\u00020(2\u0006\u0010<\u001a\u00020 H\u0016J\u001a\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010A\u001a\u00020(H\u0002J\b\u0010B\u001a\u00020(H\u0002J\b\u0010C\u001a\u00020(H\u0002J\u0016\u0010D\u001a\u00020(2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020 00H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006F"}, d2 = {"Lcom/example/agdesk/fragments/TasksFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/agdesk/adapters/TasksAdapter$TaskItemListener;", "()V", "_binding", "Lcom/example/agdesk/databinding/FragmentTasksBinding;", "adapter", "Lcom/example/agdesk/adapters/DateAdapter;", "assetViewModel", "Lcom/example/agdesk/ViewModels/AssetViewModel;", "getAssetViewModel", "()Lcom/example/agdesk/ViewModels/AssetViewModel;", "assetViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lcom/example/agdesk/databinding/FragmentTasksBinding;", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "taskAdapter", "Lcom/example/agdesk/adapters/TasksAdapter;", "taskViewModel", "Lcom/example/agdesk/ViewModels/TaskViewModel;", "getTaskViewModel", "()Lcom/example/agdesk/ViewModels/TaskViewModel;", "taskViewModel$delegate", "tasksList", "", "Lcom/example/agdesk/models/UIModels/TaskModel;", "timeInMillis", "", "getTimeInMillis", "()J", "setTimeInMillis", "(J)V", "filterTasksByDate", "", "selectedDateInMillis", "getCurrentDate", "time", "getCurrentMonth", "", "getCurrentYear", "getDaysOfMonth", "", "year", "month", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteClick", "task", "onDestroyView", "onEditClick", "onViewCreated", "view", "setDatePicker", "setSortSpinner", "setupRecyclerView", "updateTasksList", "tasks", "app_debug"})
public final class TasksFragment extends androidx.fragment.app.Fragment implements com.example.agdesk.adapters.TasksAdapter.TaskItemListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy assetViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy taskViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.databinding.FragmentTasksBinding _binding;
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.adapters.DateAdapter adapter;
    private com.example.agdesk.adapters.TasksAdapter taskAdapter;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String date;
    private long timeInMillis;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.agdesk.models.UIModels.TaskModel> tasksList = null;
    
    public TasksFragment() {
        super();
    }
    
    private final com.example.agdesk.ViewModels.AssetViewModel getAssetViewModel() {
        return null;
    }
    
    private final com.example.agdesk.ViewModels.TaskViewModel getTaskViewModel() {
        return null;
    }
    
    private final com.example.agdesk.databinding.FragmentTasksBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final long getTimeInMillis() {
        return 0L;
    }
    
    public final void setTimeInMillis(long p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView() {
    }
    
    @java.lang.Override()
    public void onEditClick(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.UIModels.TaskModel task) {
    }
    
    @java.lang.Override()
    public void onDeleteClick(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.UIModels.TaskModel task) {
    }
    
    private final void updateTasksList(java.util.List<com.example.agdesk.models.UIModels.TaskModel> tasks) {
    }
    
    private final void setSortSpinner() {
    }
    
    private final java.util.List<java.lang.Long> getDaysOfMonth(int year, int month) {
        return null;
    }
    
    private final void setDatePicker() {
    }
    
    private final void filterTasksByDate(long selectedDateInMillis) {
    }
    
    private final int getCurrentYear() {
        return 0;
    }
    
    private final int getCurrentMonth() {
        return 0;
    }
    
    private final java.lang.String getCurrentDate(long time) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}