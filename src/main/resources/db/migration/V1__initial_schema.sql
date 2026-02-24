CREATE TABLE branches
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(255)          NOT NULL,
    address VARCHAR(255)          NOT NULL,
    phone   VARCHAR(255)          NULL,
    email   VARCHAR(255)          NULL,
    active  BIT(1)                NOT NULL,
    CONSTRAINT pk_branches PRIMARY KEY (id)
);

CREATE TABLE business_licenses
(
    id               BIGINT       NOT NULL,
    license_type     VARCHAR(255) NOT NULL,
    license_category VARCHAR(255) NOT NULL,
    CONSTRAINT pk_business_licenses PRIMARY KEY (id)
);

CREATE TABLE construction_equipment_items
(
    id             BIGINT       NOT NULL,
    equipment_type VARCHAR(255) NOT NULL,
    manufacturer   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_construction_equipment_items PRIMARY KEY (id)
);

CREATE TABLE construction_rentals
(
    id                         BIGINT       NOT NULL,
    condition_at_rental        VARCHAR(255) NOT NULL,
    requires_licensed_operator BIT(1)       NOT NULL,
    CONSTRAINT pk_construction_rentals PRIMARY KEY (id)
);

CREATE TABLE corporate_customers
(
    id                  BIGINT       NOT NULL,
    company_name        VARCHAR(255) NOT NULL,
    registration_number VARCHAR(255) NOT NULL,
    contact_person_name VARCHAR(255) NULL,
    CONSTRAINT pk_corporate_customers PRIMARY KEY (id)
);

CREATE TABLE corporate_documents
(
    id            BIGINT       NOT NULL,
    company_name  VARCHAR(255) NOT NULL,
    legal_address VARCHAR(255) NOT NULL,
    CONSTRAINT pk_corporate_documents PRIMARY KEY (id)
);

CREATE TABLE customers
(
    id                         BIGINT AUTO_INCREMENT NOT NULL,
    active                     BIT(1)                NOT NULL,
    identification_document_id BIGINT                NOT NULL,
    email                      VARCHAR(255)          NOT NULL,
    phone                      VARCHAR(255)          NULL,
    address                    VARCHAR(255)          NULL,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

CREATE TABLE driver_licenses
(
    id                 BIGINT      NOT NULL,
    license_categories VARCHAR(50) NOT NULL,
    CONSTRAINT pk_driver_licenses PRIMARY KEY (id)
);

CREATE TABLE electronic_device_items
(
    id            BIGINT       NOT NULL,
    category      VARCHAR(255) NOT NULL,
    manufacturer  VARCHAR(255) NOT NULL,
    serial_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_electronic_device_items PRIMARY KEY (id)
);

CREATE TABLE electronic_device_rentals
(
    id                 BIGINT       NOT NULL,
    is_damaged         BIT(1)       NOT NULL,
    damage_description VARCHAR(255) NULL,
    CONSTRAINT pk_electronic_device_rentals PRIMARY KEY (id)
);

CREATE TABLE id_cards
(
    id              BIGINT       NOT NULL,
    personal_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_id_cards PRIMARY KEY (id)
);

CREATE TABLE identification_documents
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    document_number   VARCHAR(255)          NOT NULL,
    issue_date        date                  NOT NULL,
    expiry_date       date                  NULL,
    issuing_authority VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_identification_documents PRIMARY KEY (id)
);

CREATE TABLE individual_customers
(
    id         BIGINT       NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_individual_customers PRIMARY KEY (id)
);

CREATE TABLE individual_documents
(
    id            BIGINT       NOT NULL,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    date_of_birth date         NOT NULL,
    nationality   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_individual_documents PRIMARY KEY (id)
);

CREATE TABLE military_ids
(
    id             BIGINT       NOT NULL,
    `rank`         VARCHAR(255) NOT NULL,
    service_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_military_ids PRIMARY KEY (id)
);

CREATE TABLE passports
(
    id             BIGINT       NOT NULL,
    place_of_birth VARCHAR(255) NOT NULL,
    CONSTRAINT pk_passports PRIMARY KEY (id)
);

CREATE TABLE registration_certificates
(
    id                  BIGINT       NOT NULL,
    registration_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_registration_certificates PRIMARY KEY (id)
);

