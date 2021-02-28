CREATE TABLE IF NOT EXISTS currency
(
    currency_id INT AUTO_INCREMENT,
    iso_name    VARCHAR(3) NOT NULL,
    description varchar(100),
    PRIMARY KEY (currency_id)
);

CREATE TABLE IF NOT EXISTS payee
(
    payee_id VARCHAR(36),
    first_name    VARCHAR(100) NOT NULL,
    last_name varchar(100),
    email varchar(100),
    PRIMARY KEY (payee_id)
);

CREATE TABLE IF NOT EXISTS payer
(
    payer_id VARCHAR(36),
    first_name    VARCHAR(100) NOT NULL,
    last_name varchar(100),
    email varchar(100),
    url_callback varchar(256),
    PRIMARY KEY (payer_id)
);

CREATE TABLE IF NOT EXISTS payment_method_type
(
    payment_method_type_id INT AUTO_INCREMENT,
    type VARCHAR(25) NOT NULL,
    PRIMARY KEY (payment_method_type_id)
);


CREATE TABLE IF NOT EXISTS payment_method
(
    payment_method_id VARCHAR(36),
    bank_account varchar(12),
    payer_id VARCHAR(36),
    payment_method_type_id INT,
    PRIMARY KEY (payment_method_id),
    FOREIGN KEY (payer_id) REFERENCES payer(payer_id),
    FOREIGN KEY (payment_method_type_id) REFERENCES payment_method_type(payment_method_type_id)
);

CREATE TABLE IF NOT EXISTS payment
(
    payment_id BIGINT AUTO_INCREMENT,
    amount    DECIMAL(13,2),
    currency_id INT,
    payer_id VARCHAR(36),
    payee_id VARCHAR(36),
    payment_method_id VARCHAR(36),
    succeeded BOOLEAN,
    PRIMARY KEY (payment_id),
    FOREIGN KEY (currency_id) REFERENCES currency(currency_id),
    FOREIGN KEY (payer_id) REFERENCES payer(payer_id),
    FOREIGN KEY (payee_id) REFERENCES payee(payee_id),
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(payment_method_id)
);


INSERT INTO currency(iso_name, description)
VALUES ('AED', 'United Arab Emirates dirham'),
       ('AUD', 'Australian dollar'),
       ('BRL', 'Brazilian real'),
       ('CAD', 'Canadian dollar'),
       ('CHF', 'Swiss franc'),
       ('EUR', 'Euro'),
       ('GBP', 'Pound sterling'),
       ('HKD', 'Hong Kong dollar'),
       ('ILS', 'Israeli new shekel'),
       ('INR', 'Indian rupee'),
       ('JPY', 'Japanese yen'),
       ('KRW', 'South Korean won'),
       ('KWD', 'Kuwaiti dinar'),
       ('MXN', 'Mexican peso'),
       ('NZD', 'New Zealand dollar'),
       ('QAR', 'Qatari riyal'),
       ('RUB', 'Russian ruble'),
       ('SAR', 'Saudi riyal'),
       ('SLL', 'Sierra Leonean leone'),
       ('TRY', 'Turkish lira'),
       ('USD', 'United States dollar'),
       ('CNY', 'Renminbi (Chinese) yuan');

INSERT INTO payment_method_type(type)
VALUES ('DIRECT_DEPOSIT'),
       ('CREDIT_CARD'),
       ('MOBILE_PAYMENT'),
       ('BANK_TRANSFER'),
       ('E-WALLET'),
       ('PREPAID_CARD');

