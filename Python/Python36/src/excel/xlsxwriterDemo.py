# coding=utf-8

# xlsxwriter可以写excel文件并加上图表

import xlsxwriter

def get_chart(series):
    chart = workbook.add_chart({'type': 'line'})
    for ses in series:
        name = ses["name"]
        values = ses["values"]
        chart.add_series({ 
            'name': name,
            'categories': 'A2:A10',
            'values':values
        })  
    chart.set_size({'width': 700, 'height': 350}) 
    return chart

if __name__ == '__main__':
    workbook = xlsxwriter.Workbook(u'chart.xlsx') 
    worksheet = workbook.add_worksheet(u"PV_UV")
    headings = ['日期', '平均值']
    worksheet.write_row('A1', headings)
    index=0
    for row in range(1,10):
        for col in [0,1]:
            worksheet.write(row,col,index)
            index += 1
    series = [{"name":"平均值","values":"B2:B10"}]
    chart = get_chart(series)
    chart.set_title ({'name': '每日页面分享数据'})  
    worksheet.insert_chart('H7', chart)
    workbook.close()