CREATE TABLE rental_items
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    status    VARCHAR(255)          NOT NULL DEFAULT 'AVAILABLE',
    branch_id BIGINT                NOT NULL,
    CONSTRAINT pk_rental_items PRIMARY KEY (id)
);

CREATE TABLE rental_status_history
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    rental_id  BIGINT                NOT NULL,
    status     VARCHAR(255)          NOT NULL,
    changed_at datetime              NOT NULL,
    reason     VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_rental_status_history PRIMARY KEY (id)
);

CREATE TABLE rentals
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    customer_id      BIGINT                NOT NULL,
    branch_id        BIGINT                NOT NULL,
    rental_item_id   BIGINT                NOT NULL,
    rented_at        datetime              NOT NULL,
    due_date         datetime              NULL,
    deposit          DECIMAL(10, 2)        NOT NULL,
    monthly_fee      DECIMAL(10, 2)        NOT NULL,
    late_fee_per_day DECIMAL(10, 2)        NOT NULL DEFAULT 0.00,
    status           VARCHAR(255)          NOT NULL DEFAULT 'RENTED',
    CONSTRAINT pk_rentals PRIMARY KEY (id)
);

CREATE TABLE payments
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    rental_id      BIGINT                NOT NULL,
    amount         DECIMAL(10, 2)        NOT NULL,
    payment_method VARCHAR(255)          NULL,
    paid_at        datetime              NOT NULL,
    notes          VARCHAR(500)          NULL,
    CONSTRAINT pk_payments PRIMARY KEY (id)
);

CREATE TABLE residence_permits
(
    id          BIGINT       NOT NULL,
    permit_type VARCHAR(255) NOT NULL,
    CONSTRAINT pk_residence_permits PRIMARY KEY (id)
);

CREATE TABLE tax_certificates
(
    id                        BIGINT       NOT NULL,
    tax_identification_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_tax_certificates PRIMARY KEY (id)
);

CREATE TABLE vehicle_items
(
    id                  BIGINT       NOT NULL,
    make                VARCHAR(255) NOT NULL,
    model               VARCHAR(255) NOT NULL,
    year_of_manufacture INT          NOT NULL,
    CONSTRAINT pk_vehicle_items PRIMARY KEY (id)
);

CREATE TABLE vehicle_rentals
(
    id                BIGINT         NOT NULL,
    mileage_at_rental DECIMAL(10, 2) NOT NULL,
    mileage_unit      VARCHAR(255)   NOT NULL DEFAULT 'KM',
    CONSTRAINT pk_vehicle_rentals PRIMARY KEY (id)
);

ALTER TABLE branches
    ADD CONSTRAINT uc_branches_name UNIQUE (name);

ALTER TABLE corporate_customers
    ADD CONSTRAINT uc_corporate_customers_registrationnumber UNIQUE (registration_number);

ALTER TABLE customers
    ADD CONSTRAINT uc_customers_email UNIQUE (email);

ALTER TABLE customers
    ADD CONSTRAINT uc_customers_identification_document UNIQUE (identification_document_id);

ALTER TABLE electronic_device_items
    ADD CONSTRAINT uc_electronic_device_items_serialnumber UNIQUE (serial_number);

ALTER TABLE id_cards
    ADD CONSTRAINT uc_id_cards_personalnumber UNIQUE (personal_number);

ALTER TABLE identification_documents
    ADD CONSTRAINT uc_identification_documents_documentnumber UNIQUE (document_number);

ALTER TABLE military_ids
    ADD CONSTRAINT uc_military_ids_servicenumber UNIQUE (service_number);

ALTER TABLE registration_certificates
    ADD CONSTRAINT uc_registration_certificates_registrationnumber UNIQUE (registration_number);

ALTER TABLE tax_certificates
    ADD CONSTRAINT uc_tax_certificates_taxidentificationnumber UNIQUE (tax_identification_number);

ALTER TABLE business_licenses
    ADD CONSTRAINT FK_BUSINESS_LICENSES_ON_ID FOREIGN KEY (id) REFERENCES corporate_documents (id);

ALTER TABLE construction_equipment_items
    ADD CONSTRAINT FK_CONSTRUCTION_EQUIPMENT_ITEMS_ON_ID FOREIGN KEY (id) REFERENCES rental_items (id);

