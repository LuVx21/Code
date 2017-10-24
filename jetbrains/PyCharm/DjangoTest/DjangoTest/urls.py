"""DjangoTest URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/dev/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url, include
from django.contrib import admin

# 应用student
from student.views import *
from student.View.timeView import *
# 应用app1
from app1.views import *
from app1.View.timeView import *

# 应用blog
# from blog.urls import *

from questions import views
# 视图可能存在多个,命名


urlpatterns = [
    url(r'^admin/', admin.site.urls),

    # url(r'^blog/', archive),
    # url(r'^blog/', include('blog.urls')),

    # 应用app1
    url(r'^app1/', sayHello),

    # 应用student
    url(r'^student/', studentSayHello),
    url(r'^showPython/$', showPython),
    url(r'^showStudents/$', showStudents),
    url(r'^time/$', current_datetime),
    ## 动态URL
    url(r'^time/plus/(\d{1,2})/$', hours_ahead),

    ## mysite question应用
    url(r'^add/$', add),
    url(r'^index/$', index),
    url(r'^add_done/$', add_done),

]
