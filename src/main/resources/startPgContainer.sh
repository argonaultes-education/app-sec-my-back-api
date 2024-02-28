docker run --name people-tracking-db \
       -e POSTGRES_PASSWORD=peopletracking \
       -e POSTGRES_DB=peopletrackingdb \
       -e POSTGRES_USER=peopletracking \
       -p 5432:5432 \
       -d postgres
