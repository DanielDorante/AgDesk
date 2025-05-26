package com.example.agdesk.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010H\u001a\u00020IH\u0002J\u0012\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J&\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u001a\u0010T\u001a\u00020K2\u0006\u0010U\u001a\u00020O2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010V\u001a\u00020KH\u0002J\b\u0010W\u001a\u00020KH\u0002J\u0012\u0010X\u001a\u00020K2\b\u0010Y\u001a\u0004\u0018\u00010\u000bH\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b\'\u0010$R\u001c\u0010(\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001e\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001c\u0010.\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u001e\u00101\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b09X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\"\"\u0004\b=\u0010$R\u001e\u0010>\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00107\u001a\u0004\b?\u00104\"\u0004\b@\u00106R\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b09X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010:R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bD\u0010E\u00a8\u0006Z"}, d2 = {"Lcom/example/agdesk/fragments/AddTaskFragment;", "Landroidx/fragment/app/Fragment;", "()V", "assignedId", "", "getAssignedId", "()Ljava/lang/Long;", "setAssignedId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "assignedName", "", "getAssignedName", "()Ljava/lang/String;", "setAssignedName", "(Ljava/lang/String;)V", "binding", "Lcom/example/agdesk/databinding/FragmentAddTaskBinding;", "getBinding", "()Lcom/example/agdesk/databinding/FragmentAddTaskBinding;", "setBinding", "(Lcom/example/agdesk/databinding/FragmentAddTaskBinding;)V", "dbHelper", "Lcom/example/agdesk/database/DatabaseHelper;", "getDbHelper", "()Lcom/example/agdesk/database/DatabaseHelper;", "setDbHelper", "(Lcom/example/agdesk/database/DatabaseHelper;)V", "description", "getDescription", "setDescription", "dueDateCalendar", "Ljava/util/Calendar;", "getDueDateCalendar", "()Ljava/util/Calendar;", "setDueDateCalendar", "(Ljava/util/Calendar;)V", "endTime", "getEndTime", "setEndTime", "expiryDateCalendar", "getExpiryDateCalendar", "setExpiryDateCalendar", "farmId", "getFarmId", "setFarmId", "name", "getName", "setName", "priority", "", "getPriority", "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "priorityLabels", "", "[Ljava/lang/String;", "startTime", "getStartTime", "setStartTime", "status", "getStatus", "setStatus", "statusLabels", "taskViewModel", "Lcom/example/agdesk/ViewModels/TaskViewModel;", "getTaskViewModel", "()Lcom/example/agdesk/ViewModels/TaskViewModel;", "taskViewModel$delegate", "Lkotlin/Lazy;", "isValidated", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "selectDueDate", "selectExpiryDate", "showMessage", "message", "app_debug"})
public final class AddTaskFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.databinding.FragmentAddTaskBinding binding;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String name = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String description = "";
    @org.jetbrains.annotations.Nullable()
    private java.util.Calendar startTime;
    @org.jetbrains.annotations.Nullable()
    private java.util.Calendar endTime;
    @org.jetbrains.annotations.Nullable()
    private java.util.Calendar dueDateCalendar;
    @org.jetbrains.annotations.Nullable()
    private java.util.Calendar expiryDateCalendar;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer status;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer priority;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long assignedId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String assignedName = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long farmId;
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.database.DatabaseHelper dbHelper;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy taskViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] statusLabels = {"Not Started", "In Progress", "Blocked", "Completed", "Failed", "Cancelled"};
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] priorityLabels = {"Low", "Medium", "High", "Critical"};
    
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
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable()
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
    public final java.util.Calendar getDueDateCalendar() {
        return null;
    }
    
    public final void setDueDateCalendar(@org.jetbrains.annotations.Nullable()
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Calendar getExpiryDateCalendar() {
        return null;
    }
    
    public final void setExpiryDateCalendar(@org.jetbrains.annotations.Nullable()
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPriority() {
        return null;
    }
    
    public final void setPriority(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getAssignedId() {
        return null;
    }
    
    public final void setAssignedId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAssignedName() {
        return null;
    }
    
    public final void setAssignedName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getFarmId() {
        return null;
    }
    
    public final void setFarmId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.agdesk.database.DatabaseHelper getDbHelper() {
        return null;
    }
    
    public final void setDbHelper(@org.jetbrains.annotations.Nullable()
    com.example.agdesk.database.DatabaseHelper p0) {
    }
    
    private final com.example.agdesk.ViewModels.TaskViewModel getTaskViewModel() {
        return null;
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
    
    private final void selectDueDate() {
    }
    
    private final void selectExpiryDate() {
    }
    
    private final void showMessage(java.lang.String message) {
    }
}