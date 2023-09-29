aws ecr get-login-password --region us-west-1 | sudo docker login --username AWS --password-stdin 277525377628.dkr.ecr.us-west-1.amazonaws.com
sudo docker pull 277525377628.dkr.ecr.us-west-1.amazonaws.com/zap-auth-service:dev
sudo docker rm --force zap-auth-service
sudo docker image prune -f
sudo docker container prune -f
sudo docker run --name zap-auth-service  --network zap-network -p 8082:8082 -d 277525377628.dkr.ecr.us-west-1.amazonaws.com/zap-auth-service:dev