from django.test import TestCase
from django.test import Client


class QuestionMethodTests(TestCase):
    def test_add(self):
        client = Client()
        response = client.post('/add_done/', {'content': ""})
        self.assertNotEqual(response.status_code, 200)
