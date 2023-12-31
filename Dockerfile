# Use the official PostgreSQL image from Docker Hub
FROM postgres:latest

# Environment variables to set up the database
ENV POSTGRES_DB user_management
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD password

# Expose PostgreSQL port
EXPOSE 5432

# Custom initialization scripts (if needed)
# COPY init.sql /docker-entrypoint-initdb.d/  # You can use this line to copy custom initialization scripts if required

# You can also add any other configurations or scripts needed for your setup

# Start PostgreSQL service
CMD ["postgres"]
