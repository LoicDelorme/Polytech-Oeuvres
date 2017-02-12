--
-- Table purchase_status_lov
--
CREATE TABLE purchase_status_lov (
  purchase_status_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  purchase_status_label varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO purchase_status_lov (purchase_status_label) VALUES ('Confirmed');
INSERT INTO purchase_status_lov (purchase_status_label) VALUES ('To confirm');
INSERT INTO purchase_status_lov (purchase_status_label) VALUES ('Waiting');
INSERT INTO purchase_status_lov (purchase_status_label) VALUES ('Cancelled');

--
-- Table artwork_state_lov
--
CREATE TABLE artwork_state_lov (
  artwork_state_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  artwork_state_label varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO artwork_state_lov (artwork_state_label) VALUES ('New');
INSERT INTO artwork_state_lov (artwork_state_label) VALUES ('Good');
INSERT INTO artwork_state_lov (artwork_state_label) VALUES ('Normal');
INSERT INTO artwork_state_lov (artwork_state_label) VALUES ('Medium');
INSERT INTO artwork_state_lov (artwork_state_label) VALUES ('Bad');

--
-- Table member
--
CREATE TABLE member (
  member_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  member_lastname varchar(255) NOT NULL,
  member_firstname varchar(255) NOT NULL,
  member_address varchar(255) NOT NULL,
  member_zipcode varchar(255) NOT NULL,
  member_city varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO member (member_lastname, member_firstname, member_address, member_zipcode, member_city) VALUES ('LESSERTISSEUR', 'Christelle', 'Boulevard du 11 Novembre', '69100', 'Villeurbanne');
INSERT INTO member (member_lastname, member_firstname, member_address, member_zipcode, member_city) VALUES ('MARTIN', 'Laurent', 'Boulevard du 11 Novembre', '69100', 'Villeurbanne');
INSERT INTO member (member_lastname, member_firstname, member_address, member_zipcode, member_city) VALUES ('DUPONT', 'Didier', 'Boulevard du 11 Novembre', '69100', 'Villeurbanne');
INSERT INTO member (member_lastname, member_firstname, member_address, member_zipcode, member_city) VALUES ('DURANT', 'Michel', 'Boulevard du 11 Novembre', '69100', 'Villeurbanne');
INSERT INTO member (member_lastname, member_firstname, member_address, member_zipcode, member_city) VALUES ('CHOPIN', 'Daniel', 'Boulevard du 11 Novembre', '69100', 'Villeurbanne');
INSERT INTO member (member_lastname, member_firstname, member_address, member_zipcode, member_city) VALUES ('MOZART', 'Albert', 'Boulevard du 11 Novembre', '69100', 'Villeurbanne');
INSERT INTO member (member_lastname, member_firstname, member_address, member_zipcode, member_city) VALUES ('FRUCCI', 'Fraise', 'Boulevard du 11 Novembre', '69100', 'Villeurbanne');
INSERT INTO member (member_lastname, member_firstname, member_address, member_zipcode, member_city) VALUES ('BRUN', 'Pierre', 'Boulevard du 11 Novembre', '69100', 'Villeurbanne');
INSERT INTO member (member_lastname, member_firstname, member_address, member_zipcode, member_city) VALUES ('BLANC', 'Serge', 'Boulevard du 11 Novembre', '69100', 'Villeurbanne');

--
-- Table owner
--
CREATE TABLE owner (
  owner_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  owner_lastname varchar(255) NOT NULL,
  owner_firstname varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO owner (owner_lastname, owner_firstname) VALUES ('DUPONT', 'Isabelle');
INSERT INTO owner (owner_lastname, owner_firstname) VALUES ('DUPUIS', 'Valerie');
INSERT INTO owner (owner_lastname, owner_firstname) VALUES ('MOZART', 'Albert');

--
-- Table loan_artwork
--
CREATE TABLE loan_artwork (
  loan_artwork_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  loan_artwork_title varchar(255) NOT NULL,
  loan_artwork_duration int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO loan_artwork (loan_artwork_title, loan_artwork_duration) VALUES ('Loan Artwork 1', 15);
INSERT INTO loan_artwork (loan_artwork_title, loan_artwork_duration) VALUES ('Loan Artwork 2', 4);
INSERT INTO loan_artwork (loan_artwork_title, loan_artwork_duration) VALUES ('Loan Artwork 3', 11);
INSERT INTO loan_artwork (loan_artwork_title, loan_artwork_duration) VALUES ('Loan Artwork 4', 7);
INSERT INTO loan_artwork (loan_artwork_title, loan_artwork_duration) VALUES ('Loan Artwork 5', 35);
INSERT INTO loan_artwork (loan_artwork_title, loan_artwork_duration) VALUES ('Loan Artwork 6', 2);
INSERT INTO loan_artwork (loan_artwork_title, loan_artwork_duration) VALUES ('Loan Artwork 7', 12);

--
-- Table sale_artwork
--
CREATE TABLE sale_artwork (
  sale_artwork_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sale_artwork_title varchar(255) NOT NULL,
  sale_artwork_state_id int NOT NULL,
  sale_artwork_price float NOT NULL,
  FOREIGN KEY (sale_artwork_state_id) REFERENCES artwork_state_lov(artwork_state_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO sale_artwork (sale_artwork_title, sale_artwork_state_id, sale_artwork_price) VALUES ('Sale Artwork 1', 1, 58.68);
INSERT INTO sale_artwork (sale_artwork_title, sale_artwork_state_id, sale_artwork_price) VALUES ('Sale Artwork 3', 2, 40.59);
INSERT INTO sale_artwork (sale_artwork_title, sale_artwork_state_id, sale_artwork_price) VALUES ('Sale Artwork 4', 3, 120.05);
INSERT INTO sale_artwork (sale_artwork_title, sale_artwork_state_id, sale_artwork_price) VALUES ('Sale Artwork 5', 4, 49.89);
INSERT INTO sale_artwork (sale_artwork_title, sale_artwork_state_id, sale_artwork_price) VALUES ('Sale Artwork 6', 5, 12.13);

--
-- Table loan
--
CREATE TABLE loan (
  loan_artwork_id int NOT NULL,
  loan_date date NOT NULL,
  loan_duration int NOT NULL,
  member_id int NOT NULL,
  FOREIGN KEY (loan_artwork_id) REFERENCES loan_artwork(loan_artwork_id),
  FOREIGN KEY (member_id) REFERENCES member(member_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table purchase
--
CREATE TABLE purchase (
  sale_artwork_id int NOT NULL,
  purchase_date date NOT NULL,
  purchase_status_id int NOT NULL,
  owner_id int NOT NULL,
  FOREIGN KEY (sale_artwork_id) REFERENCES sale_artwork(sale_artwork_id),
  FOREIGN KEY (owner_id) REFERENCES owner(owner_id),
  FOREIGN KEY (purchase_status_id) REFERENCES purchase_status_lov(purchase_status_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;