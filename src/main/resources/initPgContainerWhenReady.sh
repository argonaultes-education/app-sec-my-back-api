for file in schema data ; do
  docker cp ${file}.sql people-tracking-db:/tmp/
  docker exec -it people-tracking-db psql -U peopletrackinguser peopletrackingdb -f /tmp/${file}.sql
done
