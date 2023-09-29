aws ecr get-login-password --region us-west-1 | sudo docker login --username AWS --password-stdin 277525377628.dkr.ecr.us-west-1.amazonaws.com
sudo docker pull 277525377628.dkr.ecr.us-west-1.amazonaws.com/zap-user-service:dev
sudo docker rm --force zap-user-service
sudo docker image prune -f
sudo docker container prune -f
sudo docker run --name zap-user-service  --network zap-network -p 8083:8083 -d 277525377628.dkr.ecr.us-west-1.amazonaws.com/zap-user-service:dev