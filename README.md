aletrader
=========

# connect to ec2 
ssh -i aletrader.pem ec2-user@54.213.164.75

# route 80 to 8080
iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to 8080

# deploy
mvn clean install -P rpm
sudo find ./target/rpm/aletrader/RPMS -name "aletrader*" -exec rpm -Uvh {} \;
sudo /etc/init.d/aletrader restart

