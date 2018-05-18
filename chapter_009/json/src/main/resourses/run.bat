set PGPASSWORD=pass

psql -U postgres -f create_db.sql
psql -U postgres -f createTables.sql
pause