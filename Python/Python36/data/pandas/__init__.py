# -*- coding=utf-8 -*-
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt


# 使用pandas
budget = pd.read_csv("mn-budget-detail-2014.csv")
budget = budget.sort('amount', ascending=False)[:10]

pd.options.display.mpl_style = 'default'
budget_plot = budget.plot(kind="bar", x=budget["detail"],
                          title="MN Capital Budget - 2014",
                          legend=False)

fig = budget_plot.get_figure()
fig.savefig("2014-mn-capital-budget.png")

# 使用seaborn
sns.set_style("darkgrid")
bar_plot = sns.barplot(x=budget["detail"], y=budget["amount"],
                       palette="muted",
                       x_order=budget["detail"].tolist())
plt.xticks(rotation=90)
plt.show()
