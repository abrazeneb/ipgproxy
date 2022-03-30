DO
$$
    BEGIN

        CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

        -- #################  table - tenant_config #################
        CREATE TABLE IF NOT EXISTS tenant_config
        (
            tenant_config_id UUID PRIMARY KEY DEFAULT UUID_GENERATE_V4(),
            tenant_id        varchar(50) not null unique,
            meta_data        jsonb       NOT NULL,
            remark           VARCHAR(500),
            created_by       VARCHAR(20),
            created_date     TIMESTAMPTZ,
            updated_by       VARCHAR(20),
            updated_date     TIMESTAMPTZ
        );

    END
$$;
