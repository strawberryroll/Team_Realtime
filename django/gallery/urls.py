from django.urls import path
from .views import PhotoGalleryView, PhotoUploadView, PhotoDeleteView

urlpatterns = [
    path('', PhotoGalleryView.as_view(), name='photo_gallery'),
    path('upload/', PhotoUploadView.as_view(), name='photo_upload'),
    path('delete/<int:pk>', PhotoDeleteView.as_view(), name='photo_delete')
]

