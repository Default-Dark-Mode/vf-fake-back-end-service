create database if not exists fake_back_end_service;

use fake_back_end_service;

create table if not exists addresses
(
    id          int auto_increment
        primary key,
    number      int          null,
    street      varchar(255) null,
    city        varchar(255) null,
    county      varchar(255) null,
    state       varchar(255) null,
    country     varchar(255) null,
    postal_code varchar(255) null
);

create table if not exists document_records
(
    id            varchar(255) not null
        primary key,
    title         varchar(255) null,
    document_type varchar(255) null,
    created_at    datetime     null,
    modified_at   datetime     null
);

create table if not exists emails
(
    id               int auto_increment
        primary key,
    verified         bit          null,
    account          varchar(255) null,
    domain           varchar(255) null,
    top_level_domain varchar(255) null,
    created_at       datetime     null
);

create table if not exists identities
(
    id          varchar(255) not null
        primary key,
    created_at  datetime     null,
    modified_at datetime     null
);

create table if not exists access_accounts
(
    id                     int auto_increment
        primary key,
    login_credentials_id   int          null,
    identity_id            varchar(255) null,
    contact_information_id int          null,
    constraint FK_ACCESS_ACCOUNTS_ON_IDENTITY
        foreign key (identity_id) references identities (id)
);

create table if not exists atm_cards
(
    id                       varchar(255) not null
        primary key,
    activated                bit          null,
    deactivated              bit          null,
    issued_to_id             varchar(255) null,
    access_account           int          null,
    associated_identities_id varchar(255) null,
    issued_date              datetime     null,
    expiration_date          datetime     null,
    pin                      varchar(255) null,
    constraint FK_ATM_CARDS_ON_ACCESS_ACCOUNT
        foreign key (access_account) references access_accounts (id),
    constraint FK_ATM_CARDS_ON_ASSOCIATEDIDENTITIES
        foreign key (associated_identities_id) references identities (id),
    constraint FK_ATM_CARDS_ON_ISSUEDTO
        foreign key (issued_to_id) references identities (id)
);

create table if not exists checking_accounts
(
    id                             varchar(255) not null
        primary key,
    closed                         bit          null,
    access_account                 int          null,
    created_at                     datetime     null,
    modified_at                    datetime     null,
    minimum_balance_negative       bit          null,
    minimum_balance_dollars        int          null,
    minimum_balance_cents          int          null,
    insufficient_funds_fee_dollars int          null,
    insufficient_funds_fee_cents   int          null,
    constraint FK_CHECKING_ACCOUNTS_ON_ACCESS_ACCOUNT
        foreign key (access_account) references access_accounts (id)
);

create table if not exists debit_cards
(
    id                       varchar(255) not null
        primary key,
    activated                bit          null,
    deactivated              bit          null,
    issued_to_id             varchar(255) null,
    access_account           int          null,
    associated_identities_id varchar(255) null,
    issued_date              datetime     null,
    expiration_date          datetime     null,
    source_id                varchar(255) null,
    pin                      varchar(255) null,
    constraint FK_DEBIT_CARDS_ON_ACCESS_ACCOUNT
        foreign key (access_account) references access_accounts (id),
    constraint FK_DEBIT_CARDS_ON_ASSOCIATEDIDENTITIES
        foreign key (associated_identities_id) references identities (id),
    constraint FK_DEBIT_CARDS_ON_ISSUEDTO
        foreign key (issued_to_id) references identities (id),
    constraint FK_DEBIT_CARDS_ON_SOURCE
        foreign key (source_id) references checking_accounts (id)
);

create table if not exists financial_assets
(
    id               varchar(255) not null
        primary key,
    closed           bit          null,
    access_account   int          null,
    created_at       datetime     null,
    modified_at      datetime     null,
    balance_negative bit          null,
    balance_dollars  int          null,
    balance_cents    int          null,
    constraint FK_FINANCIAL_ASSETS_ON_ACCESS_ACCOUNT
        foreign key (access_account) references access_accounts (id)
);

create table if not exists financial_cards
(
    id                       varchar(255) not null
        primary key,
    activated                bit          null,
    deactivated              bit          null,
    issued_to_id             varchar(255) null,
    access_account           int          null,
    associated_identities_id varchar(255) null,
    issued_date              datetime     null,
    expiration_date          datetime     null,
    card_number              varchar(255) null,
    cvv                      varchar(255) null,
    dollars                  int          null,
    cents                    int          null,
    constraint FK_FINANCIAL_CARDS_ON_ACCESS_ACCOUNT
        foreign key (access_account) references access_accounts (id),
    constraint FK_FINANCIAL_CARDS_ON_ASSOCIATEDIDENTITIES
        foreign key (associated_identities_id) references identities (id),
    constraint FK_FINANCIAL_CARDS_ON_ISSUEDTO
        foreign key (issued_to_id) references identities (id)
);

create table if not exists login_credentials
(
    id                int auto_increment
        primary key,
    deactivated       bit          null,
    username          varchar(255) null,
    secured_password  varchar(255) null,
    access_account_id int          null,
    created_at        datetime     null,
    constraint FK_LOGIN_CREDENTIALS_ON_ACCESSACCOUNT
        foreign key (access_account_id) references access_accounts (id)
);

