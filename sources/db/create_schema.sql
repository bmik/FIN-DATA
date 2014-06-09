-- FINDATA CREATE SCHEMA

DROP SCHEMA IF EXISTS findata CASCADE;
CREATE SCHEMA findata AUTHORIZATION findata;

CREATE TABLE findata.stocks (
	"id_stock" SERIAL,
	"code" varchar(10) NOT NULL,
	"full_name" varchar(255),
	PRIMARY KEY ("id_stock")
);


CREATE TABLE findata.companies (
	"id_company" SERIAL,
	"stock_id" INT NOT NULL,
	"code" varchar(10) NOT NULL,
	"full_name" varchar(255) NOT NULL,
	PRIMARY KEY ("id_company")
);

ALTER TABLE findata.companies ADD CONSTRAINT company_stock FOREIGN KEY (stock_id) REFERENCES findata.stocks (id_stock);

CREATE TABLE findata.exchanges (
	"id_exchange" SERIAL,
	"company_id" INT NOT NULL,
	"date" TIMESTAMP NOT NULL,
	"highest_value" REAL,
	"lowest_value" REAL,
	"closing_value" REAL,
	"volume_value" REAL,
	"change_value" REAL,
	PRIMARY KEY ("id_exchange")
);

ALTER TABLE findata.exchanges ADD CONSTRAINT exchange_company FOREIGN KEY (company_id) REFERENCES findata.companies (id_company);

GRANT ALL PRIVILEGES ON                  SCHEMA findata TO findata;
GRANT ALL PRIVILEGES ON ALL TABLES    IN SCHEMA findata TO findata;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA findata TO findata;