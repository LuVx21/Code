wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u141-b15/336fa29ff2bb4ef291e347e091f7f4a7/jdk-8u141-linux-x64.tar.gz"

tar -zxvf jdk-8u141-linux-x64.tar.gz -C /usr/local
sudo mv /usr/local/jdk-8u141-linux-x64 /usr/local/java

sudo echo 'export JAVA_HOME=/usr/local/java' >> .zshrc
sudo echo 'export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar' >> .zshrc
sudo echo 'export PATH=$PATH:$JAVA_HOME/bin' >> .zshrc
