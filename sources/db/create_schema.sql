-- FINDATA CREATE SCHEMA

DROP SCHEMA IF EXISTS findata;
CREATE SCHEMA findata AUTHORIZATION findata;

CREATE SEQUENCE findata.stocks_id_seq INCREMENT 1 START 1;

CREATE TABLE findata.stocks (
	"id_stock" INT NOT NULL DEFAULT nextval('findata.stocks_id_seq'),
	"code" varchar(10) NOT NULL,
	"full_name" varchar(255),
	PRIMARY KEY ("id_stock")
);


CREATE SEQUENCE findata.companies_id_seq INCREMENT 1 START 1;

CREATE TABLE findata.companies (
	"id_company" INT NOT NULL DEFAULT nextval('findata.companies_id_seq'),
	"stock_id" INT NOT NULL,
	"code" varchar(10) NOT NULL,
	"full_name" varchar(255) NOT NULL,
	PRIMARY KEY ("id_company")
);

ALTER TABLE findata.companies ADD CONSTRAINT company_stock FOREIGN KEY (stock_id) REFERENCES findata.stocks (id_stock);


CREATE SEQUENCE findata.quotations_id_seq INCREMENT 1 START 1;

CREATE TABLE findata.quotations (
	"id_quotation" INT NOT NULL DEFAULT nextval('findata.quotations_id_seq'),
	"company_id" INT NOT NULL,
-- dodać kolumny z notowaniami
	PRIMARY KEY ("id_quotation")
);

ALTER TABLE findata.quotations ADD CONSTRAINT quotation_company FOREIGN KEY (company_id) REFERENCES findata.companies (id_company);
