DELIMITER $$
CREATE TABLE tenant_config
(
    tenant_config_id  BINARY(16) NOT NULL,
    tenant_id        VARCHAR(50) not null unique,
    meta_data        JSON       NOT NULL,
    remark           VARCHAR(500),
    created_by       VARCHAR(20) DEFAULT 'SYSTEM',
    created_date     DATE DEFAULT (CURRENT_DATE),
    updated_by       VARCHAR(20) DEFAULT 'SYSTEM',
    updated_date     DATE DEFAULT (CURRENT_DATE),
    PRIMARY KEY (tenant_config_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8$$

DELIMITER ;