INSERT INTO payer(payer_id, first_name, last_name, email, url_callback)
VALUES (UUID(), 'Homer', 'Simpson', 'Homer.Simpson@simpsons.com','http://localhost:6767/users/homer/callback'),
       (UUID(), 'Marge', 'Simpson', 'Marge.Simpson@simpsons.com','http://localhost:6767/users/marge/callback'),
       (UUID(), 'Bart', 'Simpson', 'Bart.Simpson@simpsons.com','http://localhost:6767/users/bart/callback'),
       (UUID(), 'Lisa', 'Simpson', 'Lisa.Simpson@simpsons.com','http://localhost:6767/users/lisa/callback'),
       (UUID(), 'Maggie', 'Simpson', 'Lisa.Simpson@simpsons.com','http://localhost:6767/users/lisa/callback'),
       (UUID(), 'Abraham', 'Simpson', 'Abraham.Simpson@simpsons.com','http://localhost:6767/users/abraham/callback'),
       (UUID(), 'Apu', 'Nahasapeemapetilon', 'Apu.Nahasapeemapetilon@simpsons.com','http://localhost:6767/users/apu/callback'),
       (UUID(), 'Barney', 'Gumble', 'Barney.Gumble@simpsons.com','http://localhost:6767/users/barney/callback'),
       (UUID(), 'Dewey', 'Largo', 'Dewey.Largo@simpsons.com','http://localhost:6767/users/dewey/callback'),
       (UUID(), 'Edna', 'Krabappel', 'Edna.Krabappel@simpsons.com','http://localhost:6767/users/edna/callback');

INSERT INTO payee(payee_id, first_name, last_name, email)
VALUES (UUID(), 'Philip J.', 'Fry', 'Philip.Fry@futurama.com'),
       (UUID(), 'Turanga', 'Leela', 'Turanga.Leela@futurama.com'),
       (UUID(), 'Bender', 'Simpson', 'Bender.Rodriguez@futurama.com'),
       (UUID(), 'Amy', 'Wong', 'Amy.Wong@futurama.com'),
       (UUID(), 'Hermes', 'Conrad', 'Hermes.Conrad@futurama.com'),
       (UUID(), 'Hubert J.', 'Farnsworth', 'Hubert.Farnsworth@futurama.com'),
       (UUID(), 'John', 'Zoidberg', 'John.Zoidberg@futurama.com'),
       (UUID(), 'Zapp', 'Brannigan', 'Zapp.Brannigan@futurama.com'),
       (UUID(), 'Linda', 'van Schoonhoven', 'Linda.van.Schoonhoven@futurama.com'),
       (UUID(), 'Barbados', 'Slim', 'Barbados.Slim@futurama.com');

INSERT INTO payment_method(payment_method_id, bank_account, payer_id, payment_method_type_id)
VALUES (UUID(), '012345678922', (SELECT payer_id FROM payer WHERE first_name='Homer'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='DIRECT_DEPOSIT')),
       (UUID(), '022345678922', (SELECT payer_id FROM payer WHERE first_name='Marge'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='CREDIT_CARD')),
       (UUID(), '032345678922', (SELECT payer_id FROM payer WHERE first_name='Bart'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='PREPAID_CARD')),
       (UUID(), '042345678922', (SELECT payer_id FROM payer WHERE first_name='Lisa'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='PREPAID_CARD')),
       (UUID(), '052345678922', (SELECT payer_id FROM payer WHERE first_name='Maggie'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='BANK_TRANSFER')),
       (UUID(), '062345678922', (SELECT payer_id FROM payer WHERE first_name='Abraham'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='E-WALLET')),
       (UUID(), '072345678922', (SELECT payer_id FROM payer WHERE first_name='Apu'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='MOBILE_PAYMENT')),
       (UUID(), '082345678922', (SELECT payer_id FROM payer WHERE first_name='Barney'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='CREDIT_CARD')),
       (UUID(), '092345678922', (SELECT payer_id FROM payer WHERE first_name='Dewey'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='BANK_TRANSFER')),
       (UUID(), '093345678922', (SELECT payer_id FROM payer WHERE first_name='Edna'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='PREPAID_CARD')),
       (UUID(), '093345678922', (SELECT payer_id FROM payer WHERE first_name='Edna'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='E-WALLET')),
       (UUID(), '093355678922', (SELECT payer_id FROM payer WHERE first_name='Edna'), (SELECT payment_method_type_id FROM payment_method_type WHERE type='CREDIT_CARD'));


INSERT INTO payment(amount, currency_id, payer_id, payee_id, payment_method_id, succeeded)
VALUES (78.90,
        (SELECT currency_id FROM currency WHERE iso_name = 'USD'),
        (SELECT payer_id FROM payer WHERE first_name = 'Lisa'),
        (SELECT payee_id FROM payee  WHERE first_name = 'Philip J.'),
        (SELECT payment_method_id FROM payment_method WHERE payment_method.payer_id IN (SELECT payer_id FROM payer WHERE first_name = 'Lisa')),
        TRUE);
