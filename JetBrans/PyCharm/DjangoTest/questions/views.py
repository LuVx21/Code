from django.shortcuts import render,redirect
from questions.models import Question


# Create your views here.

def index(request):
    question_list = Question.objects.all()
    return render(
        request,
        "questions/index.html",
        {'question_list': question_list},
    )


def add_done(request):
    add_question = Question()
    content = request.POST['content']
    add_question.context = content
    add_question.save()
    return render(
        request,
        "questions/add_done.html",
        {'question': content},
    )


def add_done(request):
    content = request.POST['content']
    if content != "":
        add_question = Question()
        add_question.context = content
        add_question.save()
        return render(
            request,
            "questions/add_done.html",
            {'question': content},
        )
    else:
        return redirect("/add/")


def add(request):
    return render(request, "questions/add.html")
