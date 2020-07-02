# Article Manager
This service handles the articles basic operations.

docker pull docker.elastic.co/elasticsearch/elasticsearch:6.2.3
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.2.3
