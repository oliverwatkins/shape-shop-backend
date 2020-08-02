create table bananas(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(200) not null,
	enabled boolean not null
);

create table blahblahs (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
);