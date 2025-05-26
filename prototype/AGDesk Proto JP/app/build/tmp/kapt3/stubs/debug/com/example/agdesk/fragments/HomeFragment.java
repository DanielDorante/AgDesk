package com.example.agdesk.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u000202H\u0016J\u001a\u00103\u001a\u0002022\u0006\u00104\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00105\u001a\u000202H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b$\u0010%R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/example/agdesk/fragments/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/agdesk/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/example/agdesk/databinding/FragmentHomeBinding;", "databaseHelper", "Lcom/example/agdesk/database/DatabaseHelper;", "getDatabaseHelper", "()Lcom/example/agdesk/database/DatabaseHelper;", "setDatabaseHelper", "(Lcom/example/agdesk/database/DatabaseHelper;)V", "homeViewModel", "Lcom/example/agdesk/ViewModels/HomeViewModel;", "getHomeViewModel", "()Lcom/example/agdesk/ViewModels/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "listOfTasks", "Ljava/util/ArrayList;", "Lcom/example/agdesk/models/UIModels/TaskModel;", "Lkotlin/collections/ArrayList;", "getListOfTasks", "()Ljava/util/ArrayList;", "setListOfTasks", "(Ljava/util/ArrayList;)V", "taskAdapter", "Lcom/example/agdesk/adapters/TasksAdapter;", "getTaskAdapter", "()Lcom/example/agdesk/adapters/TasksAdapter;", "setTaskAdapter", "(Lcom/example/agdesk/adapters/TasksAdapter;)V", "taskViewModel", "Lcom/example/agdesk/ViewModels/TaskViewModel;", "getTaskViewModel", "()Lcom/example/agdesk/ViewModels/TaskViewModel;", "taskViewModel$delegate", "weatherAdapter", "Lcom/example/agdesk/adapters/WeatherAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "setAdapter", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.databinding.FragmentHomeBinding _binding;
    private com.example.agdesk.adapters.WeatherAdapter weatherAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.agdesk.models.UIModels.TaskModel> listOfTasks;
    public com.example.agdesk.database.DatabaseHelper databaseHelper;
    public com.example.agdesk.adapters.TasksAdapter taskAdapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy taskViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy homeViewModel$delegate = null;
    
    public HomeFragment() {
        super();
    }
    
    private final com.example.agdesk.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.agdesk.models.UIModels.TaskModel> getListOfTasks() {
        return null;
    }
    
    public final void setListOfTasks(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.agdesk.models.UIModels.TaskModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.database.DatabaseHelper getDatabaseHelper() {
        return null;
    }
    
    public final void setDatabaseHelper(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.database.DatabaseHelper p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.adapters.TasksAdapter getTaskAdapter() {
        return null;
    }
    
    public final void setTaskAdapter(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.TasksAdapter p0) {
    }
    
    private final com.example.agdesk.ViewModels.TaskViewModel getTaskViewModel() {
        return null;
    }
    
    private final com.example.agdesk.ViewModels.HomeViewModel getHomeViewModel() {
        return null;
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
    
    private final void setAdapter() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}