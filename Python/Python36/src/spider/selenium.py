from selenium import webdriver
import sys


driver = webdriver.PhantomJS()
doc = driver.get("https://dict.hjenglish.com/jp/jc/%E4%B8%80%E5%BF%9C")
print(driver)

print(driver.title)