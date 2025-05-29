package com.example.agdesk.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/agdesk/adapters/TasksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/agdesk/adapters/TasksAdapter$ViewHolder;", "taskList", "", "Lcom/example/agdesk/models/UIModels/TaskModel;", "isHomeFragment", "", "taskListener", "Lcom/example/agdesk/adapters/TasksAdapter$TaskItemListener;", "(Ljava/util/List;ZLcom/example/agdesk/adapters/TasksAdapter$TaskItemListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setList", "TaskItemListener", "ViewHolder", "app_debug"})
public final class TasksAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.agdesk.adapters.TasksAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.agdesk.models.UIModels.TaskModel> taskList;
    private final boolean isHomeFragment = false;
    @org.jetbrains.annotations.Nullable()
    private final com.example.agdesk.adapters.TasksAdapter.TaskItemListener taskListener = null;
    
    public TasksAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.UIModels.TaskModel> taskList, boolean isHomeFragment, @org.jetbrains.annotations.Nullable()
    com.example.agdesk.adapters.TasksAdapter.TaskItemListener taskListener) {
        super();
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.UIModels.TaskModel> taskList) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.agdesk.adapters.TasksAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.TasksAdapter.ViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/agdesk/adapters/TasksAdapter$TaskItemListener;", "", "onDeleteClick", "", "task", "Lcom/example/agdesk/models/UIModels/TaskModel;", "onEditClick", "app_debug"})
    public static abstract interface TaskItemListener {
        
        public abstract void onEditClick(@org.jetbrains.annotations.NotNull()
        com.example.agdesk.models.UIModels.TaskModel task);
        
        public abstract void onDeleteClick(@org.jetbrains.annotations.NotNull()
        com.example.agdesk.models.UIModels.TaskModel task);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/example/agdesk/adapters/TasksAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "btnMenu", "Landroid/widget/ImageButton;", "getBtnMenu", "()Landroid/widget/ImageButton;", "relativeLayout", "Landroid/widget/RelativeLayout;", "getRelativeLayout", "()Landroid/widget/RelativeLayout;", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "tvTaskDate", "getTvTaskDate", "tvTaskTime", "getTvTaskTime", "bind", "", "task", "Lcom/example/agdesk/models/UIModels/TaskModel;", "isHomeFragment", "", "formatDate", "", "dateStr", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvTaskDate = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvTaskTime = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.RelativeLayout relativeLayout = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageButton btnMenu = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvTaskDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvTaskTime() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RelativeLayout getRelativeLayout() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageButton getBtnMenu() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.agdesk.models.UIModels.TaskModel task, boolean isHomeFragment) {
        }
        
        private final java.lang.String formatDate(java.lang.String dateStr) {
            return null;
        }
    }
}