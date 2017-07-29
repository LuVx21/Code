# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html

import pymongo

class TutorialPipeline(object):
    def open_spider(self, spider):
        self.client = pymongo.MongoClient('localhost', 27017)
        self.test = self.client['test']
        self.testData = self.test['testData']
        pass

    def process_item(self, item, spider):
        data = {
            'title': item['title'],
            'url': item['url']
        }
        self.testData.insert_one(data)
        return item

    def close_spider(self, spider):
        pass