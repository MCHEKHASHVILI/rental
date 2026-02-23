CREATE TABLE branches
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_branches PRIMARY KEY (id)
);

CREATE TABLE construction_equipment_items
(
    id             BIGINT       NOT NULL,
    equipment_type VARCHAR(255) NOT NULL,
    manufacturer   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_construction_equipment_items PRIMARY KEY (id)
);

CREATE TABLE customers
(
    id                      BIGINT AUTO_INCREMENT NOT NULL,
    full_name               VARCHAR(255)          NOT NULL,
    identification_document VARCHAR(255)          NULL,
    contact_information     VARCHAR(255)          NULL,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

CREATE TABLE electronic_device_items
(
    id            BIGINT       NOT NULL,
    category      VARCHAR(255) NOT NULL,
    manufacturer  VARCHAR(255) NOT NULL,
    serial_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_electronic_device_items PRIMARY KEY (id)
);

CREATE TABLE rental_items
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    status    VARCHAR(255)          NOT NULL,
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
    id             BIGINT AUTO_INCREMENT NOT NULL,
    customer_id    BIGINT                NOT NULL,
    branch_id      BIGINT                NOT NULL,
    rental_item_id BIGINT                NOT NULL,
    rented_at      datetime              NOT NULL,
    due_date       datetime              NULL,
    deposit        DECIMAL               NOT NULL,
    monthly_fee    DECIMAL               NOT NULL,
    status         VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_rentals PRIMARY KEY (id)
);

CREATE TABLE vehicle_items
(
    id                  BIGINT       NOT NULL,
    make                VARCHAR(255) NOT NULL,
    model               VARCHAR(255) NOT NULL,
    year_of_manufacture INT          NOT NULL,
    CONSTRAINT pk_vehicle_items PRIMARY KEY (id)
);

ALTER TABLE electronic_device_items
    ADD CONSTRAINT uc_electronic_device_items_serialnumber UNIQUE (serial_number);

ALTER TABLE construction_equipment_items
    ADD CONSTRAINT FK_CONSTRUCTION_EQUIPMENT_ITEMS_ON_ID FOREIGN KEY (id) REFERENCES rental_items (id);

ALTER TABLE electronic_device_items
    ADD CONSTRAINT FK_ELECTRONIC_DEVICE_ITEMS_ON_ID FOREIGN KEY (id) REFERENCES rental_items (id);

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

ALTER TABLE vehicle_items
    ADD CONSTRAINT FK_VEHICLE_ITEMS_ON_ID FOREIGN KEY (id) REFERENCES rental_items (id);