package com.example.agdesk.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0014\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/agdesk/adapters/InventoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/agdesk/adapters/InventoryAdapter$ViewHolder;", "inventoryList", "", "Lcom/example/agdesk/models/UIModels/InventoryModel;", "listener", "Lcom/example/agdesk/adapters/InventoryAdapter$InventoryItemListener;", "(Ljava/util/List;Lcom/example/agdesk/adapters/InventoryAdapter$InventoryItemListener;)V", "onItemClick", "Lkotlin/Function1;", "", "onDeleteClick", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "inventoryListener", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setList", "InventoryItemListener", "ViewHolder", "app_debug"})
public final class InventoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.agdesk.adapters.InventoryAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.agdesk.models.UIModels.InventoryModel> inventoryList;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.example.agdesk.models.UIModels.InventoryModel, kotlin.Unit> onItemClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.example.agdesk.models.UIModels.InventoryModel, kotlin.Unit> onDeleteClick = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.adapters.InventoryAdapter.InventoryItemListener inventoryListener;
    
    public InventoryAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.UIModels.InventoryModel> inventoryList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.agdesk.models.UIModels.InventoryModel, kotlin.Unit> onItemClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.agdesk.models.UIModels.InventoryModel, kotlin.Unit> onDeleteClick) {
        super();
    }
    
    public InventoryAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.UIModels.InventoryModel> inventoryList, @org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.InventoryAdapter.InventoryItemListener listener) {
        super();
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.UIModels.InventoryModel> inventoryList) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.agdesk.adapters.InventoryAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.InventoryAdapter.ViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/agdesk/adapters/InventoryAdapter$InventoryItemListener;", "", "onDeleteClick", "", "inventory", "Lcom/example/agdesk/models/UIModels/InventoryModel;", "onEditClick", "app_debug"})
    public static abstract interface InventoryItemListener {
        
        public abstract void onEditClick(@org.jetbrains.annotations.NotNull()
        com.example.agdesk.models.UIModels.InventoryModel inventory);
        
        public abstract void onDeleteClick(@org.jetbrains.annotations.NotNull()
        com.example.agdesk.models.UIModels.InventoryModel inventory);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/example/agdesk/adapters/InventoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "btnMenu", "Landroid/widget/ImageButton;", "getBtnMenu", "()Landroid/widget/ImageButton;", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "tvQuantity", "getTvQuantity", "bind", "", "inventory", "Lcom/example/agdesk/models/UIModels/InventoryModel;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvQuantity = null;
        @org.jetbrains.annotations.Nullable()
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
        public final android.widget.TextView getTvQuantity() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.ImageButton getBtnMenu() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.agdesk.models.UIModels.InventoryModel inventory) {
        }
    }
}