package com.example.agdesk.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0006\u0010\u0014\u001a\u00020\u000eJ\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/example/agdesk/adapters/DateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/agdesk/adapters/DateAdapter$DateViewHolder;", "dates", "", "", "onSelected", "Lcom/example/agdesk/adapters/DateAdapter$OnSelected;", "(Ljava/util/List;Lcom/example/agdesk/adapters/DateAdapter$OnSelected;)V", "getOnSelected", "()Lcom/example/agdesk/adapters/DateAdapter$OnSelected;", "setOnSelected", "(Lcom/example/agdesk/adapters/DateAdapter$OnSelected;)V", "selected", "", "getSelected", "()I", "setSelected", "(I)V", "getItemCount", "getSelectedPosition", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedPosition", "DateViewHolder", "OnSelected", "app_debug"})
public final class DateAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.agdesk.adapters.DateAdapter.DateViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Long> dates = null;
    @org.jetbrains.annotations.NotNull()
    private com.example.agdesk.adapters.DateAdapter.OnSelected onSelected;
    private int selected = 0;
    
    public DateAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> dates, @org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.DateAdapter.OnSelected onSelected) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.adapters.DateAdapter.OnSelected getOnSelected() {
        return null;
    }
    
    public final void setOnSelected(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.DateAdapter.OnSelected p0) {
    }
    
    public final int getSelected() {
        return 0;
    }
    
    public final void setSelected(int p0) {
    }
    
    public final void setSelectedPosition(int selected) {
    }
    
    public final int getSelectedPosition() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.agdesk.adapters.DateAdapter.DateViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.DateAdapter.DateViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/example/agdesk/adapters/DateAdapter$DateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "dateTextView", "Landroid/widget/TextView;", "getDateTextView", "()Landroid/widget/TextView;", "topView", "getTopView", "()Landroid/view/View;", "bind", "", "dateInMillis", "", "app_debug"})
    public static final class DateViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView dateTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View topView = null;
        
        public DateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getDateTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getTopView() {
            return null;
        }
        
        public final void bind(long dateInMillis) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/agdesk/adapters/DateAdapter$OnSelected;", "", "onSelected", "", "data", "", "app_debug"})
    public static abstract interface OnSelected {
        
        public abstract void onSelected(long data);
    }
}