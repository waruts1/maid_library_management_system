--CREATE book table
CREATE TABLE IF NOT EXISTS book
(
    id                 integer,
    author             character varying(100) NOT NULL,
    title              character varying      NOT NULL,
    publication_year   character varying(100) NOT NULL,
    date_created       timestamp,
    updated_at         timestamp,
    isbn               character varying,
    PRIMARY KEY (id)
);

--CREATE Borrowing record
CREATE TABLE IF NOT EXISTS borrowing_record
(
    id                 integer,
    book_id            integer NOT NULL,
    patron_id          integer  NOT NULL,
    borrowing_date     character varying,
    return_date     character varying,
    PRIMARY KEY (id)
);

--CREATE patron table
CREATE TABLE IF NOT EXISTS patron
(
    id                 integer,
    contact_name       character varying(100) NOT NULL,
    contact_number     character varying(13)  NOT NULL,
    email              character varying(50)  NOT NULL,
    PRIMARY KEY (id)
);

--Create Auto Increments Sequences
CREATE SEQUENCE book_seq
    INCREMENT 1;
CREATE SEQUENCE patron_seq
    INCREMENT 1;
CREATE SEQUENCE borrowing_record_seq
    INCREMENT 1;