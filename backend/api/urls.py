from django.urls import path
from . import views

urlpatterns = [
    path('sync/', views.sync_assets_and_tasks),  
]