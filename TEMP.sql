#
#
# START TRANSACTION;
#
# -- Call the file containing table creation statements
#
#
# SOURCE /path/to/table_creation.sql;
#
# -- Call the file containing data insertion statements
# SOURCE /path/to/data_insertion.sql;
#
# -- Call the file containing stored procedure definitions
# SOURCE /path/to/stored_procedures.sql;
#
#
#
# COMMIT;