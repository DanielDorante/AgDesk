package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/InventoryDAO;", "", "Insert", "", "inventoryItem", "Lcom/example/agdesk/DataLayer/entities/InventoryItem;", "(Lcom/example/agdesk/DataLayer/entities/InventoryItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItem", "getAll", "", "Lcom/example/agdesk/models/UIModels/InventoryModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSync", "sync", "", "Lcom/example/agdesk/DataLayer/entities/sync/InventorySync;", "([Lcom/example/agdesk/DataLayer/entities/sync/InventorySync;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateItem", "app_debug"})
@androidx.room.Dao()
public abstract interface InventoryDAO {
    
    @androidx.room.Query(value = "SELECT * FROM InventoryItem")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.InventoryModel>> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object Insert(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.InventoryItem inventoryItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSync(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.sync.InventorySync[] sync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateItem(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.InventoryItem inventoryItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteItem(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.InventoryItem inventoryItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}