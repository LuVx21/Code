#coding:utf-8
import scrapy
from bs4 import BeautifulSoup
from ..items import xianyuItem

class testSpider(scrapy.Spider):
    name = 'test'
    start_urls = ['http://tj.ganji.com/fang1/']

    def parse(self, response):
        print('lalala')
        for title in response.xpath('//*[contains(concat( " ", @class, " " ), concat( " ", "js-title", " " ))]'):
            url = title.xpath('@href').extract()[0]
            if url.find('http')==-1:
                url = 'http://tj.ganji.com'+url
            yield scrapy.Request(url, self.detail)

    def detail(self, response):
        data = BeautifulSoup(response.body, 'lxml')
        title = data.select('div.content.clearfix > div.leftBox > div.col-cont.title-box > h1')
        item = xianyuItem()
        item['title'] = title[0].get_text()
        item['url'] = response.url
        return item