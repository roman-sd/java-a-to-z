psql -U postgres -f Create_db.sql
psql -U postgres -f Tables.sql
psql -U postgres -f Init.sql
psql -U postgres -f Test_view.sql
psql -U postgres -f Drop.sql