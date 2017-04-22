from django.contrib import admin
from questions.models import Question



class QuestionAdmin(admin.ModelAdmin):
    list_display = ('context',)


admin.site.register(Question, QuestionAdmin)