ALTER TABLE construction_rentals
    ADD CONSTRAINT FK_CONSTRUCTION_RENTALS_ON_ID FOREIGN KEY (id) REFERENCES rentals (id);

ALTER TABLE corporate_customers
    ADD CONSTRAINT FK_CORPORATE_CUSTOMERS_ON_ID FOREIGN KEY (id) REFERENCES customers (id);

ALTER TABLE corporate_documents
    ADD CONSTRAINT FK_CORPORATE_DOCUMENTS_ON_ID FOREIGN KEY (id) REFERENCES identification_documents (id);

ALTER TABLE customers
    ADD CONSTRAINT FK_CUSTOMERS_ON_IDENTIFICATION_DOCUMENT FOREIGN KEY (identification_document_id) REFERENCES identification_documents (id);

ALTER TABLE driver_licenses
    ADD CONSTRAINT FK_DRIVER_LICENSES_ON_ID FOREIGN KEY (id) REFERENCES individual_documents (id);

ALTER TABLE electronic_device_items
    ADD CONSTRAINT FK_ELECTRONIC_DEVICE_ITEMS_ON_ID FOREIGN KEY (id) REFERENCES rental_items (id);

ALTER TABLE electronic_device_rentals
    ADD CONSTRAINT FK_ELECTRONIC_DEVICE_RENTALS_ON_ID FOREIGN KEY (id) REFERENCES rentals (id);

ALTER TABLE id_cards
    ADD CONSTRAINT FK_ID_CARDS_ON_ID FOREIGN KEY (id) REFERENCES individual_documents (id);

ALTER TABLE individual_customers
    ADD CONSTRAINT FK_INDIVIDUAL_CUSTOMERS_ON_ID FOREIGN KEY (id) REFERENCES customers (id);

ALTER TABLE individual_documents
    ADD CONSTRAINT FK_INDIVIDUAL_DOCUMENTS_ON_ID FOREIGN KEY (id) REFERENCES identification_documents (id);

ALTER TABLE military_ids
    ADD CONSTRAINT FK_MILITARY_IDS_ON_ID FOREIGN KEY (id) REFERENCES individual_documents (id);

ALTER TABLE passports
    ADD CONSTRAINT FK_PASSPORTS_ON_ID FOREIGN KEY (id) REFERENCES individual_documents (id);

ALTER TABLE registration_certificates
    ADD CONSTRAINT FK_REGISTRATION_CERTIFICATES_ON_ID FOREIGN KEY (id) REFERENCES corporate_documents (id);

ALTER TABLE rentals
    ADD CONSTRAINT FK_RENTALS_ON_BRANCH FOREIGN KEY (branch_id) REFERENCES branches (id);

ALTER TABLE rentals
    ADD CONSTRAINT FK_RENTALS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);

ALTER TABLE rentals
    ADD CONSTRAINT FK_RENTALS_ON_RENTAL_ITEM FOREIGN KEY (rental_item_id) REFERENCES rental_items (id);

ALTER TABLE rental_items
    ADD CONSTRAINT FK_RENTAL_ITEMS_ON_BRANCH FOREIGN KEY (branch_id) REFERENCES branches (id);

ALTER TABLE rental_status_history
    ADD CONSTRAINT FK_RENTAL_STATUS_HISTORY_ON_RENTAL FOREIGN KEY (rental_id) REFERENCES rentals (id);

ALTER TABLE residence_permits
    ADD CONSTRAINT FK_RESIDENCE_PERMITS_ON_ID FOREIGN KEY (id) REFERENCES individual_documents (id);

ALTER TABLE tax_certificates
    ADD CONSTRAINT FK_TAX_CERTIFICATES_ON_ID FOREIGN KEY (id) REFERENCES corporate_documents (id);

ALTER TABLE vehicle_items
    ADD CONSTRAINT FK_VEHICLE_ITEMS_ON_ID FOREIGN KEY (id) REFERENCES rental_items (id);

ALTER TABLE vehicle_rentals
    ADD CONSTRAINT FK_VEHICLE_RENTALS_ON_ID FOREIGN KEY (id) REFERENCES rentals (id);

ALTER TABLE payments
    ADD CONSTRAINT FK_PAYMENTS_ON_RENTAL FOREIGN KEY (rental_id) REFERENCES rentals (id);