alter table access_accounts
    add constraint FK_ACCESS_ACCOUNTS_ON_LOGINCREDENTIALS
        foreign key (login_credentials_id) references login_credentials (id);

create table if not exists natural_names
(
    id   int auto_increment
        primary key,
    name varchar(255) null
);

create table if not exists organizational_names
(
    id   int auto_increment
        primary key,
    name varchar(255) null
);

create table if not exists organizations
(
    id                varchar(255) not null
        primary key,
    created_at        datetime     null,
    modified_at       datetime     null,
    organization_type varchar(255) null
);

create table if not exists personal_names
(
    id              int auto_increment
        primary key,
    natural_name_id int      null,
    name_order      int      null,
    created_at      datetime null,
    modified_at     datetime null,
    constraint FK_PERSONAL_NAMES_ON_NATURALNAME
        foreign key (natural_name_id) references natural_names (id)
);

create table if not exists name_records
(
    id                int auto_increment
        primary key,
    preferred_name_id int      null,
    created_at        datetime null,
    modified_at       datetime null,
    constraint FK_NAME_RECORDS_ON_PREFERREDNAME
        foreign key (preferred_name_id) references personal_names (id)
);

create table if not exists identification_document_records
(
    id                    varchar(255) not null
        primary key,
    title                 varchar(255) null,
    document_type         varchar(255) null,
    created_at            datetime     null,
    modified_at           datetime     null,
    identification_number varchar(255) null,
    issued_date           datetime     null,
    expiration_date       datetime     null,
    name_record_id        int          null,
    constraint FK_IDENTIFICATION_DOCUMENT_RECORDS_ON_NAME_RECORD
        foreign key (name_record_id) references name_records (id)
);

create table if not exists people
(
    id             varchar(255) not null
        primary key,
    created_at     datetime     null,
    modified_at    datetime     null,
    name_record_id int          not null,
    date_of_birth  date         null,
    constraint FK_PEOPLE_ON_NAME_RECORD
        foreign key (name_record_id) references name_records (id)
);

create table if not exists phone_numbers
(
    id           int auto_increment
        primary key,
    mobile       bit          null,
    country_code varchar(255) null,
    area_code    varchar(255) null,
    prefix       varchar(255) null,
    line         varchar(255) null,
    extension    varchar(255) null
);

create table if not exists contact_information
(
    id                 int auto_increment
        primary key,
    primary_address_id int null,
    primary_number_id  int null,
    primary_email_id   int null,
    access_account_id  int null,
    constraint FK_CONTACT_INFORMATION_ON_ACCESSACCOUNT
        foreign key (access_account_id) references access_accounts (id),
    constraint FK_CONTACT_INFORMATION_ON_PRIMARYADDRESS
        foreign key (primary_address_id) references addresses (id),
    constraint FK_CONTACT_INFORMATION_ON_PRIMARYEMAIL
        foreign key (primary_email_id) references emails (id),
    constraint FK_CONTACT_INFORMATION_ON_PRIMARYNUMBER
        foreign key (primary_number_id) references phone_numbers (id)
);

alter table access_accounts
    add constraint FK_ACCESS_ACCOUNTS_ON_CONTACTINFORMATION
        foreign key (contact_information_id) references contact_information (id);

create table if not exists savings_accounts
(
    id                             varchar(255) not null
        primary key,
    closed                         bit          null,
    access_account                 int          null,
    created_at                     datetime     null,
    modified_at                    datetime     null,
    annual_percentage_rate         int          null,
    minimum_balance_negative       bit          null,
    minimum_balance_dollars        int          null,
    minimum_balance_cents          int          null,
    insufficient_funds_fee_dollars int          null,
    insufficient_funds_fee_cents   int          null,
    constraint FK_SAVINGS_ACCOUNTS_ON_ACCESS_ACCOUNT
        foreign key (access_account) references access_accounts (id)
);

create table if not exists surnames
(
    id          int auto_increment
        primary key,
    name_id     int      null,
    name_order  int      null,
    created_at  datetime null,
    modified_at datetime null,
    constraint FK_SURNAMES_ON_NAME
        foreign key (name_id) references natural_names (id)
);

create table if not exists transaction_statuses
(
    id          int auto_increment
        primary key,
    name        varchar(255) null,
    description varchar(255) null,
    created_at  datetime     null
);

create table if not exists transactions
(
    id             int auto_increment
        primary key,
    origin_id      varchar(255) not null,
    destination_id varchar(255) not null,
    status_id      int          null,
    created_at     datetime     null,
    received_at    datetime     null,
    status_at      datetime     null,
    dollars        int          null,
    cents          int          null,
    constraint FK_TRANSACTIONS_ON_DESTINATION
        foreign key (destination_id) references financial_assets (id),
    constraint FK_TRANSACTIONS_ON_ORIGIN
        foreign key (origin_id) references financial_assets (id),
    constraint FK_TRANSACTIONS_ON_STATUS
        foreign key (status_id) references transaction_statuses (id)
);


