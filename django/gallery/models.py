from django.db import models

class Photo(models.Model):
    title = models.CharField(max_length=100)
    image = models.ImageField(upload_to='gallery/')
    description = models.TextField(blank=True)

    def __strt__(self):
        return self.title

