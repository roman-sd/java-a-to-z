set PGPASSWORD=pass
psql -U postgres -f create_db.sql
psql -U postgres -f create_tables.sql
psql -U postgres -f init.sql
psql -U postgres -f queries.sql