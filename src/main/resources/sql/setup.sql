CREATE TABLE financial_assets
(
    id               INT NOT NULL,
    record_type      INT,
    closed           BOOLEAN,
    created_at       TIMESTAMP,
    modified_at      TIMESTAMP,
    balance_negative BOOLEAN,
    balance_dollars  INT,
    balance_cents    INT,
    CONSTRAINT pk_financial_assets PRIMARY KEY (id)
);

CREATE TABLE transaction_statuses
(
    id          INT AUTO_INCREMENT NOT NULL,
    record_type INT,
    name        VARCHAR(255),
    description VARCHAR(255),
    created_at  TIMESTAMP,
    CONSTRAINT pk_transaction_statuses PRIMARY KEY (id)
);

CREATE TABLE savings_accounts
(
    id                             INT AUTO_INCREMENT NOT NULL,
    record_type                    INT,
    closed                         BOOLEAN,
    created_at                     TIMESTAMP,
    modified_at                    TIMESTAMP,
    annual_percentage_rate         INT,
    minimum_balance_negative       BOOLEAN,
    minimum_balance_dollars        INT,
    minimum_balance_cents          INT,
    insufficient_funds_fee_dollars INT,
    insufficient_funds_fee_cents   INT,
    CONSTRAINT pk_savings_accounts PRIMARY KEY (id)
);

CREATE TABLE checking_accounts
(
    id                             INT AUTO_INCREMENT NOT NULL,
    record_type                    INT,
    closed                         BOOLEAN,
    created_at                     TIMESTAMP,
    modified_at                    TIMESTAMP,
    minimum_balance_negative       BOOLEAN,
    minimum_balance_dollars        INT,
    minimum_balance_cents          INT,
    insufficient_funds_fee_dollars INT,
    insufficient_funds_fee_cents   INT,
    CONSTRAINT pk_checking_accounts PRIMARY KEY (id)
);

CREATE TABLE transactions
(
    id             INT AUTO_INCREMENT NOT NULL,
    record_type    INT,
    origin_id      INT,
    destination_id INT,
    status_id      INT,
    created_at     TIMESTAMP,
    received_at    TIMESTAMP,
    status_at      TIMESTAMP,
    dollars        INT,
    cents          INT,
    CONSTRAINT pk_transactions PRIMARY KEY (id)
);

ALTER TABLE transactions
    ADD CONSTRAINT FK_TRANSACTIONS_ON_DESTINATION FOREIGN KEY (destination_id) REFERENCES financial_assets (id);

ALTER TABLE transactions
    ADD CONSTRAINT FK_TRANSACTIONS_ON_ORIGIN FOREIGN KEY (origin_id) REFERENCES financial_assets (id);

ALTER TABLE transactions
    ADD CONSTRAINT FK_TRANSACTIONS_ON_STATUS FOREIGN KEY (status_id) REFERENCES transaction_statuses (id);