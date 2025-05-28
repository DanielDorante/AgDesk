from django.urls import path
from . import views

urlpatterns = [
    path('sync/', views.sync_assets_and_tasks),  
    path('fetch/', views.fetch_assets_and_tasks),
    path('push/', views.push_to_cloud_view),
    path('update-master/', views.update_master)
]