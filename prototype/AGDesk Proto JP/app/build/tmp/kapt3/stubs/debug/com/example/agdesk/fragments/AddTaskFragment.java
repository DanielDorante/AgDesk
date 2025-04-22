package com.example.agdesk.fragments;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u00100\u001a\u00020\'2\u0006\u00101\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00102\u001a\u00020\'H\u0002J\b\u00103\u001a\u00020\'H\u0002J\u0012\u00104\u001a\u00020\'2\b\u00105\u001a\u0004\u0018\u00010\nH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e\u00a8\u00066"}, d2 = {"Lcom/example/agdesk/fragments/AddTaskFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/agdesk/databinding/FragmentAddTaskBinding;", "getBinding", "()Lcom/example/agdesk/databinding/FragmentAddTaskBinding;", "setBinding", "(Lcom/example/agdesk/databinding/FragmentAddTaskBinding;)V", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "dbHelper", "Lcom/example/agdesk/database/DatabaseHelper;", "getDbHelper", "()Lcom/example/agdesk/database/DatabaseHelper;", "setDbHelper", "(Lcom/example/agdesk/database/DatabaseHelper;)V", "endTime", "Ljava/util/Calendar;", "getEndTime", "()Ljava/util/Calendar;", "setEndTime", "(Ljava/util/Calendar;)V", "name", "getName", "setName", "startTime", "getStartTime", "setStartTime", "time", "getTime", "setTime", "isValidated", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "selectDate", "selectTime", "showMessage", "message", "app_debug"})
public final class AddTaskFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.databinding.FragmentAddTaskBinding binding;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String name = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String date = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String time = "";
    @org.jetbrains.annotations.Nullable()
    private java.util.Calendar startTime;
    @org.jetbrains.annotations.Nullable()
    private java.util.Calendar endTime;
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.database.DatabaseHelper dbHelper;
    
    public AddTaskFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.agdesk.databinding.FragmentAddTaskBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.Nullable()
    com.example.agdesk.databinding.FragmentAddTaskBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Calendar getStartTime() {
        return null;
    }
    
    public final void setStartTime(@org.jetbrains.annotations.Nullable()
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Calendar getEndTime() {
        return null;
    }
    
    public final void setEndTime(@org.jetbrains.annotations.Nullable()
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.agdesk.database.DatabaseHelper getDbHelper() {
        return null;
    }
    
    public final void setDbHelper(@org.jetbrains.annotations.Nullable()
    com.example.agdesk.database.DatabaseHelper p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
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
    
    private final boolean isValidated() {
        return false;
    }
    
    private final void selectDate() {
    }
    
    private final void selectTime() {
    }
    
    private final void showMessage(java.lang.String message) {
    }
}