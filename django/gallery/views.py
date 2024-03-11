from django.views.generic import ListView, CreateView, DeleteView
from django.urls import reverse_lazy
from .models import Photo
from .forms import PhotoForm

class PhotoGalleryView(ListView):
    model = Photo
    template_name = 'gallery/gallery.html'
    context_object_name = 'photos'

class PhotoUploadView(CreateView):
    model = Photo
    form_class = PhotoForm
    template_name = 'gallery/photo_upload.html'
    success_url = reverse_lazy('photo_gallery')

class PhotoDeleteView(DeleteView):
    model = Photo
    template_name = 'gallery/photo_confirm_delete.html'
    success_url = reverse_lazy('photo_gallery')

