docker build -t springboot_restful_webservices_postgres .
docker run -d -p 5432:5432 springboot_restful_webservices_postgres