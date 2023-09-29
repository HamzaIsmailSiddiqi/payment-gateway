aws ecr get-login-password --region us-west-1 | sudo docker login --username AWS --password-stdin 277525377628.dkr.ecr.us-west-1.amazonaws.com
sudo docker pull 277525377628.dkr.ecr.us-west-1.amazonaws.com/zap-discovery-service:dev
sudo docker rm --force zap-discovery-service
sudo docker image prune -f
sudo docker container prune -f
sudo docker run --name zap-discovery-service --network zap-network -p 8761:8761 -d 277525377628.dkr.ecr.us-west-1.amazonaws.com/zap-discovery-service:dev