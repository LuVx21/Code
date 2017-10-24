from flask import Flask

app = Flask(__name__)


@app.route('/')
def index():
    return 'Index Page'


@app.route('/hello')
def hello():
    return 'Hello World'


# 可变URL
@app.route('/user/<username>')
def show_user_profile(username):
    # show the user profile for that user
    return 'User %s' % username


@app.route('/post/<int:post_id>')
def show_post(post_id):
    # show the post with the given id, the id is an integer
    # int    接受整数
    # float    同int一样，但是接受浮点数
    # path    和默认的相似，但也接受斜线
    return 'Post %d' % post_id


# 唯一 URL
@app.route('/projects/')
def projects():
    return 'The project page'


@app.route('/about')
def about():
    return 'The about page'



if __name__ == '__main__':
    # debug模式启动1
    app.debug = True
    app.run()
    # debug模式启动2
    # app.run(debug=True)
