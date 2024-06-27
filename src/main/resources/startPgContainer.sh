docker run --name people-tracking-db \
       -e POSTGRES_PASSWORD=peopletracking \
       -e POSTGRES_DB=peopletrackingdb \
       -e POSTGRES_USER=peopletrackinguser \
       -p 5555:5432 \
       -d postgres
