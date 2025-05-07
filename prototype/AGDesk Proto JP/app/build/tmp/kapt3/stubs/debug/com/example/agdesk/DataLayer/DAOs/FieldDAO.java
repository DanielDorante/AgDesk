package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u00020\u00072\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\t\"\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/FieldDAO;", "", "getAllFields", "", "Lcom/example/agdesk/models/UIModels/FieldsModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFields", "", "fields", "", "Lcom/example/agdesk/DataLayer/entities/Fields;", "([Lcom/example/agdesk/DataLayer/entities/Fields;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSync", "sync", "Lcom/example/agdesk/DataLayer/entities/sync/FieldSync;", "([Lcom/example/agdesk/DataLayer/entities/sync/FieldSync;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface FieldDAO {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertFields(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.Fields[] fields, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT name, points FROM Fields")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllFields(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.agdesk.models.UIModels.FieldsModel>> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSync(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.DataLayer.entities.sync.FieldSync[] sync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}