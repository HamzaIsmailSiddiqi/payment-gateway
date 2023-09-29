CREATE TABLE tbl_userprofile(
   	userid INT PRIMARY KEY NOT NULL,
	username VARCHAR(50) NOT NULL,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	email VARCHAR(30) NOT NULL,
	phone_number VARCHAR(30) NOT NULL,
	image_url VARCHAR(500) NOT NULL,
	dob date,
	country_code VARCHAR(10),
	password VARCHAR(500),
	pin numeric not null,
	finger_print VARCHAR(500),
	account_status VARCHAR(50),
	otp_verified VARCHAR(50),
	created_at TIMESTAMP NOT NULL,
	kyc_verifiedby VARCHAR(50),
	max_otp_retry_count int,
	login_blocked boolean not null,
);

CREATE SEQUENCE tbl_userprofile_seq
	INCREMENT 1
	START 1;

CREATE TABLE tbl_loginActivity(
   	loginid INT PRIMARY KEY NOT NULL,
	userid INT,
	verification_done boolean,
	otp_verified VARCHAR(50),
	login_time timestamp not null,
	logout_time timestamp,
	otp_retry_count int,
	CONSTRAINT fk_userid_tbl_userprofile FOREIGN KEY(userid)
		REFERENCES tbl_userprofile(userid)
);

CREATE SEQUENCE tbl_loginActivity_seq
	INCREMENT 1
	START 1;

CREATE TABLE tbl_authActivity(
   	loginid INT PRIMARY KEY NOT NULL,
	userid INT,
	actual_otp_value VARCHAR(50),
	given_otp_value timestamp not null,
	otpcreated_time timestamp,
	CONSTRAINT fk_userid_tbl_userprofile FOREIGN KEY(userid)
		REFERENCES tbl_userprofile(userid)
);

CREATE SEQUENCE tbl_authActivity_seq
	INCREMENT 1
	START 1;

CREATE TABLE tbl_adminuser(
	userid INT PRIMARY KEY NOT NULL,
	username VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	Role VARCHAR(100) NOT NULL,
	created_at timestamp NOT NULL
);

CREATE SEQUENCE tbl_adminuser_seq
	INCREMENT 1
	START 1;